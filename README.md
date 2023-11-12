Considerations:\
-> Using autowireds is not a good approach. Int his case, constructors with constants and used to improve efficiency and
ensure object integrity\
-> Database is H2, this means it is self-generated inside the project and erased when project is shutting down.\
-> No docker needed on this example, although it would be great to have.\
-> Database constraints implemented in jpa layer, although it is implemented on mapper layer, too\
-> All get endpoints should be pageable, not return everything.\
-> If queries are getting complex, using Pageable and Filtering objects from spring boot would be a good choice.\
-> When searching, I put title and author by full match, but it should look for "like", since we don't filter author
by "Luis de Góngora", we want to see Gongora's books by typing only "gon".\
-> using DTO prevents many attacks, this is automatically done by mapstruct\
-> using lombok to prevent boilerplate code\
-> mapper layer also validates data\
-> app should be tested, but generating context is an overkill for this time. I'd use gherkin to test user Histories 
and junit for functional testing \


URL FOR SWAGGER UI: -> This allows to test everything from the frontend side in an easy way, same as postman
http://localhost:8080/swagger-ui/index.html#/

Requirements:
Java 17
Maven / Gradle

How to run the project:
mvn i && mvn spring-boot:run