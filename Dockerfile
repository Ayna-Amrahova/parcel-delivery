FROM openjdk:8-jdk-alpine
LABEL maintainer="ayna.amrah@gmail.com"
VOLUME /main-app
ADD build/libs/Guavapay-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]