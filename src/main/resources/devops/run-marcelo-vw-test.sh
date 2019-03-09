#!/bin/bash
###########################################
#    INSTALLATION WITH DOCKER COMPOSE     #
###########################################
sudo snap install docker
sudo docker build -t marcelo-vw-test:latest ./docker
sudo docker-compose -f ./docker/docker-compose.yml up

###########################################
#       INSTALLATION WITH KUBERNETES      #
###########################################
#sudo snap install microk8s --classic
#sudo snap install kubectl --classic
#echo "export PATH=/snap/bin:$PATH" >> /etc/profile && source /etc/profile
#kubectl apply -f k8s/deployment.yaml
#kubectl apply -f k8s/service.yaml
#kubectl port-forward svc/marcelo-vw-test 8080:8080