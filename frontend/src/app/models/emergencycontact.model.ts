export class EmergencyContact {


    public emergencyfirstName: String;
    public emergencyLastName: String;
    public emergencyPhone: String;
 
    public emergencyRelationship: String;

    constructor (emergencyfirstName: String, emergencyLastName: String, emergencyPhone: String, emergencyRelationship: String){

        this.emergencyfirstName = emergencyfirstName;
        this.emergencyLastName = emergencyLastName;
        this.emergencyPhone = emergencyPhone;
        this.emergencyRelationship = emergencyRelationship;

    }

}