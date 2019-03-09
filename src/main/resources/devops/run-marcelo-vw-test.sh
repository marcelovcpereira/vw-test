#!/bin/bash
snap install microk8s --classic
snap install kubectl
snap install docker
echo "export PATH=/snap/bin:$PATH" >> /etc/profile && source /etc/profile

docker build -t marcelo-vw-test:latest ./docker


kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl port-forward svc/marcelo-vw-test 8080:8080