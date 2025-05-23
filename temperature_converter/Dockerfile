ARG JAVA_VERSION=21
FROM eclipse-temurin:${JAVA_VERSION}-jdk-alpine AS builder

WORKDIR /app

COPY src/ ./src/
COPY MANIFEST.MF ./MANIFEST.MF

RUN mkdir bin
RUN find src -type f -path "src/test" -prune -o -name "*.java" -print | xargs javac -d bin

RUN jar cfm Main.jar MANIFEST.MF -C bin .

FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine

WORKDIR /app

COPY --from=builder /app/Main.jar /app/Main.jar

CMD ["java", "-jar", "/app/Main.jar"]