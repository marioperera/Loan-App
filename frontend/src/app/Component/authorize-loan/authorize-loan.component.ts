import { Component, OnInit } from '@angular/core';
import { GetLoanDataServiceService } from 'src/app/Services/get-loan-data-service.service';
import { LoanRequest } from 'src/app/Models/LoanRequest';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-authorize-loan',
  templateUrl: './authorize-loan.component.html',
  styleUrls: ['./authorize-loan.component.css']
})
export class AuthorizeLoanComponent implements OnInit {

  public loan:LoanRequest;
  loans:LoanRequest[];

  constructor(private getloansService:GetLoanDataServiceService ) { }

  ngOnInit() {
  this.getloansService.getLoanstobeAccepted().subscribe(res =>{
    //console.log(res);
    this.addtoloans(res);
    

  })
  
    
  }

  addtoloans(res:any){
    this.loans =res;
    console.log(this.loans);
    
  }

  AcceptLoan(loan:LoanRequest){

    console.log(loan);
    this.getloansService.AcceptRequest(loan).subscribe(res=>{
      console.log(res);
      
    })
    
  }

  RejectLoan(loan:LoanRequest){

    console.log(loan);
    this.getloansService.RejectRequest(loan).subscribe(res =>{
      console.log(res);
      
    })
    
  }



}
