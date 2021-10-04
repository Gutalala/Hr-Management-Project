export class Facility {
    constructor(
        public house_id?: number,
        public type?: string,
        public description?: string,
        public quantity?: number,
        public numOfBed?: number,
        public numOfMattress?: number,
        public numOfTable?: number,
        public numOfChair?: number
    ){}
}
