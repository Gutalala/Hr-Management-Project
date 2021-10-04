import { ResponseStatus } from "./ResponseStatus.model";
import { User } from "./User.model";

export class UserResponse {
    
    status: ResponseStatus;
    user: User;

    constructor(status: ResponseStatus, user: User){
        this.status = status;
        this.user = user;
    }
}