import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { LoanRequest } from '../Models/LoanRequest';


@Injectable({
  providedIn: 'root'
})
export class GetLoanDataServiceService {

  constructor(
    private httpClient: HttpClient
  ) {
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
}
