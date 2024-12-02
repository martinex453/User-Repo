FROM openjdk:17
ARG JAR_FILE=target/User.jar
COPY ${JAR_FILE} User.jar
ENTRYPOINT ["java","-jar", "/User.jar"]