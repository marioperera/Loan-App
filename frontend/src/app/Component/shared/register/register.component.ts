import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username:String = ''
  password:String = ''
  email:String = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  register() {
    console.log("register called");
    
    this.loginservice.Register(this.username,this.password,this.email).subscribe((Data:any) =>{
      if(Data.status =="fail"){
        this.invalidLogin =true;
        console.log(Data);
      }else{
        this.router.navigate(['login']);
      }
      
    })
    
    
  }

  routetologin(){
    this.router.navigate(['login']);
  }

}
