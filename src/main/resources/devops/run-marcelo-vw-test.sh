#!/bin/bash


apt-get update
apt-get install sudo -y

sudo apt-get remove docker docker-engine docker.io lxc-docker
sudo apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"

sudo apt-get update

sudo apt-get install -y docker-ce docker-ce-cli containerd.io

#snap install docker
sudo docker build -t marcelo-vw-test:latest ./docker
sudo docker-compose -f ./docker/docker-compose.yml up

###########################################
#In the future we could improve to use K8S#
###########################################
#sudo snap install microk8s --classic
#sudo snap install kubectl
#echo "export PATH=/snap/bin:$PATH" >> /etc/profile && source /etc/profile
#kubectl apply -f k8s/deployment.yaml
#kubectl apply -f k8s/service.yaml
#kubectl port-forward svc/marcelo-vw-test 8080:8080

#tar -xvzf marcelo-vw-test.tar.gz