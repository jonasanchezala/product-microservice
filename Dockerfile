# Build Stage
FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /ProductMicroservice
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package

# Run Stage
FROM openjdk:8u201-jdk-alpine3.9
LABEL maintainer="Masivian Group"
WORKDIR WORKSPACE /ProductMicroservice
COPY --from=builder /ProductMicroservice/target/product-0.0.1-SNAPSHOT.jar .
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar product-0.0.1-SNAPSHOT.jar