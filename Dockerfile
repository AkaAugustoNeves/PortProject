FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/PortProject.war /app/PortProject.war

EXPOSE 777

CMD ["java", "-jar", "PortProject.war", "--spring.profiles.active=homolog"]