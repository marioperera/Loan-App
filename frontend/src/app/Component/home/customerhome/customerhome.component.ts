import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetLoanDataServiceService } from 'src/app/Services/get-loan-data-service.service';
import { LoanRequest } from 'src/app/Models/LoanRequest';
import { FormGroup, FormControl, Validators} from '@angular/forms';

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
  formdata;

  car:Car = new Car();
  colours = Array<Colour>();
  constructor(private router: Router,private getloansService:GetLoanDataServiceService) { }

  ngOnInit() {
    this.formdata = new FormGroup({
      nic: new FormControl("", Validators.compose([
         Validators.required,
         Validators.pattern("[0-9]{9}[x|X|v|V]$")
      ])),
      amount: new FormControl("",Validators.compose([
        Validators.required,
        Validators.max(1000000),
        Validators.min(10000)
      ])),
      duration:new FormControl("",Validators.compose([
        Validators.required,
        Validators.maxLength(1),
        
      ])),
      firstname:new FormControl("",Validators.required),
      lastname:new FormControl("",Validators.required),
      address:new FormControl("",Validators.required),
      assettype:new FormControl("",Validators.required)

   });
  }

  toggleGetLoan(){
    if(this.getloanview){
      this.requestLoan =false;
      this.calculateLoan =false
      this.getloanview =false;
    }else{
      this.getloanview =true;
      this.calculateLoan =false
      this.getloanview =false;
    }
  }

  toggleRequestloan(){
    if(this.requestLoan){
      this.getloanview =false;
      this.calculateLoan =false
      this.requestLoan =false;
    }else{
      this.requestLoan =true;
      this.calculateLoan =false
      this.getloanview =false;
    }
  }

  togglecalculator(){
    if(this.calculateLoan){
      this.getloanview =false;
      this.calculateLoan =false
      this.requestLoan =false;
    }else{
      this.calculateLoan =true;
      this.requestLoan =false
      this.getloanview =false;
    }
  }
  getLoan(FormControl){
    console.log(FormControl);
    
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
