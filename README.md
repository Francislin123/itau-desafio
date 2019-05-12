# itau-desafio

- This application is responsible for 
control the flow of credit recovery systems (collection and renegotiation).

# Technologies

- Java 8
- Maven 4.0.0
- Spring Boot 2.0.8.RELEASE
- Spring Fox 2.7.0
- Lombok 1.18.0
- Hibernate Core 5.2.17.Final
- H2 Database 1.4.194
- Nexmo client 2.0.1 - Send message by SMS

### To run the application just follow the steps below.

- 1 - Enter the folder where the project jar is
- 2 - Execute the following command by cmd
- 3 - java -jar desafio-itau-0.0.1-SNAPSHOT.jar

### API Documentation (Swagger)
- Link for local access: http://localhost:8077/itau-api/v1/swagger-ui.html#/

### Database in memory H2
- http://localhost:8077/itau-api/v1/h2/

### Send messages by sms instructions
- It stops sending messages by sms and I need to configure the credentials in this link: https://dashboard.nexmo.com/

### Send email with Gmail (Google)
- To send mail, the configuration made and to gmail

### The sql project file is in the folder
- resources/db

### Database modeling
![Captura de Tela 2019-05-11 às 18 46 50](https://user-images.githubusercontent.com/27180618/57575590-b4f2d000-7423-11e9-9ad5-ec3623d012bf.png)

### Solution Deployment Diagram
![Captura de Tela 2019-05-12 às 15 18 49](https://user-images.githubusercontent.com/27180618/57586263-c989a380-74c9-11e9-9254-14a959166194.png)

### Architecture diagram
![Captura de Tela 2019-05-12 às 15 54 17](https://user-images.githubusercontent.com/27180618/57586610-68180380-74ce-11e9-91e7-b9234da63b0c.png)
