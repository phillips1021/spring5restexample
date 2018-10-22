# spring5restexample
Spring 5 REST example that goes with PluralSight course Spring REST: Getting Started

This example application uses MySQL as the database server

See resources/application.properties for MySQL server settings

To run the application in the project's root folder execute: mvn spring-boot:run

Using Postman or cURL or some other tool to make REST web service requests you can use do the following

Get all Friend objects

   Get request to http://localhost:8080/friend
   
Add a Friend object
   
   Post request to http://localhost:8080/friend with a JSON body of
    
       {
	"firstName":"Bruce",
	"lastName":"Phillips"
}

Update a Friend object

   Put request to http://localhost:8080/friend with a JSON body of
   
   {
	"id":2,
	"firstName":"Linus",
	"lastName":"Torvald"
}

NOTE the id value is the id of the Friend object in the database that you want to update

Delete a Friend Object

Delete request to http://localhost:8080/friend/3 where the last value is the ID of the Friend object in the database that you want to delete


