# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  if (/cygwin|mswin|mingw|bccwin|wince|emx/ =~ RUBY_PLATFORM) != nil
    config.vm.synced_folder ".", "/vagrant", mount_options: ["dmode=700,fmode=600"]
  else
    config.vm.synced_folder ".", "/vagrant"
  end
 # config.vm.box ="ubuntu/trusty64"
  
  config.vm.define "vip-devops" do |d| 
    d.vm.box = "bento/centos-7.3"
    d.vm.hostname = "vip-devops"
    d.vm.network "public_network", bridge: "eno4", ip: "192.168.57.70", auto_config: "false", netmask: "255.255.255.0" , gateway: "192.168.57.1"
#   default_router = "192.168.57.1"
#   d.vm.provision :shell, inline: "ip route delete default 2>&1 >/dev/null || true; ip route add default via #{default_router}"
    d.vm.provision :shell , inline: "systemctl restart network"
    d.vm.provision :shell, path: "scripts/bootstrap4CentOs_ansible.sh"
#    d.vm.provision :shell, path: "scripts/bootstrap_ansible.sh"
    d.vm.provision :shell, inline: "PYTHONUNBUFFERED=1 ansible-playbook /vagrant/ansible/vip-devops.yml -c local"
    
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end
  config.vm.define "vip-eip" do |d| 
    d.vm.box = "bento/centos-7.3"
    d.vm.hostname = "vip-eip"
    d.vm.network "public_network", bridge: "eno4", ip: "192.168.57.71", auto_config: "false", netmask: "255.255.255.0" , gateway: "192.168.57.1"
#     default_router = "192.168.57.1"
#     d.vm.provision :shell, inline: "ip route delete default 2>&1 >/dev/null || true; ip route add default via #{default_router}"
    d.vm.provision :shell , inline: "systemctl restart network"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end 
  config.vm.define "vip-ies-o" do |d|
    d.vm.box = "bento/centos-7.3"
    d.vm.hostname = "vip-ies-o"
    d.vm.network "public_network", bridge: "eno4", ip: "192.168.57.72", auto_config: "false", netmask: "255.255.255.0" , gateway: "192.168.57.1"
#     default_router = "192.168.57.1"
#     d.vm.provision :shell, inline: "ip route delete default 2>&1 >/dev/null || true; ip route add default via #{default_router}"
    d.vm.provision :shell , inline: "systemctl restart network"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end
  config.vm.define "vip-ies-m" do |d| 
    d.vm.box = "bento/centos-7.3"
    d.vm.hostname = "vip-ies-m"
    d.vm.network "public_network", bridge: "eno4", ip: "192.168.57.73", auto_config: "false", netmask: "255.255.255.0" , gateway: "192.168.57.1"
#     default_router = "192.168.57.1"
#     d.vm.provision :shell, inline: "ip route delete default 2>&1 >/dev/null || true; ip route add default via #{default_router}"
    d.vm.provision :shell , inline: "systemctl restart network"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end
  config.vm.define "vip-ies-i" do |d| 
    d.vm.box = "bento/centos-7.3"
    d.vm.hostname = "vip-ies-i"
    d.vm.network "public_network", bridge: "eno4", ip: "192.168.57.74", auto_config: "false", netmask: "255.255.255.0" , gateway: "192.168.57.1"
#     default_router = "192.168.57.1"
#     d.vm.provision :shell, inline: "ip route delete default 2>&1 >/dev/null || true; ip route add default via #{default_router}"
    d.vm.provision :shell , inline: "systemctl restart network"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end
  config.vm.define "vip-npp" do |d| 
    d.vm.box = "bento/centos-7.3"
    d.vm.hostname = "vip-npp"
    d.vm.network "public_network", bridge: "eno4", ip: "192.168.57.75", auto_config: "false", netmask: "255.255.255.0" , gateway: "192.168.57.1"
#     default_router = "192.168.57.1"
#     d.vm.provision :shell, inline: "ip route delete default 2>&1 >/dev/null || true; ip route add default via #{default_router}"
    d.vm.provision :shell , inline: "systemctl restart network"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end
  config.vm.define "vip-sso-ipki" do |d|
    d.vm.box = "bento/centos-7.3"
    d.vm.hostname = "vip-sso-ipki"
    d.vm.network "public_network", bridge: "eno4", ip: "192.168.57.76", auto_config: "false", netmask: "255.255.255.0" , gateway: "192.168.57.1"
#    default_router = "192.168.57.1"
#     d.vm.provision :shell, inline: "ip route delete default 2>&1 >/dev/null || true; ip route add default via #{default_router}"
    d.vm.provision :shell , inline: "systemctl restart network"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end   
  if Vagrant.has_plugin?("vagrant-cachier")
    config.cache.scope = :box
  end
end
