package com.loanapp.demo.Repositories;

import com.loanapp.demo.Models.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRequestRepository extends JpaRepository<LoanRequest,Long> {

    LoanRequest getByUsername(String username);

}
