# CMPE 172 - Lab #9 Notes
## Messaging with RabbitMQ


For examinating the part I of the lab 9, we need to set up the environment as below pictures:!

[dependecis](https://user-images.githubusercontent.com/60667298/236927500-cba25d26-acb4-4442-b9d1-23ded0a67278.png)



![WX20230507-225350](https://user-images.githubusercontent.com/60667298/236927587-0fd7873a-b692-4436-80e9-52507e55df69.png)


When all basic setting up is finished, we generate the docker network using the command that the rabbitmq image docker file is from the "rabbitmq docker" for easily running the program.
![docker run rabbitmq](https://user-images.githubusercontent.com/60667298/236927693-1485c911-1016-4316-98e6-9e4de45299a3.png)
![docker with rabbitmq](https://user-images.githubusercontent.com/60667298/236927705-5e937d8c-c230-4b2e-bb35-095d78862242.png)

For checking the docker image is running successfully, we enter the "localhost:8080" into the browser to open the rabbitmq.
![localhost-8080](https://user-images.githubusercontent.com/60667298/236927763-ae18b8f8-574f-4bb9-9fe3-930c84c1f478.png)
If the rabbitmq is working, we make a jar file to execute the program through the Maven.!

[install jar file](https://user-images.githubusercontent.com/60667298/236927813-aa20405f-85a6-464e-8182-f2d130d88288.png)


When the program run at least one time, the rabbitmq shows the overview of the queues. That is the trace that the program sends the message to the rabbitmq into the queue and then the program receives the message from the rabbitmq message queue.
![RabbitMq QUeues](https://user-images.githubusercontent.com/60667298/236927883-e2bdcd67-830e-4562-aa39-835b8302f402.png)
![receives the messhae from rabbitmq](https://user-images.githubusercontent.com/60667298/236927911-35de3ede-390e-4b3a-983c-48bf44d07f52.png)

Full screen

![full screen of rabbit](https://user-images.githubusercontent.com/60667298/236927985-246cacc4-965d-4fda-94d5-1fa78a2b56a1.png)

## RabbitMQ Tutorial - Hello World

For examinating the part II of the lab 9, we need to set up the environment as below pictures and proerties:
![hello world -1 ](https://user-images.githubusercontent.com/60667298/236928091-0dcbbecd-2cc7-460e-9362-8c8d620eec1f.png)




![properties-3](https://user-images.githubusercontent.com/60667298/236928152-0ed5c7ca-02cf-44c2-9ebd-f3e0dd8be13c.png)

![properties -4](https://user-images.githubusercontent.com/60667298/236928161-6c79b8a8-0162-478f-8344-24e58475cbe5.png)

![properties-5](https://user-images.githubusercontent.com/60667298/236928172-71ad76cd-bf62-4c42-81ab-890b1190e52a.png)
For examinating the part II of the lab 9, we need to set up the environment as below pictures:

![spring-rabbitmq helloworld](https://user-images.githubusercontent.com/60667298/236928233-c0d14b74-1ec7-477a-959f-c591576304b5.png)
run sender
![run sender](https://user-images.githubusercontent.com/60667298/236928297-2feee438-074c-4365-af03-d933b5e643e3.png)


![hello queue](https://user-images.githubusercontent.com/60667298/236928627-f9d93946-bb23-45b1-88c7-767363627c4b.png)
Run receiver


![run recevier](https://user-images.githubusercontent.com/60667298/236928662-f9cc27b3-4470-4057-ad02-69b82ca210a6.png)
![queue receiving](https://user-images.githubusercontent.com/60667298/236928705-64e6e973-4633-4227-8e4b-8cf1dd329708.png)

full screen
![full screen](https://user-images.githubusercontent.com/60667298/236928730-f4f1758f-3aea-4fec-804a-d0e6f57ec43f.png)


## RabbitMQ Tutorial - Work Queues

For examinating the work queues part og the lab 9, we set up the environment:


![work queues](https://user-images.githubusercontent.com/60667298/236930555-f7846ad1-5d55-4538-8403-1fecf8786472.png)
After finishin the setting up, we add the codes into the folder for the running the program.

![Work Queues code](https://user-images.githubusercontent.com/60667298/236930585-01ff722b-6e0a-4c51-973e-e8fd6c246382.png)
build jar

![jar work install](https://user-images.githubusercontent.com/60667298/236930922-5cff87a1-0553-4407-bb3d-b0f41e7e7e6e.png)


By using the command, the sender sends the message to the "hello" queue.
![queue hello worker ](https://user-images.githubusercontent.com/60667298/236931040-f02a254c-a0cc-48ff-aaac-404ab79263c7.png)

The rabbitmq shows the results that the sender sent the messages successfully.

![sent hello on worker ](https://user-images.githubusercontent.com/60667298/236931083-008dbe05-3ad9-4406-a38c-755d8f4cd89b.png)
![get message on queues](https://user-images.githubusercontent.com/60667298/236931122-2715ab34-b7a1-4ed1-a80b-bb7a7a623260.png)
Receiver run

Run the receiver for getting the messages from the queue.

![worker receiver](https://user-images.githubusercontent.com/60667298/236931204-cc21e34e-90c1-422b-9442-206ab1e7ac9f.png)
[full screenshot of the desktop]

![worker full screen](https://user-images.githubusercontent.com/60667298/236931291-d2f46a5c-3b34-42e4-bbc2-8396740ce266.png)

The Spring Profiles helps classifying the application configurations. Also, it helps to execute the program in different environments. In the future project, it will help cooperating with team members. The rabbitmq is helpful for the future project because that the rabbitmq is message broker which distributes the messages to other API if the request handling time is too long. It keeps the message a safe place before that are delivered to the receiver.
