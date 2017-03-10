        sh "sudo cp nginx-includes.conf /data/nginx/includes/${serviceName}.conf"
        sh "sudo /usr/local/bin/consul-template \
            -consul localhost:8500 \
            -template \"nginx-upstreams-${color}.ctmpl:/data/nginx/upstreams/${serviceName}.conf:docker kill -s HUP nginx\" \
            -once"
        sh "curl -X PUT -d ${color} http://localhost:8500/v1/kv/${serviceName}/color"
    }
}

def getCurrentColor(serviceName, prodIp) {
    try {
        return sendHttpRequest("http://${prodIp}:8500/v1/kv/${serviceName}/color?raw")
    } catch(e) {
        return ""
    }
}

def getNextColor(currentColor) {
    if (currentColor == "blue") {
        return "green"
    } else {
        return "blue"
    }
}

def getAddress(serviceName, prodIp, color) {
    def response = sendHttpRequest("http://${prodIp}:8500/v1/catalog/service/${serviceName}-${color}")
    println   "http://${prodIp}:8500/v1/catalog/service/${serviceName}-${color}"
    println   "response:  ${response}"
    def result = new JsonSlurper().parseText(response)[0]
    return result.ServiceAddress + ":" + result.ServicePort
}

def sendHttpRequest(url) {
    def get = new GetMethod(url)
    new HttpClient().executeMethod(get)
    def response = get.getResponseBody()
    get.releaseConnection()
    return new String(response)
}

def updateChecks(serviceName, swarmNode) {
    stage "Update checks"
    stash includes: 'consul_check.ctmpl', name: 'consul-check'
    node(swarmNode) {
        unstash 'consul-check'
        sh "sudo /usr/local/bin/consul-template  -consul localhost:8500 \
            -template 'consul_check.ctmpl:/data/consul/config/${serviceName}.json:killall -HUP consul' \
            -once"
    }
}

def getInstances(serviceName, swarmIp) {
    return sendHttpRequest("http://${swarmIp}:8500/v1/kv/${serviceName}/instances?raw")
}

def putInstances(serviceName, swarmIp, instances) {
    sh "curl -X PUT -d ${instances} \
        ${swarmIp}:8500/v1/kv/${serviceName}/instances"
}

return this;
