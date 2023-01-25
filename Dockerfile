FROM amazoncorretto:19
WORKDIR /app/
COPY . /app/
ENTRYPOINT [ "./mvnw", "spring-boot:run" ]
#ENTRYPOINT [ "java", "-jar", "target/spring-boot-docker-0.0.1-SNAPSHOT.jar" ]