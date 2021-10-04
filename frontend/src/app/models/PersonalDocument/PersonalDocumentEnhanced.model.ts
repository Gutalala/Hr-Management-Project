export class PersonalDocumentEnhanced {
    firstname:string;
    lastname :string;
    email: string;
    id: number;
    employee_id: number;
    path: string;
    title: string;
    comment: string;
    createdDate: string;
    filename: string;

    constructor(
        firstname:string,
        lastname :string,
        email: string,
        id?: number,
        employee_id?: number,
        path?: string,
        title?: string,
        comment?: string,
        createdDate?: string,
        filename?: string
    ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
        this.employee_id = employee_id;
        this.path = path;
        this.title = title;
        this.comment = comment;
        this.createdDate = createdDate;
        this.filename = filename;
    }
}