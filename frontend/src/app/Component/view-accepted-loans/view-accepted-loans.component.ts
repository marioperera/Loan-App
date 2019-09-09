import { Component, OnInit } from '@angular/core';
import { GetLoanDataServiceService } from 'src/app/Services/get-loan-data-service.service';
import { FormGroup,FormBuilder, FormControl, Validators } from '@angular/forms';
import { AcceptedLoans } from 'src/app/Models/AcceptedLoans';

@Component({
  selector: 'app-view-accepted-loans',
  templateUrl: './view-accepted-loans.component.html',
  styleUrls: ['./view-accepted-loans.component.css']
})
export class ViewAcceptedLoansComponent implements OnInit {
  myForm: FormGroup;
  username = "";
  formBuilder:FormBuilder;

  constructor(private getloansService:GetLoanDataServiceService) { }

  loans:any [];
  backup_loans:AcceptedLoans [];
  filtered_loans:any [];
  u_namefilter:String;

  ngOnInit() {
    //filter form group
    this.myForm = new FormGroup({
      username: new FormControl('username', Validators.required)
    });
  
    this.getloansService.getAllaccepted().subscribe((res:any[]) =>{
      
      //console.log(res);
      // this.loans =this.transform(this.loans,res);\
      this.myForm.valueChanges.subscribe((data:String) =>{
        console.log("value changed ",data);
        // this.loans =this.transform(this.loans,data);
        res =this.transform(res,data);
        console.log(res);
        
        // this.filtere_loans(data);
      })
      this.updateLoans(res);
    })
  }
 

  transform(items: any[], filterQuery: any): any[] {
    if (!filterQuery) return this.backup_loans;
    return items.filter(item => item.username.toLowerCase().includes(filterQuery));
  }

  updateLoans(res){
    this.loans =res;
    this.backup_loans =this.loans;
    console.log(this.loans);
    
  }

}
