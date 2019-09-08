package com.loanapp.demo.Controllers;

import com.loanapp.demo.Models.*;
import com.loanapp.demo.Repositories.AcceptedLoansRepository;
import com.loanapp.demo.Repositories.LoanRequestRepository;
import com.loanapp.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@RestController
@CrossOrigin("*")
public class LoanController {
    @Autowired
    LoanRequestRepository loanRequestRepository;
    @Autowired
    AcceptedLoansRepository acceptedLoansRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserDao userepo;
    private DAOUser user;

    @RequestMapping(value = "/requestloan",method = RequestMethod.POST)
    public ResponseEntity<?> requestloan(@RequestBody LoanRequest loanRequest){
        System.out.println("/requestloan route called");
        Logger.getAnonymousLogger().warning(loanRequest.getRate());
        if(loanRequest.getAmount() ==null){
            Httpresponse httpresponse =new Httpresponse();
            httpresponse.setStatus("error");
            return ResponseEntity.ok("error");
        }else{
        Logger.getAnonymousLogger().warning(loanRequest.getRate() +"checing for null values /requestloan");
        int duration =loanRequest.getDuration();
//        float rate =_getRate(duration);
        loanRequest.setRate(_getRate(duration));
        loanRequestRepository.save(loanRequest);
        Logger.getAnonymousLogger().warning("Request for a loan has been saved");
        Httpresponse http = new Httpresponse();
        http.setStatus("ok");
        return ResponseEntity.ok("ok");}
    }


    @RequestMapping(value = "/LoanstobeAccepted",method = RequestMethod.GET)
    public List<LoanRequest> getrequests(){
        List<LoanRequest> requests =loanRequestRepository.findAll();
        return requests;
    }


    @RequestMapping(value = "/getCurrentloans",method = RequestMethod.POST)
    public List<AcceptedLoan> getUserLoans(@RequestBody UsernameObj user){
        String u_name =user.getUsername();
        List<AcceptedLoan> acceptedLoans = acceptedLoansRepository.getAcceptedLoansByUsername(u_name);
        return acceptedLoans;

    }

    @RequestMapping(value = "/AuthorizeLoan",method = RequestMethod.POST)
    public ResponseEntity<?> authorizelaon(@RequestBody LoanRequest request){
        Logger.getAnonymousLogger().warning("Authorizing Loan");
        Logger.getAnonymousLogger().warning(request.getUsername());
        String requester =request.getUsername();
        String authorizer ="admin";
        if(requester !=null ||authorizer!=null){
            LoanRequest loanRequest =request;
            AcceptedLoan acceptedLoan =new AcceptedLoan();
            acceptedLoan.setAmount(loanRequest.getAmount());
            acceptedLoan.setData(new Date().toString());
            acceptedLoan.setManager(authorizer);
            acceptedLoan.setRate(loanRequest.getRate());
            acceptedLoan.setUsername(requester);
            loanRequestRepository.delete(loanRequest);
            try {
                String pass =getpassword();
                acceptedLoan.setRefcode(pass);
                sendmail(requester,pass);

            }catch (Exception e){
                e.printStackTrace();
            }
            acceptedLoansRepository.save(acceptedLoan);
            return  ResponseEntity.ok("ok");
        }
        else{
            return  ResponseEntity.ok("fail");
        }

    }

    @RequestMapping(value = "/Deleterequest",method = RequestMethod.POST)
    private Httpresponse deleterequest(@RequestBody LoanRequest request){
        Logger.getAnonymousLogger().warning("deleting Loan");
        try {
            loanRequestRepository.delete(request);
        }catch (Exception e){
            e.printStackTrace();
            Httpresponse resp = new Httpresponse();
            resp.setStatus("error");
            return resp;
        }finally {
            Httpresponse resp = new Httpresponse();
            resp.setStatus("ok");
            return resp;
        }


    }

    @RequestMapping(value = "/getAllacceptedLoans",method = RequestMethod.GET)
    private List<AcceptedLoan> getallaccepted(){
        Logger.getAnonymousLogger().warning("/getloan details called");
        List<AcceptedLoan> accepted =acceptedLoansRepository.findAll();
        return accepted;

    }



    //Helper methods
    void sendmail(String username,String refcode){

        SimpleMailMessage msg =new SimpleMailMessage();
        try {
            user =userepo.findByUsername(username);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        msg.setTo(user.getEmail());
//        msg.setTo("pereramario19@gmail.com");
        //DEBUGING
        msg.setSubject("Congradulations!! your Loan Request has been accepted");
        msg.setText("Your Reference Code For the Loan is "+refcode+"\n Please refer for further Details from the bank branch");

        javaMailSender.send(msg);
    }


    static String getpassword()
    {
        int len =10;
        System.out.println("Generating password using random() : ");
        System.out.print("Your new password is : ");

        StringBuffer sb =new StringBuffer();

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";


        String values = Capital_chars + Small_chars +
                numbers + symbols;


        Random rndm_method = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++)
        {

            sb.append(values.charAt(rndm_method.nextInt(values.length())));


        }
       // String pass =Arrays.toString(password);

        return sb.toString();
    }

    public String _getRate(int duration){
        if(duration<2){
            return "15.0";
        }else if (duration<=5){
            return "12.0";
        }else{
            return "10.0";
        }
    }
}
