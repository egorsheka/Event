FROM maven:3.6.3-jdk-11 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY ../../../pom.xml /workspace
COPY ../.. workspace/src
RUN mvn -f pom.xml clean package spring-boot:repackage

FROM openjdk:11
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]