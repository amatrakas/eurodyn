package com.controllers;

import com.dataTransferObjects.User;
import com.services.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class UserController {
    private final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    Util util = new Util();


    @GetMapping("/")
    public String myForm(Model model){
        logger.info("UserController.myForm starts..");
        User user = new User();
        model.addAttribute("user",user);
        logger.info("UserController.myForm ends..");
        return "index";
    }

    @PostMapping("/register")
    public String submitMyForm( @Valid User user, BindingResult bindingResult){
        logger.info("UserController.submitMyForm starts..");
        boolean errorFound = bindingResult.hasErrors();
        if (errorFound) {
            return "index";
        }
        try {
            logger.info("Calling the service to get the UUID");
            user =  util.uniqueId(user);
            logger.info("USER: " + user);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.info("UserController.submitMyForm ends..");
        return "register_success";
    }


}


