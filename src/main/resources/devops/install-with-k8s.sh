#!/bin/bash
sudo mkdir /scripts
sudo chmod -R 777 /scripts
git clone https://github.com/marcelovcpereira/vw-test /scripts
sh /scripts/src/main/resources/devops/install-marcelo-vw-test-k8s.sh
kubectl apply -f /scripts/src/main/resources/devops/k8s/deployment.yaml
kubectl apply -f /scripts/src/main/resources/devops/k8s/service.yaml
sleep 15
kubectl port-forward svc/marcelo-vw-test 8888:8080