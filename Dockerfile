FROM openjdk:19-alpine
COPY MSL-back/build/libs/MSL-back-0.0.1-SNAPSHOT.jar MSL-back-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","MSL-back-0.0.1-SNAPSHOT.jar"]