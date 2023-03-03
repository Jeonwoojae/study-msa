FROM openjdk:11-jre-slim-buster
VOLUME /tmp
COPY build/libs/discoveryservice-1.0.jar DiscoveryService.jar
ENTRYPOINT ["java","-jar","DiscoveryService.jar"]