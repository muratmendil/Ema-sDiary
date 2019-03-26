FROM java:8
VOLUME /tmp
ARG JAR_FILE
COPY ./target/ema-boot-0.1.0.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
