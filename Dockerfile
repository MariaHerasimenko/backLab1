FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/BackLab1.jar BackLab1.jar
ENTRYPOINT ["java", "-jar", "/BackLab1.jar"]