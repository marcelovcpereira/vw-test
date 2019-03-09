#!/bin/bash
sudo mkdir /scripts
sudo chmod -R 777 /scripts
git clone https://github.com/marcelovcpereira/vw-test /scripts


sudo snap install docker
sudo snap install microk8s --classic
sudo snap install kubectl --classic
sudo chmod -R 777 /etc/profile
sudo echo "export PATH=/snap/bin:$PATH" >> /etc/profile && source /etc/profile

kubectl apply -f /scripts/src/main/resources/devops/k8s/deployment.yaml
kubectl apply -f /scripts/src/main/resources/devops/k8s/service.yaml
sleep 60
kubectl port-forward svc/marcelo-vw-test 8888:8080