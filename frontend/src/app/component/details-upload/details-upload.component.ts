import { Component, OnInit, Input } from '@angular/core';
import { FileUpload } from 'src/app/models/FileUpload/fileupload.model';

@Component({
  selector: 'app-details-upload',
  templateUrl: './details-upload.component.html',
  styleUrls: ['./details-upload.component.css']
})
export class DetailsUploadComponent implements OnInit {

  @Input() fileUpload: FileUpload;

  constructor() { }

  ngOnInit(): void {
  }

}
