# vagrant-linux


https://seven.centos.org/2016/10/updated-centos-vagrant-images-available-v1609-01/
<br/>根據官方發布的消息得知Centos預設在處理shared folder有些問題要先在自己機器安裝vagrant-vbguest
<br/>https://github.com/dotless-de/vagrant-vbguest<br/>
https://www.vagrantup.com/docs/synced-folders/nfs.html

Usage
========================



General Deploying Jboss EAP 7.0
<br/>
ansible-playbook  /vagrant/ansible/vip-general.yml  -i /vagrant/ansible/hosts/sit
<br/>
ansible-playbook /vagrant/ansible/jenkins.yml -i /vagrant/ansible/hosts/sit
<br/>
ansible-playbook /vagrant/ansible/docker.yml -i /vagrant/ansible/hosts/sit
