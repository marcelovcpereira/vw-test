#!/bin/bash


sudo snap install docker
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