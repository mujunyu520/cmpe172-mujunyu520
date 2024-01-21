# CMPE 172 - Lab #4 Notes


## spring-security
creating the project and setting up the enviroument
![spring-security1](https://user-images.githubusercontent.com/60667298/224890208-7b1c7ef8-2b9a-4909-9b5a-d982fd721561.png)

![spring-security2](https://user-images.githubusercontent.com/60667298/224890215-14ffc5c2-6a97-4198-80c5-e464e32214d5.png)

by using the provide code, run the application
![spring-security3](https://user-images.githubusercontent.com/60667298/224890270-99dfedc8-2029-4a79-be6d-dc609038fde6.png)
![spring-security4](https://user-images.githubusercontent.com/60667298/224890279-10108e4c-0c04-47d7-b816-23a6b2501413.png)

#### after we see "Welcome" testing the features, clicking here, the next page will be login pages which request username and password
![spring-security5](https://user-images.githubusercontent.com/60667298/224890519-ca227f7c-468b-4795-b300-2c19d6ef0903.png)
#### if enter the invalid username or password it will remind
![spring-security6](https://user-images.githubusercontent.com/60667298/224890624-47f8ac56-78af-47ce-865f-18ee2804409b.png)
#### tring enter the exist user acount it will login and return hello world.
![spring-security7](https://user-images.githubusercontent.com/60667298/224890674-4bbe8070-e358-493d-987f-9a03d0d0ff2c.png)
#### if you logged it shows this you logged out
![image](https://user-images.githubusercontent.com/60667298/224891587-ca1d1f78-7f32-4869-b993-d0270034959d.png)

The below picture shows that the sample registered user: user name=user, user password = password, user role = USER.
![spring-security8](https://user-images.githubusercontent.com/60667298/224890883-0bdc6c7a-3a08-4496-8bb9-f30cca71d760.png)

#### full screenshot
![spring-security9 full](https://user-images.githubusercontent.com/60667298/224890935-8e4705ae-d469-418f-b96e-e604adda815f.png)

##### The web application has three main test which is related to user login system.
##### Test 1: no enrolled user
  ###### When we input the no enrolled user information, it prints the message, "Invalid username and password.".
##### Test 2: input wrong password
  ###### If the user name is an enrolled user and the password is not correct, it prints the message, "Invalid username and password.".
##### Test 3: correct username and password
  ###### If we input correct user name and password, it goes to the hello page. That mean it is successful login.
  
## spring-gumball-v2.0
#### For the lab4-Spring Gumball Version 2, we need to set up using the Spring initialzr and the IntelliJ IDE with the configurations:


![spring-gumball-v2 1](https://user-images.githubusercontent.com/60667298/224892135-64be6b80-d3e4-4f79-b695-3c75d791e184.png)


#### We put codes and features that are offered by the professor’s lab demo and lab references into the Spring-gumball2 project.
![spring-gumball-v2 2](https://user-images.githubusercontent.com/60667298/224892156-9e2b14ff-3f40-401e-b2e5-2d957acd5a97.png)
#### build the application
![spring-gumball-v2 3](https://user-images.githubusercontent.com/60667298/224892172-ffb7fee8-86a9-4951-ba01-73927f395ef4.png)

#### docker build the images
![spring-gumball-v2 4](https://user-images.githubusercontent.com/60667298/224892315-ff38e1a7-11e2-4cba-a636-a8197c3803aa.png)

####  pushing the images to docker
![spring-gumball-v2 5](https://user-images.githubusercontent.com/60667298/224892424-dcef4749-2d63-4a6e-b16d-cdc73c4969cb.png)

#### create all services in GKE

![spring-gumball-v2 6](https://user-images.githubusercontent.com/60667298/224892607-22d346e2-b414-4953-82f6-62ccdb752025.png)



#### The differences between version 1 and version 2 are that:
  ##### 1. three data values which are hash, timestamp, and message are added.
  ##### 2. On the web page, the printed session ID part is changed to Hash value.
  ##### 3. three additional hidden types (state, timestamp, hash).
## Question & Answer

#### shows all service running stauts
![spring-gumball-v2 7](https://user-images.githubusercontent.com/60667298/224892716-f25caaff-7555-4e76-8678-2d95fd10bfa5.png)
![spring-gumball-v2 8](https://user-images.githubusercontent.com/60667298/224892731-e850aac2-7a74-40d6-bcfd-10ee08322a5c.png)
![spring-gumball-v2 9](https://user-images.githubusercontent.com/60667298/224892736-c256de99-467e-4531-bbe8-7364e5ca0643.png)
![spring-gumball-v2 10](https://user-images.githubusercontent.com/60667298/224892747-959a1034-d60f-425e-8566-f979a029d3ec.png)
 
 #### gumball web running with hash secure
![spring-gumball-v2 11](https://user-images.githubusercontent.com/60667298/224892784-fd948a6e-c5a9-49ac-b05c-c14ff4b859ae.png)

 #### The page source of the web page (Can see the three hideen types)
![spring-gumball-v2 14](https://user-images.githubusercontent.com/60667298/224893447-9429ee84-9993-4c52-bd9f-63efc8ccb876.png)

#### Do you see any errors that were observed in Spring Gumball (Version 1)? Why or Why Not?  Explain the technical details to support your observation.
##### Without and edit setting of the Load balancer, we can get the same error of the version 1 as the below picture because the session and host are different. For example, the session ID: 1111 and host: aaaa has the insert coin state using the clicking the button, than the user tried to trun crank button. When the user clicks the turn crank button, the session ID: 2222 and host: bbbb would be changed. So, the program can't find the value of the getting the coin inserted state from the the session ID: 2222 and host: bbbb. The Load balancer with the generated cookie can stick the session ID and host during some period.

![image](https://user-images.githubusercontent.com/60667298/224894264-376a0245-fa22-4d0c-8e9a-98dc08908cd9.png)

#### If we edit the setting of the Load balancer as below picture, we can solve the problem.
![image](https://user-images.githubusercontent.com/60667298/224894335-9cf45ab1-f34a-4328-b4df-cbd8c768c1b0.png)
#### The below picture shows that the hash value is changed but the server host and IP is not changed when it refreshes again.

![image](https://user-images.githubusercontent.com/60667298/224894620-a8030ac8-75f2-48ec-8eb0-084a3ec31621.png)

#### It means that the editte setting makes a sticky host and IP using the generated cookie process. It it is over the affinity cookie TTL, the generated cookie is expired.


 ### Screenshots of Spring Gumball Replay Attack (Before & After):
 
 ### Before
  
 #### We can use the replay attack support tool, "Temper Dev" for demonstrating the replay attack.
  
 #### First, we check that the logs are successfully stored in the service log page of Google Cloud Engine (GKE). When we click the "turn crank", we can get the logs as below picture.
 #### Than we intercept the request via Temper Dev.
 #### he interrupted request shows that the state is NoQuaterState which says the machine doesn't get the quater coin from the user to get the gumball.

 ![spring-gumball-v2 20](https://user-images.githubusercontent.com/60667298/224894986-97c98c46-6bbe-4b8a-ba13-1ed28f9bda42.png)



#### If we change the state from NoQuaterState to HasQuaterState and send the changed request into the server, the machine thinks that the user inserted the quater coin.
![spring-gumball-v2 21](https://user-images.githubusercontent.com/60667298/224895426-06ed678f-fed6-4b61-8447-2494ae01597b.png)
 
#### So, we can get the log that the gumball comes out. We can get the gumball without any payment.
![image](https://user-images.githubusercontent.com/60667298/224895794-6fc94de0-e17d-4c27-95a1-94f5611cf293.png)

 #### If we want to prevent the apply attack, we add the below picture's code which is the conditions into the GumballMachineController: matching the past hash value and hidden hash value, difference between the hidden timestamp value and current timestamp value.
![spring-gumball-v2 16](https://user-images.githubusercontent.com/60667298/224895876-3ee761f8-e01b-43d0-85ab-65d3e25c4339.png)

#### The below picture is testing the spring gumball version 2 is well-working.
![spring-gumball-v2 17](https://user-images.githubusercontent.com/60667298/224895950-df744380-5c64-4f05-a327-27be4e06b3fb.png)
#### With the Temper Dev, we intercept the request which has the NoQuaterState.

![spring-gumball-v2 18](https://user-images.githubusercontent.com/60667298/224896336-0477a02d-d8a8-4d4f-a6bf-861f1dd73383.png)

#### When we change the state from NoQuaterState to HasQuaterState for doing the replay attack, the protection part is successfully working. So, the logs show that the request has the error.
![spring-gumball-v2 19](https://user-images.githubusercontent.com/60667298/224896793-13163c55-c38b-4ee9-a84d-fab3adf18698.png)
![spring-gumball-v2 22](https://user-images.githubusercontent.com/60667298/224896800-640d0f18-7b6a-40c4-a4d6-004aa318fac8.png)
 
 #### Because the replay attack is not working, the web page shows the error.
 
 #### full screen
 ![spring-gumball-v2 19 full screen](https://user-images.githubusercontent.com/60667298/224896898-8c732820-27c7-47fb-9917-d3253baa5dfc.png)
