export class PersonalDocument {
    id: number;
    employee_id: number;
    path: string;
    title: string;
    comment: string;
    createdDate: string;
    filename: string;
    imagesrc?: string;

    constructor(
        id?: number,
        employee_id?: number,
        path?: string,
        title?: string,
        comment?: string,
        createdDate?: string,
        filename?: string
    ) {
        this.id = id;
        this.employee_id = employee_id;
        this.path = path;
        this.title = title;
        this.comment = comment;
        this.createdDate = createdDate;
        this.filename = filename;
    }
}
