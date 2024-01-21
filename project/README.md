# CMPE 172 Project Journal


## Starbucks Project


## Introduction

Starbucks Project provides shows the ordering and purchasing process in the local store  So, the next step is developing the online store app and back-office app. Those apps will be used gradle, NodeJS, spring boot, and we have useded redis, kongapi, spring REST API , mysql



REQUIREMENT

1.Cashier's App:

Following the templete of Starbucks Cashier APP which is made by NodeJS Support the admin logins for Starbuck employees Support the order processing in the store

2.Cloud Deployment on GCP

External Load Balancer as Ingress for Cashier's App Internal Load Balancer for Starbucks API behind Kong API Gateway

3.Cloud Database

GCP MySQL

4.Connect kong API Starbucks API, Mobile App, and Store Front

Deployed with Kong API Gateway Implement with API Key Authentication

## Instructions

This project shows the collaboration of the deployed instance and local machine. Without Starbucks Mobile App, Cashier's App, Kong API Gateway, and Starbucks REST API will run on Google Cloud Platform. Using the Kubernetes we can deploy the services. Through the web browser, we can run the cashier's app. Also, the data will be saved into GCP SQL (MySQL). We can check the order's status and information through the GCP MySQL.


the project structure of could deployment is below picture:

![image](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/fa89ca6c-3018-4652-84c6-dcc45984b596)
however, I decide not to implement rebbit part due to some technical issue.


this is my image <img width="496" alt="image" src="https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/960861b9-5397-401e-a7f2-b23117333087">

Before instruction of the deployed instance for running the Starbucks project, we need docker images: Starbucks REST API. So, we build the docker image and push it into our own docker account. For making the docker image, we need to set up the environment: Maven 3.8.5 Java JDK 11


After we finish uploading the docke image into own account, we need to set up the deployment.yaml files of both apps. First, we download the folder "GKE". In the GKE folder, the two folders, "api" and "cashier", contain the each app's deployment.yaml file. Both deployment.yaml files need to be changed the image path:



![cashier-devp](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/ca01ec8f-a10d-4476-af8c-fef98107e7a1)
When we complete all environment setup, we will move to GKE section.

We will use the Kubernetes Engine which is offered by GCP. WE create a new Google account or use our own Google account. After signing up for GCP, we create a new cluster for building a running environment via GCP. I recommend choosing GKE Standard mode when we create the cluster because the project is executed enough in GKE Standard mode. We will use the default setting values of the cluster. When we click the create button, we will wait until the cluster is created successfully.
![api-devolp](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/2b236286-ee75-41a7-800f-3451a9e605e0)

Next step is that we connect the cluster with Cloud Shell then upload the GKE folder into GCP storage.
![uploadallyaml](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/c39a957b-9170-4ea7-9e9a-b261c7652e28)

When we finish the environment setup part, we will jump to set up the Starbucks API part.

The API is connected to GCP MySQL database. So, we have to create GCP MySQL. The connection of the GCP MySQL will be default private ip range.

![create mysql1](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/3107a684-c04f-4292-aae6-68e40a67faa8)
![mysql2](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/a0e1ef87-c3c1-4126-9bb0-f0f3ec63712d)

![mysql3](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/7e683511-ba95-463b-bac2-2108160fd05e)

![mysql4](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/b4011a5e-4f22-43b7-a0b8-2f3d3a9a9dab)
![mysql5 created](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/72c280fa-aef3-4914-86fd-6e79d841d7c0)

![mysql users](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/68058b90-24e4-481e-9b69-e92737ed4bf6)

![mysql datebase](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/f9c6973e-782e-447f-b841-75645647d7a1)


![connection ip mysql](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/cdeed52f-b531-46bd-b687-5e83dc0a4a99)

We will use the private ip adress in the deployment.yaml file.
We have to create a deployment and service of the Starbucks API. But, before we create the deployment and service, we need to edit the value of MYSQL_HOST to the private IP address which is the GCP MySQL that we created.
![replace the env value as mysql private up](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/86263e94-7bc5-43b8-9a77-7a2fc50374c1)
![api-devolp-2](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/80862e85-8b3b-484f-a72c-3d773c6632cf)
![api serive](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/a65189f3-dd9b-448a-aae5-ba83cdf27b49)
We can check the deployment and service are successfully created:
![GKE api service](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/7f0de2fc-079e-41d0-a81f-1fba71da34f0)



