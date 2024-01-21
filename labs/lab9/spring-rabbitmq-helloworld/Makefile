build:
	mvn package

send: build
	java -jar target/spring-rabbitmq-helloworld-1.0.jar --spring.profiles.active=$(env),hello,sender

receive: build
	java -jar target/spring-rabbitmq-helloworld-1.0.jar --spring.profiles.active=$(env),hello,receiver
