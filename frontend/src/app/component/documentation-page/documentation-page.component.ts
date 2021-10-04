import { Component, OnInit } from '@angular/core';
import { FileRetrieveService } from 'src/app/service/fileRetrieveService/file-retrieve.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-documentation-page',
  templateUrl: './documentation-page.component.html',
  styleUrls: ['./documentation-page.component.css']
})
export class DocumentationPageComponent implements OnInit {

  showFile = false;
  fileUploads: Observable<any>;

  ngOnInit(){
      this.fileUploads = this.fileRetrieveService.retrieveDocument();

  }

  constructor(private fileRetrieveService: FileRetrieveService) { }

  

//   showFiles(enable: boolean) {
//     this.showFile = enable;

//     if (enable) {
//       this.fileUploads = this.fileRetrieveService.retrieveDocument();
//     }
//   }
}
