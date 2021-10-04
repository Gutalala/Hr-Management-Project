export class ReferenceModel{

    public referenceFirstName: String;
    public referenceLastName: String;
    public referencePhone: String;
 
    public referenceRelationship: String;

    constructor (referenceFirstName: String,  referenceLastName: String , referencePhone: String , referenceRelationship: String){

        this.referenceFirstName = referenceFirstName;
        this.referenceLastName = referenceLastName;
        this.referencePhone = referencePhone;
        this.referenceRelationship = referenceRelationship;
    }

}