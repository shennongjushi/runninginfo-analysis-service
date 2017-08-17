# runninginfo-analysis-service
## MySQL setting
### docker-compose.yml
```
mysql:
  image: mysql:5.7.19
  environment:
    MYSQL_ROOT_PASSWORD: root
    MYSQL_DATABASE: test
  ports:
    - "3306:3306"
```
command
```
docker-compose up
```
### application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create
```
### access MySQL
password is root
```
docker exec -it runninginfoanalysisservice_mysql_1 bash
mysql -u root -p
```
## Start the Application
```
mvn clean install
cd target
java -jar runninginfo-analysis-service-1.0.0.BUILD-SNAPSHOT.jar 
```
## Postman
### upload the initial data
http://localhost:8080/upload (POST, json inputs)
### return value by healthWarningLevel desc order
http://localhost:8080/view?page=0 (each page size is 2)
### delete by running ID
http://localhost:8080/delete/id/xxxxx
