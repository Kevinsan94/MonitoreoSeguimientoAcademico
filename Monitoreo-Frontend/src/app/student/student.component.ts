import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  code;
  data: any = [];


  constructor(private Student: StudentService) { }

  ngOnInit() {
    this.code = this.Student.getId();
    this.Student.getStudent().subscribe(res => {
      this.data = JSON.parse(res['_body']);
      console.log(res);
    });
  }

}
