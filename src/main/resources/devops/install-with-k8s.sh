#!/bin/bash
git clone https://github.com/marcelovcpereira/vw-test
cd vw-test/src/main/resources/devops
sh install-marcelo-vw-test-k8s.sh
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl port-forward svc/marcelo-vw-test 8888:8080