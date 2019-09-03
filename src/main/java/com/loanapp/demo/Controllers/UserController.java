package com.loanapp.demo.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {



  //  @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public String firstPage() {
        return "Hello World";
    }


}

