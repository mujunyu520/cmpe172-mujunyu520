# CMPE 172 - Lab #8 Notes
## install kong on loacal docker
![sbapi-2](https://user-images.githubusercontent.com/60667298/236351818-024fa7e5-cfb5-4cd8-ade1-309be4f22dfc.png)
We have to use the Kong API Gateway through the Docker. For installing the Kong on the local docker, we pull the Kong image from the Kong's docker.  


## create kong docker Network

Before executing the Starbucks API in Docker using the Kong API, we have to create the Kong docker network.
 
![sbapi_1](https://user-images.githubusercontent.com/60667298/236351969-7db13b7f-0c24-4053-bc7b-ace2ec902c34.png)

## Run starbucks API in Docker
Using the Docker command to run the Starbucks API. The command is that the Starbucks API is starting through the kong-network. The below pictures show the running Starbucks API and that is successful:

![image](https://user-images.githubusercontent.com/60667298/236352397-7f5d6b32-57bc-4ead-bd93-defdbe17e009.png)

![docker desktop 2 container](https://user-images.githubusercontent.com/60667298/236352422-841bb246-8450-4016-9953-f21ac5095bdd.png)
##Run Kong Docker in DB-Less Mode!
Below picture is running the Kong Docker's DB-Less mode:
[docker run kong ](https://user-images.githubusercontent.com/60667298/236352468-bf3d84ed-9577-4b4c-bec5-acdc9599eb78.png)
![docker desktop 2 container](https://user-images.githubusercontent.com/60667298/236352502-cf4d6afd-9f27-4de6-bb20-fdb7e88d6da7.png)

After that, we can get the kong.yaml file using the command. Then, we edit the kong.yaml as below picture:
![kong yaml log](https://user-images.githubusercontent.com/60667298/236352531-b737d11b-7c6b-403c-b04f-190ae278fe23.png)
![kong config information](https://user-images.githubusercontent.com/60667298/236353798-2ebeeef1-0b29-43a1-bdde-06ac53cb04f0.png)

For checking the connection information of the kong.yaml, we install "httpie" which helps to show the config information.!

[ping config kong ymal](https://user-images.githubusercontent.com/60667298/236353810-98bc15ec-5d54-425b-8bdf-2c914b4aa413.png)

When we finish to edit the kong.yaml file, we restart the Kong container.
![kong reloaded](https://user-images.githubusercontent.com/60667298/236353852-95dfa768-7b41-49a2-8160-82c0d20d7674.png)
![api key ](https://user-images.githubusercontent.com/60667298/236353887-bd3d4e88-f354-4dc4-b2be-3a84c4879b08.png)
##Postman API Test

We set up the Postman's Starbucks API environment that contains host, port, kong host, kong port, and api key.First, we check the API is running now using the ping.
![api running and ping ](https://user-images.githubusercontent.com/60667298/236353946-70933c7b-d9ad-43c5-ad16-77251cbaab22.png)
New card For next testing the with the cards, we generate 2 cards. 

![new card of kong api](https://user-images.githubusercontent.com/60667298/236353957-83ab3314-e78a-4594-846a-fef02e0a7f15.png)
Get cards We can search all cards. 

![get cards ](https://user-images.githubusercontent.com/60667298/236354004-b579a866-94b5-4e98-a2fe-db130f6bc23a.png)

Get a specific card We can find the specific card information using the card number. For this test, we use one of above generated cards. 
![get card s ](https://user-images.githubusercontent.com/60667298/236354018-5f306206-0b87-4d13-8f80-4eaa17c05aa4.png)

If the card number does not exist, it shows an error message. 

Activate card with a card number and card code 
![activate card ](https://user-images.githubusercontent.com/60667298/236354051-4e8d0a30-912e-4090-8b2b-49c5c3cbc4a0.png)

New order For the next tests, we generate two orders that each order belongs to a different register. 


![delete all cards](https://user-images.githubusercontent.com/60667298/236354086-2e8a0737-59f2-4bd5-abaf-8bd77c86a462.png)
Get orders We can find all orders. 
![get orders](https://user-images.githubusercontent.com/60667298/236354123-8107deff-228b-42d7-9329-6279e83fbd04.png)
Get order using a specific register number We can find the specific orders with the register number. Below picture shows the register 5012349. 

![Get Order](https://user-images.githubusercontent.com/60667298/236354139-af8efb5e-87b8-4e9c-93b5-4d34ea80a4d9.png)
Pay for order via the activated card The activated card can pay only. So, we use the activated card that we already activated above test. 
![pay for order](https://user-images.githubusercontent.com/60667298/236354151-770de06b-d0b1-454b-aff9-01551bcba3d6.png)
After that, we check the order status is changed. 



![WeChatf618372d135490aa452cd7774db0aeca](https://user-images.githubusercontent.com/60667298/236354204-bdc25edf-87dd-4f49-a6bd-b6d5b76aeac3.jpg)
Clear order We can clear the paid order using the clear order request. 
![clear order](https://user-images.githubusercontent.com/60667298/236354435-e9cb331b-69d0-4153-a518-798f8ae6b580.png)
We check the order was cleared or not using the get a specific order with the register number. If it responds 400 error, the request was succssful. 

Delete all orders We can delete all orders. 
![delete all orders](https://user-images.githubusercontent.com/60667298/236354474-cc7559bf-9643-4a07-913e-bcc239d6896d.png)

Fullscreen
![full screen ](https://user-images.githubusercontent.com/60667298/236354497-48c29994-ab1a-47f0-b535-3221dbd19165.png)

## DEP kong on google gke

For exercise of the Kong and Google GKE, we need to push the docker file into own account.


![GKEpush the image to docker](https://user-images.githubusercontent.com/60667298/236354583-f0af8f19-68e0-484e-bd14-3005f909d4ac.png)

##Deploy Starbucks to GKE, Create a Service for Starbucks API, and Test Reachability from GKE Jumpbox Pod
For deloying Starbucks API to GKE, we need to upload the deployment.yaml file. Then, we create that file into the Kubernetes on the GKE.

![cluster](https://user-images.githubusercontent.com/60667298/![workloads](https://user-images.githubusercontent.com/60667298/236354669-70bc9814-0d87-4c02-96e9-58b12528e5eb.png)
236354629-858a8171-75f2-492b-89fd-f89d8ec3bbf0.png)
![services](https://user-images.githubusercontent.com/60667298/236354664-587c01f2-671a-414e-b96c-12d4e7124b90.png)

fter creating the jumpbox.yaml file, we install the cURL into the jumpbox using the command. Below picture shows that the ping is working on the GKE.
![Uploading workloads.png…]()
![jump box starbucks api version ](https://user-images.githubusercontent.com/60667298/236354703-aedd3804-b1a3-4f55-8e42-064fd6669608.png)
![jumpbox ](https://user-images.githubusercontent.com/60667298/236354761-31b562e5-41ff-4d21-a856-cca0b0835a64.png)


## Install Kong GKE Ingress Controller

The ingree helps to access the HTTP service between the external user and the client application. We use Kong ingress.

![install kong gke ingress](https://user-images.githubusercontent.com/60667298/236354800-21897763-25ae-401d-8c8c-b7f7c7e7878c.png)
Then, we set up the Proxy IP to Kong's public IP. When we test it via Proxy IP, we will get the error message "no route match with those values"

![set up kong s endpoints](https://user-images.githubusercontent.com/60667298/236354823-5d411d4a-43a1-46d6-b0e9-70d0ccccc3af.png)
##Create an Ingress rule to proxy the Starbucs Service
![no route match with hthose value](https://user-images.githubusercontent.com/60667298/236354891-60fc711c-a7f4-49d9-9c1b-afe2ceb3e771.png)

Basically, Kong will proxy the entire path to the service. So, we determine the actual path of the service. Therefore, we apply the kong ingress rule and the kong strip path.
![craete ingres ruls to proxy](https://user-images.githubusercontent.com/60667298/236354897-64dcb8f2-b462-4bc7-b804-4d581e8fb8b2.png)
## Test Kong API Ping Endpoint
If above process is successful, we can get the result which is successfully connected.
![kubectl patch ingress](https://user-images.githubusercontent.com/60667298/236355104-72d35e64-6c71-4513-8001-686eee1b99bb.png)

If above process is successful, we can get the result which is successfully connected.
![Test kong api ping endpoint](https://user-images.githubusercontent.com/60667298/236355071-d98792d1-711d-4f27-8246-f959dfbc61cb.png)
## Add Kong-Key-Auth PlugIn, Configure an API Client Key, Create Kubernetes Secret
![kong key auth plugin](https://user-images.githubusercontent.com/60667298/236355148-c8d6bdbe-c9e2-44b5-866a-a2a74734f1b9.png)
We need to configure Kong to execute plugins for the service's requests. For the service, we add the KongPlugin resource for authentication. After that, we apply kong consumer. Also, we create the secret api key.
![configre and api client key and create kubernetes secret](https://user-images.githubusercontent.com/60667298/236355223-419b723e-124d-42ea-9313-
103e0c202724.png)


## Test Your API Against Kong via Public IP of Load Balancer

![test api ](https://user-images.githubusercontent.com/60667298/236356110-c961855c-df9c-4b87-8b1f-c7596f818475.png)
## Test from postman by edit the external endpoint 35.222.52.14:80 with api key

![postman test](https://user-images.githubusercontent.com/60667298/236356530-36822ebe-d282-4912-acb1-ee640657a9db.png)

![test 1](https://user-images.githubusercontent.com/60667298/236356533-6cacbab6-5599-4c01-85bb-8c5751de5835.png)

Full screen
![full screen-2](https://user-images.githubusercontent.com/60667298/236356552-d43a7a0b-e34f-42ac-9b9f-2fdfd67986c5.png)


## Challenge： API version need to be update with correct formatting of back end setting，also I had hard time to figure out how to get the correct request command. Also, some of the tests were not working on the cURL. I think we need to know how to apply MySQL database is applied instead of the H2 database in the future task. I guess that the GKE has its SQL and it would provide generating the instance with MySQL structure.



