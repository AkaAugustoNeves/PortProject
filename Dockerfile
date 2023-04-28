FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/PortProject.jar /app/PortProject.jar

EXPOSE 777

CMD ["java", "-jar", "PortProject.jar", "--spring.profiles.active=homolog"]