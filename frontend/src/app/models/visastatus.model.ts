import { VisaDocument } from "./visadocument.model";



export class VisaStatus {

        public employeeId:Number;
        public firstname : String;
        public lastname:String;
        public visaType:String;
        public startDate: String;
        public endDate:String;
        public dayLeft:Number;
        public actionRequired:String;
    
        public visaStatus:String;

        public visaDocuments: VisaDocument[];

        constructor(   employeeId:Number, firstname : String,lastname:String,visaType:String,visaStatus:String, startDate: String,endDate:String,dayLeft:Number,actionRequired:String,visaDocuments: VisaDocument[]){
            this.employeeId = employeeId
            this.firstname = firstname;
            this.lastname = lastname;
            this.visaType = visaType;
            this.visaStatus = visaStatus;
            this.startDate = startDate;
            this.endDate = endDate;
            this.dayLeft = dayLeft;
            this.actionRequired = actionRequired;
            this.visaDocuments = visaDocuments;
        }




}4