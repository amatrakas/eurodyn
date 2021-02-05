package com.controllers;

import com.dataTransferObjects.User;
import com.services.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    @Autowired
    Util util = new Util();

    @RequestMapping(method = RequestMethod.GET, value = "/register/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findUserByEmail(@PathVariable(name = "email") String email) {

        User user = new User();
        user = util.findUser(email);
        JSONObject jsonObject;

        if (user == null) {
             jsonObject = new JSONObject("user not exists");
             return jsonObject.toString();
        }else {
             jsonObject = new JSONObject(user);
        }
        return jsonObject.toString();
    }
}




