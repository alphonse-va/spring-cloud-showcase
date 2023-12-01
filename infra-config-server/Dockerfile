FROM openjdk:17-jdk-alpine
MAINTAINER Alphonse Van Assche <alphonse.vanassche@gmail.com>
ADD target/infra-config-server.jar infra-config-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/infra-config-server.jar"]