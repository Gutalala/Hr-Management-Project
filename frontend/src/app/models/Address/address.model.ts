export class Address {
    constructor(
        public id?: number,
        public employee_id?: number,
        public addressLine1?: string,
        public addressLine2?: string,
        public city?: string,
        public zipCode?: string,
        public stateName?: string,
        public stateAbbr?: string,
    ){};
}
