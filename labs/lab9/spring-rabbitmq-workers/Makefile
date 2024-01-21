build:
	mvn package

send: build
	java -jar target/spring-rabbitmq-workers-1.0.jar  --spring.profiles.active=$(env),work-queues,sender

receive: build
	java -jar target/spring-rabbitmq-workers-1.0.jar --spring.profiles.active=$(env),work-queues,receiver