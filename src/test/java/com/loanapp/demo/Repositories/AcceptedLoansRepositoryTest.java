package com.loanapp.demo.Repositories;

import com.loanapp.demo.Models.AcceptedLoan;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AcceptedLoansRepositoryTest {

    @Mock
    AcceptedLoansRepository acceptedLoansRepository;
    public AcceptedLoan acceptedLoan;

    @Before
    public void setup(){
        acceptedLoan =new AcceptedLoan();
        System.out.println("setting up system");
        MockitoAnnotations.initMocks(this);
        acceptedLoan =new AcceptedLoan();
        acceptedLoan.setUsername("testuser");
        acceptedLoan.setId((long) 12);
    }

    @Test
    public void begintest(){
        HashSet<AcceptedLoan> acceptedLoans =new HashSet<>();
        acceptedLoans.add(acceptedLoan);
        when(this.acceptedLoansRepository.getOne((new Long(12) ))).thenReturn(acceptedLoan);
        assertEquals(this.acceptedLoansRepository.getOne(new Long(12)).getId(),new Long(12));
        verify(acceptedLoansRepository,times(1)).getOne(new Long(12));
    }

}