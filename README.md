# Address Book API
This address book API has the ability to search a list of customers by their surname. When a customer is selected, their full contact details are
returned as JSON. 

# User manual

### System requirements
 - Spring boot
 - Java 8
 - Maven

### Build
```mvnw install```

### Test
```mvnw test```

### Start
```mvnw springboot:run```

# API Endpoints
#### Search contacts using last name
GET ```http://localhost:8090/api/v1/contacts/search?lastName={lastNameValue}```
This endpoint searches the list of customers by their last name and returns ID numbers of found contacts. Last name is passed through a query string parameter ```lastName```. ID numbers are returned as an array. If no result is found, then empty array is returned.


#### Get detailed information about contact
GET ```http://localhost:8090/api/v1/contacts/get?id={contactIdNumber}```
This endpoint returns the full details of selected contact basedon their ID. ID number is passed through a query string parameter ```id```. Their full contact details are returned as JSON.
