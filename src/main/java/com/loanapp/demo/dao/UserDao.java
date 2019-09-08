package com.loanapp.demo.dao;


import com.loanapp.demo.Models.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends JpaRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);




}