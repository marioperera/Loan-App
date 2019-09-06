import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { Router } from '@angular/router';
import { GetLoanDataServiceService } from 'src/app/Services/get-loan-data-service.service';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService,private getloanDataservice:GetLoanDataServiceService) { }

  ngOnInit() {
  }

  checkLogin() {
    this.getloanDataservice.testAPI().subscribe(res =>{
      console.log(res);
      
    });
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
        console.log("User logged");
        
        console.log(data.role);
        if(data.role ==='client'){
          this.router.navigate(['client']);
        }else{
          this.router.navigate(['manager']);
        }
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true

      }
    )
    );

  }

  routetoRegister(){
    this.router.navigate(['/register']);
  }

}
