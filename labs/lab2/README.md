# CMPE 172 - Lab #2 Notes

## Spring-MVC

### first of all  Build and run the spring-mvc project based on https://spring.io/guides/gs/serving-web-content
![a82e8836e81b96b82df19ba0769aedf](https://user-images.githubusercontent.com/60667298/221645367-b0c4e77b-ace9-473a-9495-50c91a212626.png)

### add all dependencies
![ee641a05a0e00ad74119765c53f6825](https://user-images.githubusercontent.com/60667298/221646103-18ae13bd-8f25-4b3e-b466-564411db3246.png)

### for here we just need to refactor the by rename the jave file to match the genorator
![3a5bd0d7c9d4e990b6d8ba9a28772b1](https://user-images.githubusercontent.com/60667298/221647010-0ee3624e-fc14-4e7c-909f-57c843f05f62.png)

### then we copy those provided code for build and run the spring-mcv but we need to create a  web controller first
![a61f84100a5401a8897b4cf75d3e819](https://user-images.githubusercontent.com/60667298/221647889-f1424cdc-61a0-4d96-ba90-5474a7319d46.png)

### after setting up the web controller then we move to templates folder to create a greeting.html 

![7f82a86e68dd4f0dd2ff1872bd66507](https://user-images.githubusercontent.com/60667298/221648899-ac672658-2c54-46e9-8730-48428372ef2e.png)

### for run the application we need create and motify a application java file.

![da219db37fb8cdc7b074ed86bdd6e61](https://user-images.githubusercontent.com/60667298/221649447-f22f18f8-bb40-482e-8de2-f74524ff48ea.png)

### now we can test the application by running and sucusscfully run
![image](https://user-images.githubusercontent.com/60667298/221650796-3b8b0e4d-4599-4c5d-9388-fbe1720b0f94.png)

### for testing, now the web site is running visit  http://localhost:8080/greeting where we should see "hello world"
![image](https://user-images.githubusercontent.com/60667298/221651185-2d64c602-8249-4fa3-9ad6-8a9bdbd989ec.png)

### now we need try to run the application in GKE and Docker we pack application here first

![5c79f2405f42ca9bb6075501a371047](https://user-images.githubusercontent.com/60667298/221662229-3e0467a8-3868-4c8a-9096-dbae67be9bce.png)

### docker build images
![image](https://user-images.githubusercontent.com/60667298/221677254-0461c638-5df0-417d-b671-1319543a1c5b.png)

### docker images run

![4701b27996439d3de67de4c9593fa15](https://user-images.githubusercontent.com/60667298/221678811-1f3ec778-2ea0-4b66-8797-cb930d69db2e.png)

### docker push

![0628fa96f3f43c22a24abc5c6d480dc](https://user-images.githubusercontent.com/60667298/221679405-edbf1bc6-9297-4ad6-beb6-04bc0870edac.png)
![85fa30a409033be8f299e7e7b33033e](https://user-images.githubusercontent.com/60667298/221679650-d2d4ffc9-0bb4-46b1-848c-60f9fcdaf6b7.png)

### we create cluster cmpe172  here and also we create pod.yaml and servise.yaml for spring-mvc

![2c229fb58c23110278d919932a03d54](https://user-images.githubusercontent.com/60667298/221684481-186cdda9-97aa-407b-be65-924e94841b40.png)

### now service is runing and it can ping from 34.28.113.165:80/greeting by hello world
![image](https://user-images.githubusercontent.com/60667298/221684661-cbbbfef7-cb27-4eb0-963c-67bf180f1c8c.png)


### full screenshot 
##### locally
![image](https://user-images.githubusercontent.com/60667298/221651986-e74dcbb1-0934-4a8a-86f0-eebf811bacdc.png)
##### with GKE
![a7b1ccaae286df09e43a15499585705](https://user-images.githubusercontent.com/60667298/221685142-aa623841-ba94-432f-8c8f-a4903d3b1864.png)



## spring-test

###  For spring test project, we gonna put the codes into the spring-test folder and its test folder.

![6e863a5665d582c776bd05405b0e52a](https://user-images.githubusercontent.com/60667298/221692790-6a9f39c2-e46b-4707-b1c0-3f22f45934a2.png)

### then t oget the test report put the maven's surefire plugin into pom.xml file
![54c1ff674590049784177aac096600c](https://user-images.githubusercontent.com/60667298/221693145-2911f18f-adec-431e-b68c-aa67bb424f4c.png)


### using the surefire plugin and can invoke the test phase of the build lifecycle in order to get a report, command "mvn surefire-report:report" then we can get our report as html in site floder
![90157df583b2febf45e90e53dd22002](https://user-images.githubusercontent.com/60667298/221702038-f4a58662-5b13-4580-8a65-df24fbd9260c.png)

![a744df7818ffee28311d299cf26095e](https://user-images.githubusercontent.com/60667298/221702254-f73b3cb3-62ae-4028-8809-c0af303b9f5e.png)

### full screenshot

![4ca963f11e7012021f95e9156b4ff29](https://user-images.githubusercontent.com/60667298/221702513-0f3df079-ce8b-4147-9876-caaac119cbf1.png)


## Spring-lombok

### set up the dependencies same as spring-MVC
![image](https://user-images.githubusercontent.com/60667298/221655662-9f5e7c64-4bd0-475e-9e7a-e08339234773.png)

### follwing up the instrucation on https://springframework.guru/spring-boot-with-lombok-part-1/ we have created those jave file 

![180364c51e1ff8b45ecbf55deb7dd07](https://user-images.githubusercontent.com/60667298/221656955-b422ebf6-4375-4395-9813-67352d2244da.png)

### copy the provided code and run the springlombok application

![378c486b5e26d583941cb8f83164d91](https://user-images.githubusercontent.com/60667298/221659451-a179ec40-ca84-4170-af74-5a087f085835.png)

### trying to run the application and it be able to run then broswer will show Helloworld

![image](https://user-images.githubusercontent.com/60667298/221659908-d2f47dc0-04b3-4d61-b842-14637ec898f8.png)
![d5230e4e091467d06cbc97332ed277f](https://user-images.githubusercontent.com/60667298/221706515-7c7b07b6-b274-482b-8223-3ae5de0c21a5.png)

### When entered the local address via the browser, the print functions in the codes were activated and showed their message on the terminal. The below explanations are what the codes are and how the annotations are working in the application.

1. ValAndVarUserDemo
Val is the type of a local variable. It is not an actual type of a local variable. In Lombok, we can mark the local variable as final with Val. Var is the same as Val but it can not be marked the local variable as final. The below code shows the explanation of the Val and Var’s characteristics.
![a3d95741b0e008784f3576770584fe5](https://user-images.githubusercontent.com/60667298/221707901-24403f95-32e3-4fb1-b081-cc64045c0d56.png)

2. FieldLevelGetterSetterDemo
In Lombok, you can use @Getter and @Setter annotations at both field or class levels. The below code sets that the String variable “username” can make getter and setter, but the integer variable “userAge” can make only getter. Those are using the getter and setter at the field. The method output proves the getter and setter’s limited annotation. In addition, if the getter or setter doesn’t notice the access level, the generated getter or setter would have a public access level.

![fb8f8baf2a5292ccddc831e6cfd9cd9](https://user-images.githubusercontent.com/60667298/221708374-fa2ab88b-6615-4f3f-a247-dca880f603fb.png)

3. GetterSetterUserDemo
If you use the getter and setter annotations at the class level, Lombok affects all the fields to generate getter and setter. The below code uses getter and setter annotations at the class level and the output shows Lombok generates getter and setter methods for all the fields.
![98509be062df32c7beb305ba4b9f59d](https://user-images.githubusercontent.com/60667298/221708781-9cf4b4bd-ed9d-4193-b7de-1bed8ac4fc98.png)

4. ConstructorUserDemo
Lombok also gives the option that you can use NoArgsConstructor and AllArgsConstructor annotations. The NoArgsConstructor annotation generates the default constructor which has no arguments. Otherwise, the AllArgsConstructor annotation generates a constructor with all the fields. The output verifies that the annotations are working well by the constructor output that how the constructors’ structures using annotations are.
![b92084803410710d0c4a8da81ec52ff](https://user-images.githubusercontent.com/60667298/221709179-0f875321-e824-488d-91c5-a2759206a514.png)

5. DataUserDemo
Data annotation has covered all features: ToString, EqualsAndHashCode, Getter, Setter, and RequiredArgsConstrutor. The below output shows that Data annotation can use all features.

![aa3d788fa1a7c293acedc35177973ee](https://user-images.githubusercontent.com/60667298/221709321-f8b7d3f7-ca08-4fa8-8735-5243cc0fa15f.png)

6. NonNullUserDemo
NonNull annotation checks the parameter and throws a null pointer exception handler if the parameter is null. In the below code, the parameter of the username is null. So, the output shows that it breaks the null pointer exception.

![b1547c5c98f65dd2d90724564d6dbd3](https://user-images.githubusercontent.com/60667298/221709543-3c17c587-5e8d-468c-a36a-c5a3e3bfeba3.png)

### full screen
![ce08f4e20b278444a9f4c7c670211e7](https://user-images.githubusercontent.com/60667298/221709769-8589e2ed-e452-4b41-9c80-3d48919dd64d.png)



