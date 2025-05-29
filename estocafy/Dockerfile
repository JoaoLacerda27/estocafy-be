# Etapa de build
FROM openjdk:21-jdk-slim as builder
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Constrói o JAR (ajuste para Maven se necessário)
RUN ./gradlew clean build -x test

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia o JAR compilado da etapa anterior
COPY --from=builder /app/build/libs/*.jar app.jar

# Expondo a porta da aplicação
EXPOSE 8080

# Entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
