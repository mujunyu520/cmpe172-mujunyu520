# CMPE 172 - Lab #1 

## *part 1 demo-initializr*
### follwing parameter via  https://start.spring.io/ Chosing  Meven, java, spring boot with 2.7.8v, project metadata name: demo-initilizer. packaging Jar, java 17. shows in screenshot.
![7b3284a003228463b854586573a9a4a](https://user-images.githubusercontent.com/60667298/218383637-65fee600-0bce-4fdf-b2a1-005ca8b20fd6.png)

### generate the project and download the zip file.  
![e1d87a968a7431678de678694984a87](https://user-images.githubusercontent.com/60667298/218383645-484fd485-778a-4e7c-ae86-6a329668d637.png)

### zip out the file and move to the Lab1 folder.  

![164dfe1f9316bf2c67830bcaa033ad3](https://user-images.githubusercontent.com/60667298/218383850-7f540bc6-c9d5-44c4-9b64-2ceb5ef8a5b4.png)

### push and commit to the main in github.  

![2f57c23f39e8c733ae2eaea50712e01](https://user-images.githubusercontent.com/60667298/218384032-16b0073b-86a6-445a-b6ae-0fafaf739aab.png)

### open the demo initializer project and let it auto setup.  

![93db644f30e936a66855368a606d154](https://user-images.githubusercontent.com/60667298/218385741-1fd3de1e-d322-47c6-b4bb-fa3ae4365057.png)

### motify the class name to match the code generated.


![b6ee46b3e1a57af8cccf0477baae4a6](https://user-images.githubusercontent.com/60667298/218385951-2aafc595-e2d3-4978-b8e0-93045551a3b7.png)


### run the demo app.  
![5dece49dd651e2d9166ba1a63e14bfa](https://user-images.githubusercontent.com/60667298/218386135-aa780ef0-5da6-47cf-b9e7-63e49aa7344d.png)

### successfully run the demo app

![f5bdba08f732081b6845b40562c4e12](https://user-images.githubusercontent.com/60667298/218386729-ec57d68a-c67d-49ce-b427-6ec5d2650bd8.png)

### Hello CMPE 172!

![image](https://user-images.githubusercontent.com/60667298/218390113-80a56282-c957-4b24-993a-9aa28569e65b.png)    




## *part 2 demo-Docker*

### create another demo app demo-docker  
![25acd2fbea6c9a41b64791397dfb720](https://user-images.githubusercontent.com/60667298/218392596-26f39ed6-9b4d-42b2-93a0-c7ca2c10603a.png)

### choosing those two dependencies

![dcd0296ebec8d0eea7e217678b9fc30](https://user-images.githubusercontent.com/60667298/218392694-6cc645cd-f31a-4099-a90e-abd1fc008691.png)


### using the provided code to run the demo

![image](https://user-images.githubusercontent.com/60667298/218393438-f3c0036e-debf-43e8-b402-be1b38d37382.png)

### first of all we have to install and pack the image for docker


![demo-docker_4](https://user-images.githubusercontent.com/60667298/218394668-c1381340-1349-42a4-ac39-e509f76427fe.png)

### build the docker ``` docker build -t demo-docker .```  

![1239d4df270313066c1855479c7c238](https://user-images.githubusercontent.com/60667298/218399987-c261b993-c901-4ccf-96dc-3df8443cda09.png)

### view the docker images to ensure so far we were doing right! ``` docker images```

![8bbf6e5daa5fbb899eaaa94e50c05be](https://user-images.githubusercontent.com/60667298/218400043-59a04f6d-775d-4a78-82dc-158f126323f2.png)

### run the images from docker

![ec200f246f0bfa0dc3ea6b5d6e449dd](https://user-images.githubusercontent.com/60667298/218412126-2aecf408-a621-42ab-8d96-5f4cbf4a039c.png)

![31996484b5e4cc527458e71ee4e0ddd](https://user-images.githubusercontent.com/60667298/218412227-8ec1ed85-2fa7-4991-9eac-135889d68501.png)

### push the image to docker
![608450f07e7f166a0d2d68d31f0a501](https://user-images.githubusercontent.com/60667298/218413572-510c8ec1-5fb4-4372-88d4-468de71b46f8.png)


### set up the pod.yaml and service.yaml

![image](https://user-images.githubusercontent.com/60667298/218414578-4984a68d-e09e-4ee2-9e1b-e82b8ffddfef.png)


### using the cloud shell terminal to create cluster and service

![8d17bb3fbf0add240e1fe8ec7d1754c](https://user-images.githubusercontent.com/60667298/218418721-86a529e6-9582-4e33-b605-6a3a02c7837e.png)



### running spring demo app locally, running in docker, and google cloud. full screenshot.

![e68246831ea4f1d8e393cca885ca5e4](https://user-images.githubusercontent.com/60667298/218420106-4dac9bbf-9ce8-4968-9ebb-c7638716ca1e.png)

## *part 3 demo-intellij*

### create a new project demo-intellij
![b9d57b3587b678a25041cf05de76ff0](https://user-images.githubusercontent.com/60667298/218422238-2e03cf8d-e610-4eff-9b11-0e5610ff54ff.png)

### edit the code to match the code genarator 
![65b96367f65a0928fd94b717f057126](https://user-images.githubusercontent.com/60667298/218424206-eeae93dd-8a40-4cce-acd4-58d069bc1ee9.png)

### after run the demo app click the url of http://localhost:8080/hello, http://localhost:8080/hello?name=Amy. it shows the CMPE172! and Hello amy
![71bc6ab2929afbb76e07d469564f892](https://user-images.githubusercontent.com/60667298/218425836-5e0a6796-5260-41d7-8f19-cebb5967b25a.png)

