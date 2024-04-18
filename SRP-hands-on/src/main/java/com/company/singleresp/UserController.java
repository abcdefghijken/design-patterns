package com.company.singleresp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

//Handles incoming JSON requests that work on User resource/entity
public class UserController {
	//Store used by controller
    // private Store store = new Store();
    // Create UserPersistenceService class (store)
    UserPersistenceService service = new UserPersistenceService();
    
    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        User user = mapper.readValue(userJson, User.class);

        // Create UserValidator class and use the class
        UserValidator validator = new UserValidator();
        if(!validator.isValid(user)) {
            return "ERROR";
        }

        service.saveUser(user);
        
        return "SUCCESS";
    }

}