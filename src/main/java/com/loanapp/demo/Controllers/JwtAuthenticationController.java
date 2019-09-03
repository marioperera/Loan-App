package com.loanapp.demo.Controllers;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import com.loanapp.demo.Models.UserDTO;
import com.loanapp.demo.Repositories.UsersRepository;

import com.loanapp.demo.Config.JwtTokenUtil;
import com.loanapp.demo.Models.JwtRequest;
import com.loanapp.demo.Models.JwtResponse;
import com.loanapp.demo.Models.Users;
import com.loanapp.demo.Repositories.UsersRepository;
import com.loanapp.demo.Service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private PasswordEncoder bcryptEncoder;


  //  @PostMapping("/authenticate")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        Logger.getAnonymousLogger().warning("/authentication called");
        //logger.warn("JWT Token does not begin with Bearer String");
        Logger.getAnonymousLogger().warning(authenticationRequest.getUsername());
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }
//    public Users RegisterUser(@RequestBody Users users) throws Exception{
//        String Email =users.getEmail();
//        List<Users> checkuser =usersRepository.getByEmail(Email);
//        if (checkuser.size()>0){
//            return null;
//        }else {
//            usersRepository.save(users);
//            return users;
//        }
//
//    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}