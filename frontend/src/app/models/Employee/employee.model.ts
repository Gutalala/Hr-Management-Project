import { Address } from "../Address/address.model";
import { Contact } from "../Contact/contact.model";
import { VisaStatus } from "../VisaStatus/visa-status.model";
import { PersonalDocument } from "../PersonalDocument/personal-document";

export class Employee {
    constructor(
      public id?: number,
      public user_id?: number,
      public firstName?: string,
      public lastName?: string,
      public middleName?: string,
      public preferredName?: string,
      public email?: string,
      public cellphone?: string,
      public alternatePhone?: string,
      public gender?: string,
      public ssn?: string,
      public dob?: string,
      public title?: string,
      public manager_id?: number,
      public startDate?: string,
      public endDate?: string,
      public avatar?: string,
      public car?: string,
      public driverLicense?: string,
      public driverLicense_expirationDate?: string,
      public house_id =1,
      public contact?: Contact[],
      public personalDocuments?: PersonalDocument[],
      public visaStatus = new VisaStatus(),
      public address = new Address()
    ){}
  }
  