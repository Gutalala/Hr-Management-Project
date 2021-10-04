export class FacilityReport {
    constructor(
        public id?: number,
        public title?: string,
        public employee_id?: number,
        public reportDate?: string,
        public description?: string,
        public status?: string
    ){}
}
