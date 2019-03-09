#!/bin/bash
###########################################
#       INSTALLATION WITH KUBERNETES      #
###########################################
sudo snap install docker
sudo snap install microk8s --classic
sudo snap install kubectl --classic
sudo echo "export PATH=/snap/bin:$PATH" >> /etc/profile && source /etc/profile