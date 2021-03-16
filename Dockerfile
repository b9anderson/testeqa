FROM maven:lastest
MAINTAINER Anderson Barbosa
COPY . /var/www
WORKDIR /var/www
RUN mvn clean test
EXPOSE 8080