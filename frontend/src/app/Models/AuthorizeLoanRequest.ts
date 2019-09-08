export class AuthorizeLoanRequest{
    AuthorizerUsername:String;
    AuthorizeeUsername:String;

    constructor(init?:Partial<AuthorizeLoanRequest>){
        Object.assign(this,init)
    }
}