cd core-application
mvn clean test install

cd ../web-api
mvn clean package

java -Dspring.profiles.active=container -jar target/web-api-1.0.0.jar

