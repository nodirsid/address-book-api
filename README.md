# Address Book API
This address book API has the ability to search a list of customers by their surname. When a customer is selected, their full contact details are
returned as JSON. 

# User manual

### System requirements
 - Spring Boot version 2.2.5 and up
 - Java version 8 and up
 - Maven version 3.6 and up

### Compile
From the root directory of the project run ```mvnw compile```

### Test
From the root directory of the project run ```mvnw test```

### Start
From the root directory of the project run ```mvnw springboot:run```

# API Endpoints
#### Search contacts using last name
GET ```http://localhost:8090/api/v1/contacts/search?lastName={lastNameValue}```
This endpoint searches the list of customers by their last name and returns ID numbers of found contacts. Last name is passed through a query string parameter ```lastName```. ID numbers are returned as an array. If no result is found, then empty array is returned.


#### Get detailed information about contact
GET ```http://localhost:8090/api/v1/contacts/get?id={contactIdNumber}```
This endpoint returns the full details of selected contact basedon their ID. ID number is passed through a query string parameter ```id```. Their full contact details are returned as JSON.
