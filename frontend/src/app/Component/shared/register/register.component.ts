import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username = ''
  password = ''
  email = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  register() {
    this.loginservice.Register(this.username,this.password,this.email).subscribe(Data =>{
      if(Data.username){
        console.log("user has registered"+Data.username);
        
        this.router.navigate(['login']);
      }
    })

  }

  routetologin(){
    this.router.navigate(['login']);
  }

}
