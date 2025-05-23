ARG JAVA_VERSION=21
FROM eclipse-temurin:${JAVA_VERSION}-jdk-alpine AS builder

WORKDIR /app

COPY src/ ./src/
COPY MANIFEST.MF ./MANIFEST.MF

RUN mkdir bin
RUN find src -type f -path "src/test" -prune -o -name "*.java" -print | xargs javac -d bin

RUN jar cfm LibraryManager.jar MANIFEST.MF -C bin .

FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine

WORKDIR /app

COPY --from=builder /app/LibraryManager.jar /app/LibraryManager.jar

CMD ["java", "-jar", "/app/LibraryManager.jar"]