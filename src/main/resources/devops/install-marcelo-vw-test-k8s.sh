#!/bin/bash
###########################################
#       INSTALLATION WITH KUBERNETES      #
###########################################
sudo snap install docker
sudo snap install microk8s --classic
sudo snap install kubectl --classic
echo "export PATH=/snap/bin:$PATH" >> /etc/profile && source /etc/profile
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
#kubectl port-forward svc/marcelo-vw-test 8080:8080