# vw-test

This project is the solution for the Volkswagen test challenge

This project is a Docker Compose application, made of 2 integrated Services:

Marcelo Mysql, that runs an empty mysql container image to persist measures data.
Marcelo VW Test, that runs a dockerized SpringBoot application that reads measures information from UCI repository (http://archive.ics.uci.edu/ml/datasets/air+quality)
as a CSV file.
Then it parses the file, validates the rows and saves all measures in the Mysql instance.
The service Marcelo VW Test also exposes a webserver at port 8080 for showing data from the database.

The steps to execute the application are as follows:

```
git clone https://github.com/marcelovcpereira/vw-test
cd vw-test/src/main/resources/devops
```

Then you can install using Docker Compose:
```
sh run-marcelo-vw-test.sh
```

Of Kubernetes:
```
sh install-marcelo-vw-test-k8s.sh
```
Important:
The installation script requires UBUNTU with SNAP installed

After application boots up, you can acess the dashboard at:
```
http://localhost:8080/getMVCDashboard
```


If you do not have a browser to render the HTML, you can also query the REST endpoints:
```
curl -XGET http://localhost:8080/getNO2Measures
This one, returns all measures (full objects) that contains NO2 concentration above standards

curl -XGET http://localhost:8080/getNO2Days
This one, returns the dates (in the format dd/mm/yyyy) that contains NO2 concentration above standards

curl -XGET http://localhost:8080/getNO2DaysCount
This one, return the amount of dates that contains NO2 concentration above standards
```

Details:

Due to time, I preferred to create one App for handling multiple steps instead of separate the concerns in different layers.
So the marcelo-vw-test container is responsible for:
1) loading the CSV file
2) parsing/validating rows into valid Measures
3) persist measures in an external DBMS (in this case MySQL 5.6)
4) expose REST and MVC endpoints for collecting/showing data
5) Depending where you run the application, if you want external access to it, it may be necessary further configuration
like opening ports or external ips. For accessing locally it should be straightforward.

Possible improvements:
- Decoupling frontend dashboard as an APP for consuming the REST Controller endpoints (instead of integrated MVC)
- Usage of Kubernetes instead of docker-compose (Or maybe docker-swarm)
- In case of using the recipes of K8s we could use Helm for automating even further the deployment process
- Usage of TLS for enabling HTTPS for production ready version
- Tests
- Exposing the app image (marcelo-vw-test:latest) in an external Registry instead of building it during the process
- Loading CSV file from the HTTP endpoint instead of building the image containing the file
- Switching installation script for a better automation like Ansible or Saltstack