When we finish creating deployment and service, we are supposed to connect to the Kong API Gateway. First, generate Kong ingress and Proxy using the below command. If it is successful, we can see the Kong ingress and Proxy External Load Balancer in the workloads. We enter the Kong folder.
![kong](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/6da470f1-f1c1-4e30-9cb6-b8b7dc84793d)
![jumbpbox](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/29774438-bf18-42d0-97cf-c549ec30ede2)
We can see the all deployments and jumpbox are successfully running.Also, the services are successfully running.

![jumbbox gke](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/d8872b63-42a1-4f1f-8f20-f918ac02a30b)


![jumbbox gke](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/93dc8ec1-c858-42bd-950b-13cd5cf30068)
After that, we apply the Kong ingress rule and strip path for constructing http resquest method. Put the commands into the Cloud shell:

![kong api](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/a8b2576b-1499-40c0-8f50-a12ac114680c)

![kubectl kong1](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/80575d91-5eff-45db-8352-4754b5d77ed2)
![kubectl kong2](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/b20f1ead-26b4-48e0-acd8-daa1372c6017)
After that, we add Kong key auth plugin. The commands are:

![kong auth](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/8d2771c5-7113-4224-9166-5d93dbfb76ea)
![auth key in code](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/e1415c63-ab90-4cb2-ac32-18bb030974cb)

Then, we push the docker image into our own account.

<img width="888" alt="image" src="https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/fc95a9bd-2a96-45d8-be2b-9ec1b642954c">

We deploy the cashier's app into the cluster. The command are:

![GKE created cashier](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/7f7890a0-8dcc-40ec-a58d-a62a7ad19acf)
When we type all commands and see the deployment and service are successfully generated, we have to generate the ingress of the cashier's app service. The ingress is connecting the external load balancer. The below picture is the setting of the cashierapp-service ingress.

![build  cashier lb](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/74fc159d-537c-40cf-9834-78a4ac4d7a10)

![external-lb2](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/a952ebdf-70db-4a1e-980c-2e40ce5771f7)
the page navigates to the login page: 

![login page sb](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/70c6438a-7254-4feb-8a48-5ecff17795da)

register page：

![register](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/6d832a61-0b74-4c4e-b333-0c838ab6951e)

![login_with acount](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/73864f70-4133-4831-8005-cf7d65519b1c)
After typing the user name and the password, we can see the welcome page or the cashier's front page. If we see the welcome page, we can enter the cashier's front page.
![fullscreen of starbucks page](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/635ad108-08a2-46cd-8299-b9942bc7c6e1)
The default store is Dub-C. Its register number is 5012349. We can choose the store register and the drink menu options. If the register doesn't have an order, the message box shows the status, "Ready for New Order". When we click the "Place Order" after finishing setting the selected drink options, the order information will pop on the message box. When we click the "Get Order", we can see the order information.

![place order](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/4d9230c3-08e3-4b72-a074-d73e90f96550)

![get order](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/a02de459-58d2-4697-996a-96e3536a4dbb)
When we click the "Clear Order" button, the order is deactivated. The below picture is the picture where the cashier clicked the "Get Order" button after the order was deactivated.
![2 get order](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/dab23b3c-6a8b-48d5-87de-6e46c84666aa)

![clear the order](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/d09824ff-38fa-49ba-a0ee-66bdff8ac8ce)
Now for paying the order, we need to run the Starbucks Mobile App. When we run it, we can see the login page.

![starbucsk app1](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/fb6221f7-34d9-4c40-aabf-f59c32da0735)

For reducing the time to login the mobile app, we can use the command "login".

![starbucks app 2 lgoin](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/47a216af-0908-4b6a-a700-69f3be6cc4d7)

When we login the mobile app, the app automatically drives to "MyCards" page. The card is generated automatically with $20 balance.
![20bucks](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/683e633a-ed88-49de-ab77-33423b37db1b)

For showing the demo, we generate a order via the cashier's app.

![place order](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/fe0093da-63a1-406d-99a0-9c9ed4907159)
To purchase the order using the mobile app we need to type the command: login , touch(2,2) , touch(3,3) ,touch(2,2) , touch(3,3) 
![touch3 3](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/5c201040-4bec-4680-a218-cd40ba5393c9)


