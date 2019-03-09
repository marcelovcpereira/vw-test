#!/bin/bash
###########################################
#    INSTALLATION WITH DOCKER COMPOSE     #
###########################################
sudo snap install docker
sudo docker build -t marcelo-vw-test:latest ./docker
sudo docker-compose -f ./docker/docker-compose.yml up