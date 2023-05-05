FROM openjdk:17
EXPOSE 8080:8080
#WORKDIR ymakwara/Documents/SolarWeb
COPY target/SolarWeb-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]