# Backend_Traini8_Rushivardhan_G

Traini8: Problem Statement

Assume that you are working at a startup Traini8. You must make an MVP for a registry for Govt funded Training Centers with the following minimum requirements. In the MVP, you must create a Spring or Play project with support for two APIs, which are explained below.

Explanation:
         Firstly, I created a spring boot project “Assignment” using “Spring Initializer” where I added all the required dependencies for my project and downloaded as a jar folder. Then In Assignment project I added all the packages and classes required for it. Then added the Postgres properties in application properties file, and all other requirements

Entities: 
  • Training center: this contains all the fields given in the requirements along with a embedded address class.

  • Address: this is a embedded class which encapsulates the fields of a address and helps in easy modifications and creation rather than single field in the main entity.
  
Functionality: 
  • As the given instructions in the assignment, when a new centre is created it will valid the given email and phone number whether they are in correct format or not.

  • CenterName should be below 40, CenterID should be of length 12characters, email and phone number should bein correct format if wrong will return error. Technologies Used:

Java Spring Boot for building the RESTful API.
PostgreSQL for Database management.
Postman for API documentation.
Render for Postgres and Redis Deployment
Docker for creating a image for spring boot application
Docker repository: Name of the Repository: rushivardhan/mvp-assignment Pull command: docker pull rushivardhan/mvp-assignment:latest Run command: docker run -p 8080:8080 rushivardhan/mvp-assignment:latest

Then please execute the postman requests for the working of the flow. Please find the attached postman collection in the project folder

PLEASE READ THE ATTACHED README PDF FOR MORE DETAIL INFORMATION
