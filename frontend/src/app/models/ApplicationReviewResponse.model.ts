import { ResponseStatus } from "./ResponseStatus.model";
 

export class ApplicationReviewResponse {
    
    status: ResponseStatus;
    

    constructor(status: ResponseStatus ){
        this.status = status;
      
    }
}