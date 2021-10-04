export class Facilityreportdetail {
    constructor(
        public id?: number,
        public facilityReport_id?: number,
        public employee_id?: number,
        public comments?: string,
        public createdDate?: string,
        public lastModificationDate?: string,
        public updateable?: boolean,
    ){
        this.updateable = false;
    }
}
