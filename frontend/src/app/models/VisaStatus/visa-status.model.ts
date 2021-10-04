export class VisaStatus {
    constructor(
        public id?: number,
        public employee_id?: number,
        public active?: boolean,
        public visaType?: string,
        public visaStartDate?: string,
        public visaEndDate?: string,
    ){}
}
