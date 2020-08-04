#!/bin/bash
echo "welcome"
#
#jsf_primefaces
#
echo "jsf_primefaces"
echo "stop container and remove image"
docker container rm -f jsf_primefaces
docker image rm -f jsf_primefaces
echo "Go to Folder Script File And Dockerfile"
cd ~/mitrphol/basic_jsf_primefaces/jsf_primefaces/
echo "clean"
mvn clean install
echo "compile package"
mvn package
echo "build image from docker file"
docker build -t jsf_primefaces .
echo "run image to container"
docker run --restart=always --name jsf_primefaces -p 9999:8080 -d jsf_primefaces
echo "finish step"