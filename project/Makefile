default:
	echo "Make Rules: starbucks-network, starbucks-api-run, cashier-nodejs-run, starbucks-app-run"

starbucks-network:
	docker network create --driver bridge starbucks

starbucks-api-run: 
	docker run --network starbucks --name spring-starbucks-api -td -p 8080:8080 paulnguyen/spring-starbucks-api:v3.1	

cashier-nodejs-run:
	docker run --network starbucks --name starbucks-nodejs -p 90:9090  \
	-e "api_endpoint=http://spring-starbucks-api:8080" -td paulnguyen/starbucks-nodejs:v3.0

starbucks-app-run: 
	java -cp starbucks-app.jar \
		-Dapiurl="http://34.30.75.35/api" \
		-Dapikey="Zkfokey2311" \
		-Dregister="5012349" \
		starbucks.Main 2>debug.log



starbucks-api-run-2: 
	docker run --network starbucks --name spring-starbucks-api -td -p 8080:8080 spring-starbucks-api

cashier-spring-run:
	docker run --network starbucks --name starbucks-cashier-starbucks -p 90:9090  \
	-e "MYSQL_HOST=mysql" \
	-e "api_endpoint=http://localhost:8000/api" \
	-td spring-cashier-starbucks


mysql-up:
	docker-compose up -d mysql


# docker run -d --name kong \
# 	--network=starbucks \
# 	-e "KONG_DATABASE=off" \
# 	-e "KONG_PROXY_ACCESS_LOG=/dev/stdout" \
# 	-e "KONG_ADMIN_ACCESS_LOG=/dev/stdout" \
# 	-e "KONG_PROXY_ERROR_LOG=/dev/stderr" \
# 	-e "KONG_ADMIN_ERROR_LOG=/dev/stderr" \
# 	-e "KONG_ADMIN_LISTEN=0.0.0.0:8001, 0.0.0.0:8444 ssl" \
# 	-p 80:8000 \
# 	-p 443:8443 \
# 	-p 8001:8001 \
# 	-p 8444:8444 \
# 	kong:2.4.0

# http :8001/config config=@kong.yaml
# docker exec -it kong kong reload

# http localhost/api/ping
# http localhost/api/ping apikey:2H3fONTa8ugl1IcVS7CjLPnPIS2Hp9dJ

# docker run --platform=linux/amd64 -d --network starbucks --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0