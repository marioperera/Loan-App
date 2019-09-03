package com.loanapp.demo.Repositories;

import com.loanapp.demo.Models.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long> {

    List<Users> getByEmail(String Email);

    Users getOneByEmail(String Email);

}
