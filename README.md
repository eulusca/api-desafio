##  API RESTful - Desafio


### 💻 Techs
- [x] Kotlin
- [x] Maven
- [x] Docker
- [x] Spring Boot

## 🚀 Executando

### - Gradle

Executar o seguinte comando:
```
gradle build

```

Acessar em http://localhost:8080

### - Docker

#### Build Gradle

```
./gradlew build
```

#### Imagem Docker 

```
docker image build -t api:0.0.1 .
```

#### Run 🚀🚀

```
docker container run --name api -d -p 8080:8080 api:0.0.1 
```

