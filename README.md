работает адрес
http://localhost:8080/actuator/health
http://localhost:8080/actuator/mappings

работает консоль db
http://localhost:8080/h2-console/
password - password

Swagger
http://localhost:8080/swagger-ui/index.html


Backend developer task

Read the requirements below, develop a new OpenAPI 3.0 yaml contract file (contract first approach) and implement a Spring Boot microservice implementing the OpenAPI 3.0 yaml contract. Gradle must be used as a build automation tool.

Description:
Currency conversion calculation service.
Conversion shall be done in two directions:
Client has some specific amount of EUR and wants to buy GBP. Service returns GBP amount that can be bought.
Client wants to buy some specific amount of GBP and wants to know what amount of EUR he needs. Service returns EUR amount that is required to buy a specific amount of GBP.

Sample use cases:
Client wants to buy some GBP by selling 100.00 EUR.
Client wants to buy 100.00 GBP by selling some EUR. 

The current baseline rate is 1.2375, i.e. 1.00 GBP = 1.23 EUR. The rate shall be stored in a database, e.g. in H2 in-memory database.
The required margin is 2%. The margin is applied to the calculated part, i.e. to EUR in the 1st case, to GBP in the 2nd case. The margin shall be stored in application parameters (application.yml)
Input and output amounts should have 2 decimal places.

Task: Service should return required amount of EUR for the 1st case and calculated amount of GBP in the 2nd case.

What will be evaluated:
 - contract design (in contract file)
 - data model design
 - correct use of abstraction layers (e.g. Controllers and Services)
 - code tidiness (formatting, naming, absence of duplication/typos/abbreviations) 
 
Please commit the results to a git repository (Gitlab/Github/our choice) and provide us with access. 
 
Bonus points for:
 - test harness
 - Swagger UI page that can be used to check the service
 - Correct http codes for client/server errors
 
Other suggestions:
 - take a look at openapi-generator-maven-plugin, it can generate Spring APIs interfaces automatically 
 
We welcome any question that might arise during the execution of this task.
We don't expect you to spend more than a day on this task.
We will pay €50 for a working solution (e.g. compiles, runs, use cases work fine, key requirements met).
If it satisfies other requirements you will receive an offer as well.


Please commit the solution to a github (or any other service) repository and share the solution with us.
You are not expected to spend more than 60-90 minutes to complete this task. Perfection is also not expected.