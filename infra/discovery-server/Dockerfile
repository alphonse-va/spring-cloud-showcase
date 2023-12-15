FROM openjdk:21-ea-1-jdk-bullseye
MAINTAINER Alphonse Van Assche <alphonse.vanassche@gmail.com>
#RUN apk --no-cache add curl
ADD target/discovery-server.jar discovery-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/discovery-server.jar"]