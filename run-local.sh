#!/usr/bin/env sh

cd mso-monitor-server
mvn clean package

cd ..

 cd mso-discovery-service
 mvn clean package

cd ..

cd mso-usuarios
mvn clean package 

cd ..

cd mso-mensajes
mvn clean package 

cd ..

cd mso-contactos
mvn clean package

docker-compose up --build

docker-compose stop
docker-compose kill
docker-compose rm -f
