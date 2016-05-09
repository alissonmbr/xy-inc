# POI (Point of Interest)
Localização de pontos de interesse 

O projeto foi implementado usando Java no back-end e usando o banco de dados PostgreSQL. O banco de dados está em um container Docker. A compilação é feita usando o maven e é executado usando spring-boot. O testes unitários são feitos usando o jUnit com banco em memória e mock dos serviços Rest.

### Dependências

1. [Maven](https://maven.apache.org/) versão 3.x.x
2. Java 7
3. [Docker](https://www.docker.com/)

### Instalação

#### Banco de dados PostgreSQL usando o docker

Pela linha de comando entre no diretório que esta o Dockerfile e execute:
```
docker build -t poi_postgresql .
```

#### Compilando a aplicação usando o maven

Pela linha de comando entre no diretório poi onde esta o pom.xml e execute:
```
mvn clean package
```

### Executando

##### 1- Suba o banco de dados usando o seguinte comando no terminal:
```
docker run --rm -P -p 5433:5432 --name poi_db poi_postgresql
```

##### 2- Na pasta target execute:
```
java -jar poi-1.0.jar
```

#### Listando todos os POIs:
Em qualquer cliente use a url: `http://localhost:9000/all`

#### Adicionando um POI:
Em qualquer cliente use a url: `http://localhost:9000/add/{name}/{x}/{y}` onde **name** é o nome do POI e **x** e **y** são as coordenadas

### Listando POIs por referência
Em qualquer cliente use a url: `http://localhost:9000/reference/{x}/{y}/{d}` onde **x** e **y** são as coordenadas e **d** é a distância máxima
