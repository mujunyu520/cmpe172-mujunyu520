# CMPE 172 - Lab #6 Notes
# Spring JDBC

Before doing the spring-jdbc exercise, we need to set up the environment as like below pictures:

![jdbc-1](https://user-images.githubusercontent.com/60667298/230465731-d4b6a9ef-ad0b-4a44-abae-583e79e7941e.png)

![jdbc-2](https://user-images.githubusercontent.com/60667298/230465740-ca61eaa2-67d5-4a50-b073-7e9a7cf72e25.png)

Than, we create the customer object which containes customer's first name, last name, and ID.
After we finish to add the customer object into the java file, we set the JdbcTemplate that makes easily to work with SQL relational databases and JDBC. So, we add some code into the SpringJdbcApplication.java file.
![jdbc-3](https://user-images.githubusercontent.com/60667298/230466351-c10e398f-73f2-4077-b3d4-28d31b54067d.png)

When we are done with the setting, we can run the program in the local machine.

![jdbc-4](https://user-images.githubusercontent.com/60667298/230465860-af122c44-7806-4159-8d6f-b3076449ca86.png)

[Full screenshot of desktop]
![jdbc-5](https://user-images.githubusercontent.com/60667298/230466981-2f83142d-d234-4072-9acd-e9c70ea4ceee.png)


# Spring MySQL
Before doing the spring-mysql exercise, we need to set up the environment as like below pictures:
![sql-1](https://user-images.githubusercontent.com/60667298/230467305-8ed0743b-a516-40a5-8e13-72085b205989.png)
![sql-2](https://user-images.githubusercontent.com/60667298/230469125-08b8473e-4b02-4383-8a88-c14dfbe5c33c.png)

For seeing how the application communicates with MySQL database, we run the container via docker. Than, we create a new database at the mysql.

![sql-3](https://user-images.githubusercontent.com/60667298/230469565-354938f6-5c35-4b3c-900f-4858d14dceb3.png)
![sql-4](https://user-images.githubusercontent.com/60667298/230469594-69e3b04c-151d-49a1-9197-4c0b234e5481.png)

For running the application, we create the application.properties file and add the model, repository, and controller into the folder.

![sql-5](https://user-images.githubusercontent.com/60667298/230469736-3584c5cd-28ba-4c86-8e9d-d99f5e09ea85.png)
![sql-6](https://user-images.githubusercontent.com/60667298/230469771-ca75e84a-bdbc-4fe8-82bb-c831e8b1e53a.png)
![sql-7](https://user-images.githubusercontent.com/60667298/230470030-d0e835a5-da47-4e99-ba1b-a6e50af8e9f3.png)

The below picture shows the testing of the application that gets the user information using curl and posts a new user using curl:
![sql-8](https://user-images.githubusercontent.com/60667298/230470037-0a6c0719-5597-4cca-b141-19f50bd4d7d1.png)
![sql-9](https://user-images.githubusercontent.com/60667298/230470145-cc6fee1b-e6ee-4924-ac8b-01dfd88919a4.png)

We can change the privileges of the user for preventing SQL injection attacks.
![sql-10](https://user-images.githubusercontent.com/60667298/230470460-6b7867f6-85eb-4b92-af75-5439a0e45cd3.png)

[Full screenshot of desktop]
![sql-11(full screen)](https://user-images.githubusercontent.com/60667298/230470546-7bf39911-e0cf-44c3-9d43-aa21778ee120.png)

# Spring Gumball (Version 3)
The environment is similar as previous version. But, we need to add more dependencies (Spring Data JPA, H2 Database, MySQL Driver).
Also, we add the sql schema and edit some code in the Gumball Controller for response of the Gumball Inventory in the DB.
In addition, we update the HTML view to show the model number and serial number fetched from the DB.

![gumball-1](https://user-images.githubusercontent.com/60667298/230471502-6d7d4cc0-1b14-466f-beca-14cc3fbd5160.png)
![gumball-2](https://user-images.githubusercontent.com/60667298/230471539-c92e2ace-f25d-498b-bfe2-50c853c29dc6.png)
![gumball-3](https://user-images.githubusercontent.com/60667298/230471563-94fb42e6-5005-482d-8ed5-55914b97800f.png)

After that, we make jar file via Maven. Than, we build the docker image using the maven command.

![gumball-4](https://user-images.githubusercontent.com/60667298/230471665-77c11b7f-378d-4b5e-a5a3-d3c990ddb95e.png)
![gumball-5](https://user-images.githubusercontent.com/60667298/230471674-a52c0f8b-e3fc-43a4-9e66-e8b164bc4bfb.png)
![gumball-6](https://user-images.githubusercontent.com/60667298/230471692-fe044c91-316f-4bea-9793-068d62d5667b.png)
When we finish the building the spring-gumball docker image, we create network (gumball) and run the spring gumball with MySQL in the docker containers.
![gumball-6](https://user-images.githubusercontent.com/60667298/230471940-0d0fb354-6835-4658-93ef-0a0c3e513ef0.png)
For avoiding the running error, we use the docker compose using the docker command after adding the docker-compose file.
![gumball-8](https://user-images.githubusercontent.com/60667298/230472050-a724f16b-9869-4e69-8a9b-f9f25b4a9033.png)

After that, we enter the MySQL for creating the user and database and give the priviliges to the created user.
The table of the database shows the below picture.
![gumball-10](https://user-images.githubusercontent.com/60667298/230472237-55304e5c-379b-465f-8cbd-069f786e10ed.png)
![gumball-11](https://user-images.githubusercontent.com/60667298/230472270-71c81c40-0303-4b9d-97ed-41e21af72731.png)
![gumball-12](https://user-images.githubusercontent.com/60667298/230472333-ab79173f-57a7-4fa0-8fb3-6a590c9e90fb.png)

Through all process, we can see the web page of the gumball machine. The difference between the previous version to the new version is that the machine display the model number and serial number.

![gumball-15](https://user-images.githubusercontent.com/60667298/230472752-22b8b17a-a069-4762-a750-fc024e5f8763.png)
![gumball-16](https://user-images.githubusercontent.com/60667298/230472777-5cc34ef0-0459-4860-a6cb-7b8cbd778ff8.png)

When we reflash the page, the hash value is changed. And, the hidden fields are the state, timestamp, and hash. 
![gumball-20](https://user-images.githubusercontent.com/60667298/230474136-c6a8b969-fdad-4497-ab30-ccca2926e992.png)

If we want to insert a machine information into the database, we can use the query:
Also, the infomation of the table shows that one machine has 1000 gumballs and it goes down when the user turns the crank.

![gumball-21](https://user-images.githubusercontent.com/60667298/230475060-848a8490-4d09-4e77-bd6f-c97c311b8d72.png)

[full screenshot of desktop]
![gumball-19(full)](https://user-images.githubusercontent.com/60667298/230475143-b45a8db0-a0f7-4fd7-8bd6-6faa9459712c.png)
