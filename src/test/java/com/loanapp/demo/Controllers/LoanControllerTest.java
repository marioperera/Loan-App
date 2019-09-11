package com.loanapp.demo.Controllers;

import com.loanapp.demo.Models.LoanRequest;
import com.loanapp.demo.Repositories.LoanRequestRepository;
import com.loanapp.demo.Repositories.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoanControllerTest {

    LoanController loanController;
    @Mock
    LoanRequestRepository loanRequestRepository;
    LoanRequest loanRequest;

    @Before
    public void setup(){
        System.out.println("tests are running");
        loanRequest =new LoanRequest();
        loanController =new LoanController();
    }

    @Before
    public void doesExist(){
        System.out.println("checking for existance");
        MockitoAnnotations.initMocks(this);
        assertEquals(true,this.loanRequestRepository!=null);
    }

    @Test
    public void getrequests() {
        HashSet loanrequests =new HashSet();
        this.loanRequest.setUsername("testuser");
        this.loanRequest.setFirstname("testFirstname");
        this.loanRequest.setLastname("testlastname");
        this.loanRequest.setAmount((long) 400000.0);
        this.loanRequest.setRate("12.0");
        this.loanRequest.setNic("960213459v");
        //loanrequests.add(loanRequest);
        when(this.loanRequestRepository.save(loanRequest)).thenReturn(loanRequest);
//        when(this.loanRequestRepository.getByUsername())

        assertEquals( this.loanRequestRepository.save(loanRequest).getUsername(),"testuser");
        assertEquals(this.loanRequest.getUsername(),"testuser");
//        Verify loanRequestRepository
        verify(loanRequestRepository,times(1)).save(loanRequest);
       // this.loanRequestRepository.delete(this.loanRequestRepository.getByUsername("testuser"));
    }

    @Test
    public void requestloan() {
    }


    @Test
    public void getpassword() {
       // this.getpassword();
        String testpassword =loanController.getpassword();
        System.out.println("passoword test password : "+testpassword);
        assertEquals(testpassword.length(),10);
    }

    @Test
    public void _getRate() {
        System.out.println("running get test cases");
        int shortterm =1;
        int midterm =4;
        int longterm =9;
        assertEquals(loanController._getRate(shortterm),"15.0");
        assertEquals(loanController._getRate(midterm),"12.0");
        assertEquals(loanController._getRate(longterm),"10.0");

    }
}