When the process is successfully done, we can see the screen with downed balance of the card.
![touchpad with balance](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/0dca664d-7278-43bf-9e82-06337c7d38fb)
After we move the page to the cashier's front page, we click the get order for checking the order's status. When we click the button, we can see the status is changed, “”

![get orders balance](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/55b32e59-17c8-461b-a84a-b0159e63d62e)


For showing the HTTP request flow, I am going to use Postman to respond to the HTTP requests. In the starbucks-api folder, the file named "SPRING STARBUCKS.postman_collcetion.json" helps to set up the test messaging format.

The REST API uses 4 HTTP methods to call the server: GET, POST, PUT, DELETE. By these call method, we can get or post the orders in the database. For testing the Starbucks REST API, we need to run the GCP features.


Before jumping in the test, we need to set up the host, port, and api key in the postman.


![RESTAPI1](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/a8891813-57e6-4422-bc67-7e1a110c89cb)

First, we test the generating order via the postman. We open the postman and check the server is up or not using ping.


![rest2](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/94d1200f-5843-4c92-b5b1-9e31ca7d2000)


![3](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/320a6952-a921-454b-ba97-c3b7d153385d)

![4](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/edc42511-1f1e-43fa-b70b-9894a3f3b79b)
![5](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/3a7b42b2-284a-41ab-8f21-3b155b17035b)

![6](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/5ce43326-30df-49e6-abbf-d3fef8dd97a2)
![7](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/15937ce4-c281-4e56-8152-aaa3e73589fb)

![8](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/3d4eaa00-3d79-4947-a8a5-29362371223d)


The final test is the order test. We can generate orders, get all orders, get a specific order and delete all orders. Also, we can pay for the order with the activated card.
![9](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/fb02a077-1cca-45e0-a8c1-1a9e86a570e4)

![10](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/537ce531-8868-47b2-8980-dbf6f2f6d2f1)

![11](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/77c558c4-49ec-4cd0-a53e-cf4f2a2c35df)
![12](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/e7ab9634-30ee-4fb4-ba11-2d04623fe9e6)

![13](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/6df1b31d-59ab-4600-9a79-b337251b2217)

![14](https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/bc772b32-fadc-4bff-9c81-b7b647d41f9f)



## Journal

Week 1 (Project Kickoff) - (4/18/2022 - 4/24/2022)

1. really confused about the proejct , but after the lab8 , the outline getting slow guid by that .
2. pick litle by little to understhand the project meaning
3. watch some youtueb video realte with GCP kubanate and docker.

Week 2 (Think about project structure) - (4/25/2022 - 5/1/2022)
1. going back to watch the demo video of lab 3 and lab8 , slowly understand the concept of the porject 
2. following up with lab8 to build up the kong and statbck api
3. trying to figure out how to connect kong by cashierapp
4. 
Week 3 (Struggle with function implementation) - (5/2/2022 - 5/11/2022)
1. basically runnable only with kong and api, tested on post man which is worked
2. but got hard time to figure out that the communication between the MVCand http
3. thought was finished up about 65% 

Week 4 (Deliverable) - (5/13/2022 - 10:19 5/22/2022 )
1. got hard time to resolve the unhealthly check issue when build the external lb for cashierapp
2. checked the lab video, and some video on youtube that meantion about the issue may come from the code or firewall
3. I have asked a lot of people to solve this issue for almost three days however it still not really work on this issue
4. I recall prof said he resolve by code. then I go back to check my code. I found out something which is really weird
5. my path which mean my web config not really clear that may cause gke cant really test my cashierapp.
6. then I got to unleathy pod and check the config info , I found out that the defult web path for the cashier app was ("/")
7. re look my code in webconfig code which does not have this path .
8. thrid day I add on this path for my code , after that unleathy backend got fixed.
9. I also got hard time to impment the code for rabbitmq for this proejct because time was really tight at the end of class
10. also with multiple pods the web service is not really statabale so we only add the redis for login system for keeping the web response be statable. 
11. for the api I decide to add stickysession for it.



The App demo video link is here: [demo] https://www.loom.com/share/f9080b832c694a19aff7bf9fe6d5c8c6?t=544
