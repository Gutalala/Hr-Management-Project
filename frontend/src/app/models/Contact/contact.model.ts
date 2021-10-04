export class Contact {
    constructor(
        public id?: number,
        public firstName?: string,
        public lastName?: string,
        public middleName?: string,
        public cellphone?: string,
        public address?: string,
        public email?: string,
        public employee_id?: number,
        public relationship?: string,
        public title?: string,
        public reference?: boolean,
        public emergency?: boolean,
        public landlord?: boolean,
        public isReference?: boolean,
        public isEmergency?: boolean,
        public isLandlord?: boolean,
    ){}
}
