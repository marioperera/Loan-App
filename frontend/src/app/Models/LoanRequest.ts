//this.username,this.firstname,this.lastname,this.nic,this.duration,this.assettype,"pending",this.rate,this.amount

export class LoanRequest{
    
    username:string;
    firstname:string;
    lastname:string;
    nic:string;
    duration:number;
    assettype:string;
    state:string;
    rate:string;
    amount:number;

    constructor(init?:Partial<LoanRequest>){
        Object.assign(this,init)
    }


}