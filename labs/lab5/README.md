# CMPE 172 - Lab #5 Notes
## level-2
#### The spring rest level 2 shows that the simple spring MVC app operates how the data are working on the system. For examining the rest API, we need to set up the environment as like below pictures.


![level2](https://user-images.githubusercontent.com/60667298/226446682-668f5ac1-869c-4897-98a8-905f5c1880c9.png)
![level2-1](https://user-images.githubusercontent.com/60667298/226446688-1e98607b-9e48-4a86-ad5a-cd4bcad2b5d6.png)

#### After finishing the environment setup, we create the sample files into the “spring-rest-level2” folder to execute the program.
![level2-2](https://user-images.githubusercontent.com/60667298/226446751-bac26232-17ec-4493-acef-23e3b15f308e.png)
#### When the files put the correct location, we make a jar file via Maven. Then, we run the generated jar file to execute the sample program.
![level2-3](https://user-images.githubusercontent.com/60667298/226446759-47300806-1d7f-4203-a579-b8e506332256.png)
![level2-4](https://user-images.githubusercontent.com/60667298/226446867-14932dbb-8526-4864-b06d-6fa946647705.png)

#### We can see that the program inputs the example data into the database system. The data include id number, name, and role of the employee.
![level2-5](https://user-images.githubusercontent.com/60667298/226446963-9417e77e-8e89-482c-a68d-c69723758d4c.png)


#### For executing the H2 database console, we need to add the application features into the “application.properties” file. The H2 is a relational data base management system in Java. It helps to display the data information such as location, detail saved. When we type the address into the browser then enter the url, id, and password, we can go to the management system main page. In the page, we can modify the data with the SQL comments.
![level2-6](https://user-images.githubusercontent.com/60667298/226447109-c59edae0-9c78-48a1-ab2c-aa58ce9399bc.png)
#### The other way to test the database is “Postman”. The application provides a way to see and set SSL certificates using HTTP platform. For example, if we want to see all employees in the database, we can use mapping information from the controller class. The below picture shows how we can search all employees’ data in the database.![level2-7](https://user-images.githubusercontent.com/60667298/226447185-a8666864-24f6-4237-be42-48a2ffd7a717.png)
With the sample JSON file that the professor provided we can test the database when we import the JSON file into the Postman application:
![level2-8](https://user-images.githubusercontent.com/60667298/226447237-8b8e247e-e332-4e34-98d8-18c223f72db3.png)
Because the spring-rest-level2 doesn’t have order function in the program, the order commands in the Postman will not work when we run the commands. It will show 404 not found error:![level2-9](https://user-images.githubusercontent.com/60667298/226447303-de4c3130-edb4-42b8-9a1d-419a1b46b465.png)
## Spring Rest Level 3
#### The spring-rest-level3 is upgraded version of the spring-rest-level2. It contains 3 specific features: rest (Spring MVC + Spring HATEOAS app), evolution (REST app where a field is evolved but old data is retained for backward), links (REST app where conditional links are used to signal valid state changes to clients). Therefore, we need more code files into the folder:
![level3-2](https://user-images.githubusercontent.com/60667298/226447776-aa500467-b47e-43ec-9ce8-cc5ec126ae38.png)

![level3-1](https://user-images.githubusercontent.com/60667298/226447764-ffa19db7-6067-45b7-af88-86d2b3a0b691.png)
#### Before executing the program, we need to build the package using Maven. After the finishing the building the package, we can run the program with jar file.


![level3-3](https://user-images.githubusercontent.com/60667298/226447885-9412190c-e4df-4d15-83ff-ec72e6e16a12.png)

![level3-4](https://user-images.githubusercontent.com/60667298/226447893-f5159c06-a6b5-4e25-a35e-4d701731cf13.png)
#### Also, we can see the program puts the data into the database. In the code “LoadDatabase”, we can check the default employees and orders which are automatically allocated in the database.

![level3-5](https://user-images.githubusercontent.com/60667298/226447947-7912c9da-f06c-47ff-8816-2abbbe2463da.png)


![level3-6](https://user-images.githubusercontent.com/60667298/226447967-61e4dc1f-eec4-4a53-83d7-54a1e01a359f.png)
#### [Full screenshot of the desk]

![level3-7 full screen](https://user-images.githubusercontent.com/60667298/226448097-b13fb8f7-c0b6-4e58-bc98-261eaf2512b4.png)

## Starbucks REST API
#### This experiment is that how the Starbucks REST API which is offered by the professor’s lab resources communicates between the management server, and the storage system. In this lab, we will run the program. To use App we need to create network and run backend using the docker. The below pictures are the setup environment:

![Starbucks-1](https://user-images.githubusercontent.com/60667298/226449967-1ed4667f-19d6-4e5c-bca5-a02fe28a5029.png)
![Starbucks-2](https://user-images.githubusercontent.com/60667298/226449975-43485b53-85b2-41ae-9ca6-c7e507667560.png)
#### Before running the program, we need to add the codes and files into the “spring-starbucks-api”.
![Starbucks-3](https://user-images.githubusercontent.com/60667298/226450066-d7becf58-5b31-48db-b9bc-62f134b3420e.png)

#### For using the docker, we are supposed to build the package which generates the jar file and build the docker image. Then, we push the image into the docker account.
![Starbucks-4](https://user-images.githubusercontent.com/60667298/226450121-948650e7-95d8-4a02-a709-582051cb928d.png)
![Starbucks-5](https://user-images.githubusercontent.com/60667298/226450969-dab27540-9f6e-4c7d-942f-bd804d2d3b8f.png)
![Starbucks-6](https://user-images.githubusercontent.com/60667298/226450980-645101dc-ffb8-49f1-aa1f-6242b37dd297.png)
![Starbucks-7](https://user-images.githubusercontent.com/60667298/226450988-ad7c2160-8ac1-465b-a320-2cc486623984.png)
![Starbucks-8](https://user-images.githubusercontent.com/60667298/226451021-bb8aed25-5897-45d7-9c1e-ea2cf134d9db.png)
#### We create network and run the backend using the docker image.
![Starbucks-9](https://user-images.githubusercontent.com/60667298/226451033-f27f1aa9-428f-4551-bb1b-e4ca298f0189.png)
![Starbucks-10](https://user-images.githubusercontent.com/60667298/226451161-f20aa3d2-d749-464f-832c-fd9fb30e3c85.png)

![Starbucks-11](https://user-images.githubusercontent.com/60667298/226451172-a1147acd-7f40-4526-a571-029012fae483.png)

#### Test Starbucks API using Postman:
#### Before jumping into the API test, we need to setup the global variables (host and port) because the variables are not defined specific values of the network address. So, we are supposed to determine the variables: host = localhost, port= 8080. In the future labs, we can modify the values if the lab requires to change the port number or the host name. 
![Starbucks-12](https://user-images.githubusercontent.com/60667298/226451240-7296e93c-1811-4762-a8cc-b6c101487626.png)
![Starbucks-13](https://user-images.githubusercontent.com/60667298/226451253-c7eccd41-1561-4561-8fb2-7dda92677d27.png)
![Starbucks-14](https://user-images.githubusercontent.com/60667298/226451299-00939d07-49db-41e0-b465-0b8bdf9de121.png)
![Starbucks-15](https://user-images.githubusercontent.com/60667298/226451308-1dbf1523-67aa-4981-9ed1-304de469e00c.png)
![Starbucks-16](https://user-images.githubusercontent.com/60667298/226451314-bb315a23-fa4b-445e-99a7-4108d85a8c4e.png)
![Starbucks-17](https://user-images.githubusercontent.com/60667298/226451330-0446766f-1e74-4292-b445-60b98eaec342.png)
![Starbucks-18](https://user-images.githubusercontent.com/60667298/226451413-7e774b3c-3b1d-4f44-9e70-325ad3222d18.png)
![Starbucks-19](https://user-images.githubusercontent.com/60667298/226451425-23682e7f-2499-4637-a5cd-ef4f506f43b4.png)
![Starbucks-20](https://user-images.githubusercontent.com/60667298/226451435-41d58223-04e2-45c9-b0cf-06252bf152a3.png)
### Explore the Sample Nodejs and Java Mobile App Simulator

This section is not required, but it is helpful to prepare the next course project. It uses REST Client Sample Apps in starbucks-app and starbucks-nodejs. Because we don’t have the codes now, we will use provided docker images that professor posted on his docker hub. 


#### First we pull the images (starbucks-api:v1.0 and starbucks-nodejs:v1.0) from his docker hub.
![Starbucks-21](https://user-images.githubusercontent.com/60667298/226452160-a985e67d-8511-4e17-ac8f-aa3cd07b0605.png)
![Starbucks-22](https://user-images.githubusercontent.com/60667298/226452170-acd33187-8d54-41e4-817d-3cad8fa83d43.png)
![Starbucks-23](https://user-images.githubusercontent.com/60667298/226452192-f82d9baf-0058-4133-b574-949ad232b4d2.png)

![Starbucks-24](https://user-images.githubusercontent.com/60667298/226452203-8b4a99ca-9470-4a22-8d0d-41eb53260d6a.png)
![Starbucks-25](https://user-images.githubusercontent.com/60667298/226452210-f2d6ecda-d140-47d9-aba4-87844f889830.png)
![Starbucks-26](https://user-images.githubusercontent.com/60667298/226452224-b12e4de1-6043-4fb3-9a5b-9f18693ed8c5.png)
#### After finishing to pull the images, we create the network and run the starbucks api first then run the starbucks nodejs next.
![Starbucks-28](https://user-images.githubusercontent.com/60667298/226452444-e934df2a-d4a4-4eb7-88e3-5b792fc1eb5e.png)


When the images are running with the docker containers, we can enter the localhost address 8080.

![Starbucks-29](https://user-images.githubusercontent.com/60667298/226452493-ecb5ec84-879f-4bd1-857a-562d503fa1cd.png)
For getting and posting the data, we can use “Insomnia” that Post or Get the responses from the server to the client. For example, when we want to get the all orders, we can run the “Get All Orders” in the Insomnia.
![Starbucks-30](https://user-images.githubusercontent.com/60667298/226452516-19d52118-fd64-4add-b39c-7f0806754e57.png)
## Full screen
![Starbucks-31 full screen](https://user-images.githubusercontent.com/60667298/226452548-b5aea605-fa61-4e64-aae4-6677a816b120.png)
