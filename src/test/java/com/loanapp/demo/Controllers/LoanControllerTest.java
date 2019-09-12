package com.loanapp.demo.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loanapp.demo.Models.LoanRequest;
import com.loanapp.demo.Repositories.LoanRequestRepository;
import com.loanapp.demo.Repositories.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoanControllerTest {

    LoanController loanController;

    @Autowired
    public MockMvc mvc;

    @Mock
    LoanRequestRepository loanRequestRepository;
    LoanRequest loanRequest;

    @Before
    public void setup() throws Exception{
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
//  TEST CODE IN MOCKMVC
        try {
            mvc.perform(MockMvcRequestBuilders.post("/Deleterequest")
                    .content(asJsonString(new LoanRequest("testuser","firstname","lastname")))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").exists());
        } catch (Exception e) {
            e.printStackTrace();
        }


//  TEST CODE FOR FUNCTIONALITY
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
    public void getpassword() throws Exception {
       // this.getpassword();
        String testpassword =loanController.getpassword();
        System.out.println("passoword test password : "+testpassword);
        assertEquals(testpassword.length(),10);
    }

    @Test
    public void _getRate() throws Exception {
        System.out.println("running get test cases");
        int shortterm =1;
        int midterm =4;
        int longterm =9;
        assertEquals(loanController._getRate(shortterm),"15.0");
        assertEquals(loanController._getRate(midterm),"12.0");
        assertEquals(loanController._getRate(longterm),"10.0");

    }

//  HELPER METHODS
public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}