FROM openjdk:19-alpine
COPY build/libs/MSL-back-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]