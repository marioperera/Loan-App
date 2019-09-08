import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { LoanRequest } from '../Models/LoanRequest';
import { load } from '@angular/core/src/render3';
import { AuthorizeLoanRequest } from '../Models/AuthorizeLoanRequest';


@Injectable({
  providedIn: 'root'
})
export class GetLoanDataServiceService {

  constructor(
    private httpClient: HttpClient
  ) {
  }
  getAllaccepted(){
    return this.httpClient.get('http://localhost:8080/getAllacceptedLoans').pipe(map(
      LoanInfo =>{
        console.log(LoanInfo);
        
        return LoanInfo;

      }
    ))
  }

  testAPI(){
    return this.httpClient.get('http://localhost:8080/hello').pipe(map(
      UserInfo =>{
        console.log(UserInfo);
        
        return UserInfo;

      }
    ))
  }

  getloandetails(){
    let u_name =sessionStorage.getItem('username');
    return this.httpClient.post<any>('http://localhost:8080/requestloan',{ u_name }).pipe(map(
      results =>{
        console.log(results);
        return results;
        
      }
    ))
  }

  requestLoan(loan:LoanRequest){
    console.log("request loan called");
    console.log(loan);
    
    
    return this.httpClient.post<LoanRequest>('http://localhost:8080/requestloan',loan).pipe(map(
      results =>{
        console.log(results);
        return results;
        
      }
    ))
  }

  getLoanstobeAccepted(){
    return this.httpClient.get<LoanRequest>('http://localhost:8080/LoanstobeAccepted');
  }

  AcceptRequest(Loan){
   console.log("accept request called");
   // console.log(admin,client);
    // const loanrequest =new AuthorizeLoanRequest();
    // loanrequest.AuthorizeeUsername =client;
    // loanrequest.AuthorizerUsername =admin;
    // console.log(loanrequest);
    
    
    return this.httpClient.post<AuthorizeLoanRequest>('http://localhost:8080/AuthorizeLoan',Loan).pipe(map(res=>{
      console.log(res);
      return res;
      
    }))
  }

  RejectRequest(Loan){
    console.log("reject request called");
    
    return this.httpClient.post<LoanRequest>('http://localhost:8080/Deleterequest',Loan).pipe(map(res =>{
      console.log(res);
      return res;
      
    }))

  }
}
