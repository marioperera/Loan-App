export class AcceptedLoans{
    amount:String;
    id:number;
    data:String;
    manager:String;
    rate:String;
    refcode:String;
    username:String;

    constructor(init?:Partial<AcceptedLoans>){
        Object.assign(this,init)
    }
}