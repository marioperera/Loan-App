package com.loanapp.demo.Controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.loanapp.demo.Models.AcceptedLoan;
import com.loanapp.demo.Models.Httpresponse;
import com.loanapp.demo.Models.LoanRequest;
import com.loanapp.demo.Models.UsernameObj;
import com.loanapp.demo.Repositories.AcceptedLoansRepository;
import com.loanapp.demo.Repositories.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin("*")
public class TestController {
    @Autowired
    LoanRequestRepository loanRequestRepository;
    @Autowired
    AcceptedLoansRepository acceptedLoansRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String checkPage() {
        Logger.getAnonymousLogger().warning("/hello route called from testcontroller");
        return "Hello World";
    }
//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(value = "/requestloan",method = RequestMethod.POST)
//    public Httpresponse requestloan(@RequestBody LoanRequest loanRequest){
//
//        loanRequestRepository.save(loanRequest);
//        Logger.getAnonymousLogger().warning("Request for a loan has been saved");
//        Httpresponse http = new Httpresponse();
//        http.setStatus("ok");
//        return http;
//    }
//    @CrossOrigin(origins = "http://localhost:4200")
//    @RequestMapping(value = "/getCurrentloans",method = RequestMethod.POST)
//    public List<AcceptedLoan> getUserLoans(@RequestBody UsernameObj user){
//        String u_name =user.getUsername();
//        List<AcceptedLoan> acceptedLoans = acceptedLoansRepository.getAcceptedLoansByUsername(u_name);
//        return acceptedLoans;
//
//    }

}
