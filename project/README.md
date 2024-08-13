![kong](https://github.com/user-attachments/assets/81942bf6-8bdd-4b7d-9700-4576d97f9186)# CMPE 172 Project Journal


## Starbucks Project


## Introduction

Starbucks Project shows the ordering and purchasing process in the local store  So, the next step is developing the online store app and back-office app. Those apps will be used gradle, NodeJS, and spring boot, and we have used Redis, kong API, spring REST API, MySQL



REQUIREMENT

1. Cashier's App:

Following the template of the Starbucks Cashier APP which is made by NodeJS supports the admin logins for Starbucks employees Supports the order processing in the store

2. Cloud Deployment on GCP

External Load Balancer as Ingress for Cashier's App Internal Load Balancer for Starbucks API behind Kong API Gateway

3. Cloud Database

GCP MySQL

4. Connect kong API Starbucks API, Mobile App, and Store Front

Deployed with Kong API Gateway Implement with API Key Authentication

## Instructions

This project shows the collaboration of the deployed instance and the local machine. Without the Starbucks Mobile App, Cashier's App, Kong API Gateway, and Starbucks REST API will run on the Google Cloud Platform. Using the Kubernetes we can deploy the services. Through the web browser, we can run the cashier's app. Also, the data will be saved into GCP SQL (MySQL). We can check the order's status and information through the GCP MySQL.


the project structure of could deployment is below picture:


however, I decide not to implement the rebbit part due to some technical issues.


this is my image <img width="496" alt="image" src="https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/960861b9-5397-401e-a7f2-b23117333087">

Before instruction of the deployed instance for running the Starbucks project, we need docker images: Starbucks REST API. So, we build the docker image and push it into our own docker account. For making the docker image, we need to set up the environment: Maven 3.8.5 Java JDK 11


After we finish uploading the docke image into our account, we need to set up the deployment.yaml files of both apps. First, we download the folder "GKE". In the GKE folder, the two folders, "API" and "cashier", contain each app's deployment.yaml file. Both deployment.yaml files need to be changed in the image path:



![cashier-devp](https://github.com/user-attachments/assets/15231fa3-19d8-4acb-9afd-41b868fee063)
When we complete all environment setups, we will move to the GKE section.

We will use the Kubernetes Engine which is offered by GCP. We create a new Google account or use our own Google account. After signing up for GCP, we create a new cluster for building a running environment via GCP. I recommend choosing GKE Standard mode when we create the cluster because the project is executed enough in GKE Standard mode. We will use the default setting values of the cluster. When we click the create button, we will wait until the cluster is created successfully.
![api-devolp](https://github.com/user-attachments/assets/db3ae6f3-215f-4e26-b798-ac2a65d644de)

The next step is to we connect the cluster with Cloud Shell and then upload the GKE folder into GCP storage.
![uploadallyaml](https://github.com/user-attachments/assets/07e6ff77-f511-4d5a-b7b7-4248d7512207)


When we finish the environment setup part, we will jump to set up the Starbucks API part.

The API is connected to the GCP MySQL database. So, we have to create GCP MySQL. The connection of the GCP MySQL will be the default private IP range.
![create mysql1](https://github.com/user-attachments/assets/903cb7a0-d230-45dc-a9fc-7b5f92d874e6)
![mysql2](https://github.com/user-attachments/assets/11f950a6-b3a5-4644-86ba-824ba42a68a1)
![mysql3](https://github.com/user-attachments/assets/7dbe6bf5-a38d-4128-8ec1-299aa0d11846)
![mysql4](https://github.com/user-attachments/assets/7cb20e72-7e2e-4165-b0fc-be5b5bafaf78)
![mysql5 created](https://github.com/user-attachments/assets/2cc7f93b-8090-4bdd-96d5-a92a804fa5ad)
![mysql users](https://github.com/user-attachments/assets/85c43a5c-3e7d-450c-8b31-e957ef86be2b)
![mysql datebase](https://github.com/user-attachments/assets/5419e9ff-a345-4990-9666-9035cf00ea83)


We will use the private IP address in the deployment.yaml file.
We have to create a deployment and service of the Starbucks API. But, before we create the deployment and service, we need to edit the value of MYSQL_HOST to the private IP address which is the GCP MySQL that we created.
![replace the env value as mysql private up](https://github.com/user-attachments/assets/c359eed4-c1ef-4237-89cd-c7d0f006d730)
![api-devolp-2](https://github.com/user-attachments/assets/a8f64b90-10dc-4f1f-8cda-441e0bee26c8)
![api serive](https://github.com/user-attachments/assets/b2d6c94d-680f-4486-8e38-8b346e810d13)


We can check the deployment and service are successfully created:
![GKE api service](https://github.com/user-attachments/assets/9a51c535-6d8e-4760-82da-9fcdcb213657)



When we finish creating deployment and service, we are supposed to connect to the Kong API Gateway. First, generate Kong ingress and Proxy using the below command. If it is successful, we can see the Kong ingress and Proxy External Load Balancer in the workloads. We enter the Kong folder.
![kong](https://github.com/user-attachments/assets/cb13afd8-1a84-48c7-b7d1-cab8944e51c5)
![jumbpbox](https://github.com/user-attachments/assets/1cf533e5-7e96-4e1b-9657-0a0ac23e9b17)

We can see that all deployments and jump boxes are successfully running. Also, the services are successfully running.
![jumbpbox](https://github.com/user-attachments/assets/4c291a51-5007-4c53-9d33-0a780e59967d)


After that, we apply the Kong ingress rule and strip path for constructing the HTTP request method. Put the commands into the Cloud shell:
![kong api](https://github.com/user-attachments/assets/8fde73b1-88a1-4dd1-aa99-ab7ace4409f5)


![kubectl kong1](https://github.com/user-attachments/assets/ce64d016-b991-490d-bdd3-a19275b9bd10)
![kubectl kong2](https://github.com/user-attachments/assets/e3310660-258d-454a-af48-b84206bbf969)


After that, we added the Kong key auth plugin. The commands are:

![kong auth](https://github.com/user-attachments/assets/9510fb8c-1112-4410-8562-9b9d7c57d454)
![auth key in code](https://github.com/user-attachments/assets/8e6e2417-bfca-4c71-bd19-146d0a4aba14)



Then, we push the docker image into our account.

<img width="888" alt="image" src="https://github.com/nguyensjsu/cmpe172-mujunyu520/assets/60667298/fc95a9bd-2a96-45d8-be2b-9ec1b642954c">

We deploy the cashier's app into the cluster. The commands are:

![GKE created cashier](https://github.com/user-attachments/assets/e4ee0af6-76f5-434e-b509-dadd53da6129)

When we type all commands and see the deployment and service are successfully generated, we have to generate the ingress of the cashier's app service. The ingress is connecting the external load balancer. The below picture is the setting of the cashier app - service ingress.

![build  cashier lb](https://github.com/user-attachments/assets/ed4f5d4b-8a10-4ec3-bf5c-fb91c6aa2432)

![external-lb2](https://github.com/user-attachments/assets/13390eea-d0a5-46d3-900f-2213221d5623)
the page navigates to the login page: 

![login page sb](https://github.com/user-attachments/assets/48762535-ee2c-49e6-bc98-bca4175bba22)


register page：
![register](https://github.com/user-attachments/assets/79ba1b1e-bb8a-4da3-a843-303cb8bfc47e)

![login_with acount](https://github.com/user-attachments/assets/fe87ee7e-f825-4e35-9df6-dab1f31341ac)
After typing the user name and the password, we can see the welcome page or the cashier's front page. If we see the welcome page, we can enter the cashier's front page.

![fullscreen of starbucks page](https://github.com/user-attachments/assets/d4885e60-1c28-4631-8990-ac1e72c8c150)
The default store is Dub-C. Its register number is 5012349. We can choose the store register and the drink menu options. If the register doesn't have an order, the message box shows the status, "Ready for New Order". When we click the "Place Order" after finishing setting the selected drink options, the order information will pop on the message box. When we click the "Get Order", we can see the order information.

![place order](https://github.com/user-attachments/assets/e595f014-e7ff-4189-9bae-aa181ca1af07)
![get order](https://github.com/user-attachments/assets/9b8d955b-9ae8-4ad8-8408-276818b63aec)


When we click the "Clear Order" button, the order is deactivated. The below picture is the picture where the cashier clicked the "Get Order" button after the order was deactivated.
![2 get order](https://github.com/user-attachments/assets/78875e9e-4947-48a2-86f4-57c9e82949e1)


![clear the order](https://github.com/user-attachments/assets/181931e3-e470-4ad2-b8fb-24427f8eafa0)

To pay the order, we need to run the Starbucks Mobile App. When we run it, we can see the login page.

![starbucsk app1](https://github.com/user-attachments/assets/e427b427-ed2f-4c77-b428-e89ea0e015bb)

We can use the command "login" to reduce the time to log in to the mobile app.
![starbucks app 2 lgoin](https://github.com/user-attachments/assets/98c75a96-aea0-4373-91e3-3363bcabd930)


When we log in to the mobile app, the app automatically drives to the "MyCards" page. The card is generated automatically with a $20 balance.
![20bucks](https://github.com/user-attachments/assets/e1fa2517-8216-4475-9e63-48a912fb6dcb)


To show the demo, we generate an order via the cashier's app.

![place order](https://github.com/user-attachments/assets/78431195-c3bb-4043-956e-2666d0be5db7)

To purchase the order using the mobile app we need to type the command: login, touch(2,2), touch(3,3), touch(2,2), touch(3,3) 

![touch3 3](https://github.com/user-attachments/assets/16d8e77e-a3bd-4328-aeaa-a89d128689bc)



When the process is successfully done, we can see the screen with the downed balance of the card.
![touchpad with balance](https://github.com/user-attachments/assets/749d4606-ddb5-48a1-9f0e-fec2d1da1469)

After we move the page to the cashier's front page, we click the get order to check the order's status. When we click the button, we can see the status is changed, “”
![get orders balance](https://github.com/user-attachments/assets/fea71122-cd72-44aa-83f4-cdf685074056)


For showing the HTTP request flow, I am going to use Postman to respond to the HTTP requests. In the Starbucks-app folder, the file named "SPRING STARBUCKS.postman_collcetion.json" helps to set up the test messaging format.

The REST API uses 4 HTTP methods to call the server: GET, POST, PUT, and DELETE. By these call methods, we can get or post the orders in the database. For testing the Starbucks REST API, we need to run the GCP features.


Before jumping in the test, we need to set up the host, port, and API key in the Postman.


![RESTAPI1](https://github.com/user-attachments/assets/85fa126a-442a-47df-b91b-7ae6c906914b)
First, we test the generating order via the postman. We open the postman and check whether the server is up or not using ping.


![rest2](https://github.com/user-attachments/assets/ebfdbeb4-9c5e-4d9f-bf1e-57d0853c7ed0)

![3](https://github.com/user-attachments/assets/35de5fb1-baad-430a-9dcb-bfe49fd89e76)
![4](https://github.com/user-attachments/assets/a857aa99-dad2-4fff-a859-15983cad459d)
![5](https://github.com/user-attachments/assets/0a413efa-3f31-401e-965e-42f310e45b06)
![6](https://github.com/user-attachments/assets/158a0e11-f3ea-460f-b515-737e5e8be79d)
![7](https://github.com/user-attachments/assets/2e0ea0d4-712d-4dea-9226-f4fd23b57720)
![8](https://github.com/user-attachments/assets/82a9dbf7-d136-4e04-a419-4eb4bf99870d)





The final test is the order test. We can generate orders, get all orders, get a specific order, and delete all orders. Also, we can pay for the order with the activated card.
![9](https://github.com/user-attachments/assets/a953f021-51be-4c62-8a8c-740ef2a633a9)
![10](https://github.com/user-attachments/assets/8be50b64-754b-4e8b-8ef4-123dd7c694de)
![11](https://github.com/user-attachments/assets/382cce3a-3515-4b54-9b4e-4b034a058314)
![12](https://github.com/user-attachments/assets/ff44cbcf-d794-426a-aea1-24048fc66e10)
![13](https://github.com/user-attachments/assets/b18b0434-76a2-4723-b422-a43bf18f1213)
![14](https://github.com/user-attachments/assets/aa8fae8f-247c-4a65-ac0c-4d70d2def2e4)






## Journal

Week 1 (Project Kickoff) - (4/18/2023 - 4/24/2023)

1. confused about the project, but after lab 8, the outline was slowly guided by that.
2. pick little by little to understand the project's meaning
3. watch some youtueb video realte with GCP kubanate and docker.

Week 2 (Think about project structure) - (4/25/2023 - 5/1/2023)
1. going back to watch the demo video of lab 3 and lab8, slowly understand the concept of the project 
2. following up with lab8 to build up the Kong and Starbucks API
3. trying to figure out how to connect to Kong by cashier app
4. 
Week 3 (Struggle with function implementation) - (5/2/2023 - 5/11/2023)
1. runnable only with Kong and API, tested on Postman which worked
2. but had a hard time figuring out that the communication between the MVC and HTTP
3. thought was finished up about 65% 

Week 4 (Deliverable) - (5/13/2023 - 10:19 5/22/2023 )
1. had a hard time resolving the unhealthy check issue when building the external lb for the cashier app
2. checked the lab video, and some videos on YouTube that mention that the issue may come from the code or firewall
3. I have asked a lot of people to solve this issue for almost three days however it still not work on this issue
4. I recall prof said he resolved it by code. then I go back to check my code. I found out something which is weird
5. my path which means my web config is not clear may cause GKE cant test my cashier app.
6. then I got to an unhealthy pod and checked the config info, I found out that the default web path for the cashier app was ("/")
7. re-look my code in webconfig code which does not have this path.
8. third day I added this path for my code, after that unhealthy backend was fixed.
9. I also had a hard time implementing the code for RabbitMQ for this project because time was tight at the end of class
10. also with multiple pods the web service is not statable so we only add the REDIES for the login system to keep the web response statable. 
11. for the API I decided to add a sticky-session for it.



The App demo video link is here: [demo] https://www.loom.com/share/f9080b832c694a19aff7bf9fe6d5c8c6?t=544
