# Usa uma imagem oficial do Java 17 (leve) como base
FROM eclipse-temurin:21-jre-alpine 
# Define o diretório de trabalho dentro do container
WORKDIR /app 
# Copia o arquivo .jar compilado pelo Maven para dentro do container 
# (O nome do arquivo .jar dependerá do pom.xml da equipe)
COPY target/gc-t-2026-1-cplovers-0.0.1-SNAPSHOT.jar app.jar 
# Comando que será executado quando o container iniciar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]