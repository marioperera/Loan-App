import { Component, OnInit } from '@angular/core';
import { GetLoanDataServiceService } from 'src/app/Services/get-loan-data-service.service';

@Component({
  selector: 'app-view-accepted-loans',
  templateUrl: './view-accepted-loans.component.html',
  styleUrls: ['./view-accepted-loans.component.css']
})
export class ViewAcceptedLoansComponent implements OnInit {

  constructor(private getloansService:GetLoanDataServiceService) { }

  loans:any [];

  ngOnInit() {

    this.getloansService.getAllaccepted().subscribe(res =>{
      //console.log(res);
      this.updateLoans(res);
      
    })
  }
  updateLoans(res){
    this.loans =res;
    console.log(this.loans);
    
  }

}
