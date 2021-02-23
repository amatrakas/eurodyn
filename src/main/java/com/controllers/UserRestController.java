package com.controllers;

import com.dataTransferObjects.User;
import com.services.Util;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    private final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    Util util = new Util();

    @RequestMapping(method = RequestMethod.GET, value = "/register/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findUserByEmail(@PathVariable(name = "email") String email)  {
        logger.info("UserRestController.findUserByEmail starts..");
        JSONObject jsonObject;
        User fUser = new User();
         try{
                fUser = util.findUser(email);
         } catch (Exception e) {
             logger.error(e.getMessage());
         }
        if(fUser!=null) {
            jsonObject = new JSONObject(fUser);
        }else{
            jsonObject = new JSONObject("{\"error:\":\"User does not exists in  cache\"}");
        }
        logger.info("UserRestController.findUserByEmail ends..");

        return jsonObject.toString();

    }
}




