import { Contact } from "../Contact/contact.model";
import { Facility } from "../Facility/facility.model";

export class House {
    constructor(
        public id?: number,
        public contact = new Contact(),
        public address?: string,
        public numberOfPerson?: number,
        public facility = new Facility(),
    ){}
}
