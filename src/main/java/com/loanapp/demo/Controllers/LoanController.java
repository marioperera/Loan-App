package com.loanapp.demo.Controllers;

import com.loanapp.demo.Models.*;
import com.loanapp.demo.Repositories.AcceptedLoansRepository;
import com.loanapp.demo.Repositories.LoanRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin("*")
public class LoanController {
    @Autowired
    LoanRequestRepository loanRequestRepository;
    @Autowired
    AcceptedLoansRepository acceptedLoansRepository;

    @RequestMapping(value = "/requestloan",method = RequestMethod.POST)
    public ResponseEntity<?> requestloan(@RequestBody LoanRequest loanRequest){
        System.out.println(loanRequest.getAmount());
        Logger.getAnonymousLogger().warning(loanRequest.getRate());
        Logger.getAnonymousLogger().warning(loanRequest.getRate() +"checing for null values /requestloan");
        loanRequestRepository.save(loanRequest);
        Logger.getAnonymousLogger().warning("Request for a loan has been saved");
        Httpresponse http = new Httpresponse();
        http.setStatus("ok");
        return ResponseEntity.ok("ok");
    }


    @RequestMapping(value = "/getCurrentloans",method = RequestMethod.POST)
    public List<AcceptedLoan> getUserLoans(@RequestBody UsernameObj user){
        String u_name =user.getUsername();
        List<AcceptedLoan> acceptedLoans = acceptedLoansRepository.getAcceptedLoansByUsername(u_name);
        return acceptedLoans;

    }

    @RequestMapping(value = "/AuthorizeLoan",method = RequestMethod.POST)
    public AuthorizedLoanResponse authorizelaon(@RequestBody AuthorizeLoanRequest authorizeLoanRequest){
        Logger.getAnonymousLogger().warning("Authorizing Loan");
        String requester =authorizeLoanRequest.getAuthorizeeUsername();
        String authorizer =authorizeLoanRequest.getAuthorizerUsername();
        if(requester !=null ||authorizer!=null){
            LoanRequest loanRequest =loanRequestRepository.getByUsername(requester);
            AcceptedLoan acceptedLoan =new AcceptedLoan();
            acceptedLoan.setAmount(loanRequest.getAmount());
            acceptedLoan.setData(new Date().toString());
            acceptedLoan.setManager(authorizer);
            acceptedLoan.setRate(loanRequest.getRate());
            acceptedLoan.setUsername(requester);
            acceptedLoansRepository.save(acceptedLoan);
            return new AuthorizedLoanResponse("ok",requester);
        }
        else{
            return new AuthorizedLoanResponse("fail",null);
        }

    }
}
