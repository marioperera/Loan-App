package com.loanapp.demo.Repositories;

import com.loanapp.demo.Models.AcceptedLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcceptedLoansRepository extends JpaRepository<AcceptedLoan,Long> {
    List<AcceptedLoan> getAcceptedLoansByUsername(String user);

//    AcceptedLoan save(AcceptedLoan acceptedLoan);
}
