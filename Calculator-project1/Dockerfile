ARG JAVA_VERSION=8
FROM eclipse-temurin:${JAVA_VERSION}-jdk-alpine AS builder

WORKDIR /app

COPY src/ ./src/
COPY MANIFEST.MF ./MANIFEST.MF

RUN mkdir bin

RUN find src -type f -path "src/test" -prune -o -name "*.java" -print | xargs javac -d bin

RUN jar cfm Calculator.jar MANIFEST.MF -C bin .

FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine

WORKDIR /app

COPY --from=builder /app/Calculator.jar /app/Calculator.jar

CMD ["java", "-jar", "/app/Calculator.jar"]