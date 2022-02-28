# Car Service Web Application
### Web application for car service with several features. 
This project was made in Java Bootcamp course from InfoShareAcademy.
#### Technologies used in this project:
* Spring Boot,
* Spring MVC,
* Thymeleaf,
* Spring Data,
* Spring Security,
* JPA,
* HTTP,
* CSS,
* Bootstrap,

#### Delete all existing docker images:
* `docker stop $(docker ps -aq)`
* `docker rm $(docker ps -aq)`
#### Docker create image:
* `docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=carservice --rm -d mysql`
#### Docker compose:
* `docker-compose up --build`
* `docker-compose down1`
* `docker-compose start`
* `docker-compose stop`
#### 