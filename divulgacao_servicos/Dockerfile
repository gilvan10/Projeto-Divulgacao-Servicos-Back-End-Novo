# Etapa 1 — Build (caso você use Maven)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia pom.xml e dependências primeiro (melhor para cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código
COPY src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Etapa 2 — Runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Porta exposta (ajuste conforme seu projeto)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]