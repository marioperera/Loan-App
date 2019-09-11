package com.loanapp.demo.Repositories;

import com.loanapp.demo.Models.LoanRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

public class LoanRequestRepositoryTest {

    @Mock
    LoanRequestRepository loanRequestRepository;
    LoanRequest loanRequest;

    @Before
    public void setUp() throws Exception {
        System.out.println("setting up system");
        MockitoAnnotations.initMocks(this);
        loanRequest =new LoanRequest();

    }

    @Test
    public void getByUsername() {
        this.loanRequest.setUsername("testuser");
        this.loanRequest.setFirstname("testFirstname");
        this.loanRequest.setLastname("testlastname");
        this.loanRequest.setAmount((long) 400000.0);
        this.loanRequest.setRate("12.0");
        this.loanRequest.setNic("960213459v");
        when(this.loanRequestRepository.getByUsername("testuser")).thenReturn(loanRequest);
        assertEquals(this.loanRequestRepository.getByUsername("testuser").getUsername(),"testuser");
        verify(loanRequestRepository,times(1)).getByUsername("testuser");
    }
}