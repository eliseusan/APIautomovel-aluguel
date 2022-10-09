FROM openjdk
COPY . .
ENTRYPOINT ["java", "jar","automovel-aluguel-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080