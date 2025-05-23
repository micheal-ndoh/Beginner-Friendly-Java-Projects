ARG JAVA_VERSION=21
FROM eclipse-temurin:${JAVA_VERSION}-jdk-alpine AS builder

WORKDIR /app

COPY src/ ./src/
COPY MANIFEST.MF ./MANIFEST.MF

RUN mkdir bin
RUN javac -d bin $(find src -name "*.java")

RUN jar cfm AtmSimulator.jar MANIFEST.MF -C bin .

FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine

WORKDIR /app

COPY --from=builder /app/AtmSimulator.jar /app/AtmSimulator.jar

CMD ["java", "-jar", "/app/AtmSimulator.jar"]