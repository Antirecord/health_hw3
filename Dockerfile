FROM openjdk:11
ARG JAR_FILE=target/health_check-0.0.1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
