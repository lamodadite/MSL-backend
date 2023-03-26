FROM openjdk:19-alpine

ARG JAR_PATH=./build/libs

# JAR 파일 메인 디렉토리에 복사
COPY ${JAR_PATH}/MSL-back-0.0.1-SNAPSHOT.jar ${JAR_PATH}/MSL-back-0.0.1-SNAPSHOT.jar

# 시스템 진입점 정의
ENTRYPOINT ["java","-jar","./build/libs/MSL-back-0.0.1-SNAPSHOT.jar"]