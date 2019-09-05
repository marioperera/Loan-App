import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetLoanDataServiceService } from 'src/app/Services/get-loan-data-service.service';
import { LoanRequest } from 'src/app/Models/LoanRequest';

@Component({
  selector: 'app-customerhome',
  templateUrl: './customerhome.component.html',
  styleUrls: ['./customerhome.component.css']
})
export class CustomerhomeComponent implements OnInit {

  getloanview:boolean =false;
  requestLoan:boolean =false;
  calculateLoan:boolean =false;

  //Requesting Loan Variables
  username:string =sessionStorage.getItem('username');
  firstname:string;
  lastname:string;
  address:string;
  nic:string;
  rate:number;
  duration:number;
  assettype:string;
  amount:number;

  //Generating Intrests component
  amount_base:number ;
  rate_pa:number ;
  duration_yr:number ;
  isCompound:boolean =false;
  isSimple:boolean =false;  

  car:Car = new Car();
  colours = Array<Colour>();
  constructor(private router: Router,private getloansService:GetLoanDataServiceService) { }

  ngOnInit() {
    this.getloansService.getloandetails().subscribe(res =>{
      console.log("from component"+res);
      
    })
    


  }

  RequestLoan(){
   
    console.log(this.username,this.firstname,this.lastname,this.nic,this.duration,this.assettype,"pending",this.rate,this.amount);
    var loan =new LoanRequest()
    loan.state ="pending";
    loan.firstname =this.firstname;
    loan.lastname =this.lastname;
    loan.username =this.username;
    loan.nic =this.nic;
    loan.duration =this.duration;
    loan.assettype =this.assettype;
    loan.amount =this.amount;
    
    this.getloansService.requestLoan(loan).subscribe(res =>{
      console.log(res);
      
    })

  }

  logout(){
    sessionStorage.removeItem('username')
    this.router.navigate(['login']);
  }

  generateIntrest(){

    // console.log(this.isCompound);
    // console.log(this.isSimple);
    console.log(this.rate,this.amount,this.duration);
    
    if(this.isCompound){
      let val =this.amount_base*(1+this.rate_pa/100)**this.duration_yr;
      val =val-this.amount_base;
      alert("The Interest Payable is Rs."+Math.floor(val) );
    }else{
      let val =this.amount_base*this.rate_pa/100*this.duration_yr;
     // val =val-this.amount;
      alert("The Interest Payable is Rs."+Math.floor(val) );
    }
    
  }
  

}

export class Car
{
    color:Colour;
}
export class Colour
{
    constructor(id:number, name:string) {
        this.id=id;
        this.name=name;
    }

    id:number;
    name:string;
}
