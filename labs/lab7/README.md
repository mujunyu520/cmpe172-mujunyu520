# CMPE 172 - Lab #7 Notes

# Cybersource information
  ### Marchant ID : mujunyu520
  ### EBC username: mujunyu520
  ### EBC user pass :Mujunyu68691822..0
  
  API Key ID：771cda06-d44f-4e4f-9c9c-0860bfc7f8c5
  API KEY Shared Secret =7fowyVxxsrRkDurrEmyFM/dA7+Nh9RXwXXiX7VFdzk8=


## Spring CyberSource
### For Spring CyberSource exercise, we need to sign up for a free developer sandbox at Cybersource. I followed the direction which is on the assignment
Before starting the spring cybersource exercise, we need to set up the environment as below picture:
![spring-cybersource_1](https://user-images.githubusercontent.com/60667298/235919127-8fa548a9-634b-43ee-8882-695bd1293bd6.png)

![spring-cybersource_2](https://user-images.githubusercontent.com/60667298/235919182-f02365c8-8cad-443c-8643-a01223964b46.png)
After that, we have to add the code files which are from the professor.

![code_ spring-cybersource_3](https://user-images.githubusercontent.com/60667298/235919209-35c5b2f6-77c9-4782-8574-a4ef26e75bad.png)

For using JSON file to communicate between the cybersource and the spring-cybersource application, we need to use Jackson because Jackson can parse and generate Json files using Java Json library. The program is used Java base and it needs to deliver the Json file to the database. So, we should add the dependencies into pom.xml:
![spring-cybersource_4](https://user-images.githubusercontent.com/60667298/235919309-487212b7-2faa-4d6f-a698-74ae357c127d.png)

Above I mentioned, the responding error was occured using my account. So, if we have the error is generated, we can use professor's account, key, and shared secret key. For easy to find the result on the Cybersource page, we would change the reference value in the code to our own github user id. The account id, key, and shared secret key will be located in application.properties:
![spring-cybersource_5](https://user-images.githubusercontent.com/60667298/235919376-935dc830-8547-4503-a1e3-b67a82c64514.png)
Also, the execution result will be on the Cybersource's transaction section:
![transaction spring-cybersource_6](https://user-images.githubusercontent.com/60667298/235919431-dae47403-4652-4898-b13a-03ea322b06dd.png)
The local machine's console log and the log of the Cybersource's transaction page have the same values.

[full screenshot of desktop]

## Spring-payment
### For Spring Payment exercise, we need to set up the environment as below picture:
![spring-payment—1](https://user-images.githubusercontent.com/60667298/235919596-522bed2a-d90c-4989-be8a-f5fe5cb4a837.png)

![spring-payment](https://user-images.githubusercontent.com/60667298/235919637-ffe6cc4a-c14a-4e54-acdd-f6ec48dd08e7.png)
For applying the validation requirements, we use the H2 database and Spring JPA Repositories to persist the payment information, we would add the repository which includes payments commands.
![sprng-payment-4](https://user-images.githubusercontent.com/60667298/235919709-7fba9e69-7a2d-4e09-9560-17fd79748e1c.png)

Also, we add the form files which needs to validattion requirements from payments commands.

After that, we add the code lines into the application.properties for store the log into the Cybersource and H2 database:

![spring-payment-5](https://user-images.githubusercontent.com/60667298/235919773-f0c43f32-3376-4546-bfaa-c59d10d939f7.png)

We compile the application using Maven then run it
When we execute the browser with localhost:8080, we can see the payment page:
![spring-payment-6](https://user-images.githubusercontent.com/60667298/235920000-bd019ec2-c0b9-4773-b786-4513a0412141.png)

If we click the process payment button without any inputs, we can see the error messages below the button:

Also, if we input the wrong credit card information, the application shows unsupported credit card type message.
![spring-payment-7](https://user-images.githubusercontent.com/60667298/235920067-0164d5a8-678e-4011-a785-77fd77db5fab.png)

For testing the process, we need the correct card information. So, the Cybersource provides the test credit card information:
![spring-payment-8](https://user-images.githubusercontent.com/60667298/235920233-8814779a-89bd-4402-b865-ba1fbc6c6962.png)
If we input all correct information into the payment's input boxes, we can see the successful payment message.

![spring-payment successfuly _13](https://user-images.githubusercontent.com/60667298/235920316-2bb7821a-dbc0-427a-996a-8222764e3884.png)
The data are delivered to the cybersource transaction. When we compare the local machine's console log and the cybersource's transaction page, we can see the same data were delivered successfully.
![spring-payment-capture-14](https://user-images.githubusercontent.com/60667298/235920418-b5e4437b-53d2-4916-a7db-ea4bbedfe2b0.png)

For duble checking the data are currectly delivered or not, we can check though the H2 database:
![spring-payment 👌](https://user-images.githubusercontent.com/60667298/235920464-2f4f6407-0231-407d-99b6-215ec7b11e0e.png)

[full screenshot of desktop]
![full screen-payment](https://user-images.githubusercontent.com/60667298/235920690-ffe8db89-2f97-49f3-ac7c-2afe514a22d5.png)

