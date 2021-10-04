
export class User {

    id: number;
    username: string;
    email: string;
    password: string;
    createDate: string;
    modificationDate: string;

    constructor(id: number, username: string, email: string, password: string, createDate: string, modificationDate: string){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.modificationDate = modificationDate;
    }
}