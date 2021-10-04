import { EmergencyContact } from "./emergencycontact.model";
import { ReferenceModel } from "./referencemodel.model";


export class applicationDetails{

    public firstName: String;
    public lastName: String;
    public middleName: String;
    public preferredName: String;
    public avatarName: String;

    public addressLine1: String;
    public addressLine2: String;
    public city: String;
    public state: String;
    public zipcode: Number;

    public car: String;
    public email: String;
    public ssn: String;
    public dob: String;
    public gender: String;

    public visa: String;
    public driverlicense: String;
    public reference: ReferenceModel;

    public emergencycontacts : EmergencyContact[];



    constructor(firstName:any, lastName:any,middleName:any, preferredName:any, avatarName:any ,addressLine1:any,addressLine2:any,  city:any, state:any, zipcode:any,
        car:any, email:any, ssn:any,dob:any,gender:any,visa:any,driverlicense:any, reference: ReferenceModel ,  emergencycontacts: EmergencyContact[]){

            this.firstName =firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.preferredName = preferredName;
            this.avatarName = avatarName;
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.state = state;
            this.zipcode = zipcode;
            this.car = car;
            this.email = email;
            this.ssn = ssn;
            this.dob = dob;
            this.gender = gender;
            this.visa = visa;
            this.driverlicense = driverlicense;
            this.reference = reference;
            this.emergencycontacts = this.emergencycontacts;

    }

}