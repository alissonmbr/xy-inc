# xy-inc
GPS localization by a point of interest

docker build -t poi_postgresql .
docker run --rm -P -p 5433:5432 --name poi_db poi_postgresql

mvn clean package
java -jar target/poi-1.0-SNAPSHOT.jar
