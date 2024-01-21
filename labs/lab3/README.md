# CMPE 172 - Lab #3 Notes


### part-1 run the spring-gumball locally
create the project and set up the dependencies 

![spring-gumball1](https://user-images.githubusercontent.com/60667298/223214373-eb19ac64-74ac-4588-a1b5-a049f9108531.png)

![spring-gumball2](https://user-images.githubusercontent.com/60667298/223214390-b7d01750-0665-4ec5-a133-c3e12d7fd9f9.png)

create a two package one is for gumballmachine another is for springgumball
![spring-gumball3](https://user-images.githubusercontent.com/60667298/223214579-c791e116-cea8-4a54-80dd-30ccbf1d1738.png)
![spring-gumball4](https://user-images.githubusercontent.com/60667298/223214585-1daf92cf-0215-4007-8aab-e58bebbd8028.png)

set up gumball.html and pics the then run the application spring-gumball

![spring-gumball6](https://user-images.githubusercontent.com/60667298/223214780-20e3d384-3ef6-41b0-8959-184038a7b09f.png)

![spring-gumball5](https://user-images.githubusercontent.com/60667298/223214682-39534f63-670d-4f66-9398-5391b0887cd2.png)

spring-gumballl succuessfully run locally
![spring-gumball7](https://user-images.githubusercontent.com/60667298/223214973-fd8e4634-6c27-4f6e-b207-d90ec6b02c5d.png)


### part 2 gumball on Docker

install the application build the images by dockfile 'image name mujunyu520/spring-gumball:v1'
![spring-gumball8](https://user-images.githubusercontent.com/60667298/223216216-e0e3f9c2-e231-44b1-804d-227eef0e2c3a.png)
![spring-gumball9](https://user-images.githubusercontent.com/60667298/223216224-eddba826-d6e9-48cf-8be2-53a5b4efa89d.png)

then push the images to the docker
![spring-gumball10](https://user-images.githubusercontent.com/60667298/223216314-ee3bc4de-04b1-4e15-81ba-f9d337f636ec.png)

 run the images by using 'docker-compose' but first of all we need change our image address to mujunyu520/spring-gumball:v1
 ![spring-gumball11](https://user-images.githubusercontent.com/60667298/223216665-61cc8322-c318-4fbf-91bd-3d68300db95c.png)
 
 the images succuessflly run in docker
 
 ![spring-gumball12](https://user-images.githubusercontent.com/60667298/223217362-191e9f54-44f9-41d1-ba9f-b2fc7e580669.png)
 ![spring-gumball13](https://user-images.githubusercontent.com/60667298/223217395-dfe126fd-1be1-44e6-bcbc-0f7f47f72371.png)

then we need to set up the username and password for the haproxy by 'echo "user = admin | password = admin"'
![spring-gumball14](https://user-images.githubusercontent.com/60667298/223217886-461062d9-36d1-4c67-b8d3-ff3bd809a6db.png)

after we logged in, we can see the staut of our services

![spring-gumball15](https://user-images.githubusercontent.com/60667298/223218037-65abfb04-9933-48b2-9718-ab8582795d46.png)

### Q&A 1：

#### When you load the page multiple times what do you see on the Gumball Home Pages for Server Host/IP?
- Through docker compose, I could be running two containers which had a same image. When I loaded the page multiple time, the server host and IP was switched that the host name is the container name of the docker.
![spring-gumball16](https://user-images.githubusercontent.com/60667298/223218289-777c747c-b000-4a42-aa30-8ba9cf087a43.png)
![spring-gumball17](https://user-images.githubusercontent.com/60667298/223218298-bc603c8b-0521-406c-985f-20b64dde65a2.png)

 #### Can you explain where that IP value comes from?
- The below picture shows what the network is and what the docker containers using the docker-compose take IP addresses. The network subnet is 172.22.0.2/16. It implies that the containers using the docker-compose would be allocated the ascending order IP address under the subnet. For example, if the network address is 172.22.0.0 and the subnet is 16, the next device or container will get 172.22.0.2 as the IP address.

![spring-gumball18](https://user-images.githubusercontent.com/60667298/223218937-585f64ca-ba2d-4418-91fd-c4067dbd902a.png)
 Now, try to add some quarters and purchase some gumballs.
![spring-gumball19](https://user-images.githubusercontent.com/60667298/223219239-a5d914e8-bbd9-401c-a512-df402fea11cf.png)

 #### Do you see the inventory depleting?  Are there any errors?
- When I clicked the “Insert Quarter” button, the error message popped up.

  Review to code for your answer.  No need to make any code changes to fix any issue
  Look at the Session State Feature of the HA Loadbalancer (using COOKIES_ENABLED)
  Is there a setting that can avoid the error?  Why does it work (or Why not).
  - If I change the “COOKIES_ENABLED” from false to true, the error will be fixed. However, after I changed that, the Host and IP address won’t be changed. The cookie is a tool to memorize the client. Also, the inventory is not shared with other clients.
  ![spring-gumball20](https://user-images.githubusercontent.com/60667298/223219514-404dd17a-bac1-4df3-892c-5c781126b20f.png)

#### part3 gumball on GKE

since we already push at part 2 then we need to create all yaml file in  could shell s editor
![spring-gumball21](https://user-images.githubusercontent.com/60667298/223220205-750e9de6-f9dd-4080-9b90-0f502f05b40a.png)
![spring-gumball22](https://user-images.githubusercontent.com/60667298/223220221-78457aeb-34f2-4dfe-974b-0a8ea563e158.png)

next step we need to create required service by those yaml file that we already created 
![spring-gumball23](https://user-images.githubusercontent.com/60667298/223220511-66bfba30-ab1b-4489-97ff-8f5894ecf746.png)
![spring-gumball24](https://user-images.githubusercontent.com/60667298/223220604-552b816d-2620-4d45-bd78-4e7c8ab57ce0.png)

after created all services successfully the status shown below for each parts
Pod
![spring-gumball25](https://user-images.githubusercontent.com/60667298/223220755-e84eb996-5094-49e4-97ab-b220be3635a0.png)
Deployment
![spring-gumball26](https://user-images.githubusercontent.com/60667298/223220763-36b03b71-7771-400e-876c-956badfd6275.png)
Service
![spring-gumball27](https://user-images.githubusercontent.com/60667298/223220773-35b0003b-4ee5-467a-bbbc-fbf57d4ca2b7.png)
Ingress
![spring-gumball28](https://user-images.githubusercontent.com/60667298/223220778-87fa61c6-9ca2-43bf-b7d0-7772d7ed0d6b.png)

those Screenshots for some Testing via Jumpbox and Cloud Console.
The jumpbox is a system on a network with accessing externally. Through the jumpbox it can show the connection between the server and client.

![spring-gumball29](https://user-images.githubusercontent.com/60667298/223221213-90233a2b-64d1-436e-b3de-d43eb9785a26.png)
![spring-gumball30](https://user-images.githubusercontent.com/60667298/223221299-b9e4dc62-01d1-4ea7-a3dd-07bbcd33327d.png)

![spring-gumball31](https://user-images.githubusercontent.com/60667298/223221234-f368030c-a4a8-4ef6-b858-9f6f7dad5e7f.png)
![spring-gumball32](https://user-images.githubusercontent.com/60667298/223221250-20805e31-2a5b-42cc-8813-19bc1fe1a178.png)
![spring-gumball33](https://user-images.githubusercontent.com/60667298/223221316-fe931337-b47f-4ef0-b62f-c026b12791bd.png)
![spring-gumball34](https://user-images.githubusercontent.com/60667298/223221326-141e250f-4ed4-4a8c-b80a-c778703df872.png)


### Q&A2：
 #### When you load the page multiple times what do you see on the Gumball Home Pages for Server Host/IP?
 - The host and IP values were switched when I refreshed the page. Total 4 kinds of host and IP values:
 
 ![spring-gumball35](https://user-images.githubusercontent.com/60667298/223221676-ee73307f-4d19-49a3-86d7-a78c1546c1ad.png)

#### Can you explain where that IP value comes from?
 In Kubernetes, a pod is running one or more containers. When the pod is in running on a node process, it can get its IP address. The above picture shows that the service has 4 pods. When you match the hostname and the pod name, they are exactly the same. That means the pod can get the IP address.

#### Do you see the inventory depleting?  Are there any errors?
  - When I clicked the “Insert Quarter” button, the error message popped up. The above picture shows the log which errors generated (NllPointerException).

![spring-gumball36](https://user-images.githubusercontent.com/60667298/223223515-a039cd6c-3ee9-4950-bcb3-5dece9ef1de6.png)

 
#### Is there a feature in GCP Load Balancer and/or GKE that can resovle the error? 
  Explain, Yes or No and Why or Why not
- For solving the error, we had to think about how the host and IP address is sticky. The Kubernetes doesn’t support to COOKIE_Enable function inside its section as like the above Docker exercise. However, the Google cloud has the session affinity in the Load Balancer section. The below picture shows that it offers the session affinity setting. For making the host and IP to sticky, select “Generated cookie” option and set the times to large amount. After finishing the set up, the error can be solved. But, if the user uses the server over the setting timeout, the error comes out again.

![spring-gumball38](https://user-images.githubusercontent.com/60667298/223222588-df78ba67-58dc-48f0-8de0-30d3d625ab1f.png)

Full screen

![spring-gumball37](https://user-images.githubusercontent.com/60667298/223223025-d430de45-6a08-40b8-a7cd-c52be5019c52.png)
