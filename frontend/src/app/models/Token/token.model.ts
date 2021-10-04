export class Token {
    constructor(
        public id?: number,
        public token?: string,
        public validDuration?: string,
        public email?: string,
        public createdBy?: string
    ){
    }
}
