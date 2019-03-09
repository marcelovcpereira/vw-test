FROM java:openjdk-8-jdk-alpine
MAINTAINER Marcelo Pereira <marcelovcpereira@gmail.com>

RUN mkdir /scripts

COPY marcelo-vw-test-release.jar /scripts/marcelo-vw-test.jar
COPY AirQualityUCI.csv /scripts

COPY docker-entrypoint.sh /scripts/docker-entrypoint.sh
RUN ["chmod", "+x", "/scripts/docker-entrypoint.sh"]

EXPOSE 8080

ENTRYPOINT ["/scripts/docker-entrypoint.sh"]