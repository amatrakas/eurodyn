package com.controllers;

import com.dataTransferObjects.User;
import com.services.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    Util util = new Util();

    @GetMapping("/register")
    public String myForm(Model model){
        User user = new User();
        model.addAttribute("user",user);

        return "index";
    }

    @PostMapping("/register")
    public String submitMyForm(@Valid User user, BindingResult bindingResult){
        boolean errorFound = bindingResult.hasErrors();
        if (errorFound) {
            return "index";
            }else{
            System.out.println("Calling the service to get the UUID");
            user =  util.uniqueId(user);
            System.out.println("USER: " + user);
            return "register_success";
        }

    }
}

