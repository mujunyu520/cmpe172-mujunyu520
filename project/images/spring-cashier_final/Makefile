all: clean

clean:
	mvn clean

compile:
	mvn compile

run: compile
	mvn spring-boot:run

build:
	mvn package


run-jar: build
	java -jar target/spring-cashier.jar

# MySQL DB

mysql:
	docker run --platform=linux/amd64 -d --network spring-cashier --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=midterm mysql:8.0

mysql-shell:
	docker exec -it mysql bash

docker-build: build
	docker build --platform=linux/amd64 -t spring-cashier .
	docker images

docker-run: docker-build
	docker run --platform=linux/amd64 --network spring-cashier -e "MYSQL_HOST=mysql" --name spring-cashier -td -p 8080:8080 spring-cashier

docker-clean:
	docker stop spring-cashier
	docker rm spring-cashier
	docker rmi spring-cashier

# Compose

network-ls:
	docker network ls

network-create:
	docker network create --driver bridge $(network)

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale spring-cashier=2 -d

lb-up:
	docker-compose up -d lb

gumball-up:
	docker-compose up -d spring-cashier

mysql-up:
	docker-compose up -d mysql

# redis-up:
#     docker-compose up -d redis
# docker run -p 6379:6379 --name my-redis-container -d redis
# redis-cli
# KEYS "spring:session:sessions:*"

compose-down:
	docker-compose down

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost

