

export class application{

    public employeeId: Number;
    public status: String;
    public firstName:String;
    public lastName: String;
    public email: String;

    constructor(employeeId:any,status:any,firstName:any,lastName:any,email:any){

        this.employeeId = employeeId;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email =email;
    }
}