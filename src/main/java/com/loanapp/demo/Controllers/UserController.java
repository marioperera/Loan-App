package com.loanapp.demo.Controllers;

import org.hibernate.boot.jaxb.Origin;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {


    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String checkPage() {
        Logger.getAnonymousLogger().warning("/hello route called from usercontroller");
        return "Hello World";
    }


}

