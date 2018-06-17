import { Component, OnInit } from '@angular/core';
import {TeacherService} from '../services/teacher.service';

@Component({
  selector: 'app-delete-teacher',
  templateUrl: './delete-teacher.component.html',
  styleUrls: ['./delete-teacher.component.css']
})
export class DeleteTeacherComponent implements OnInit {

  Message;
  errMessage;

  constructor(private Teacher: TeacherService) { }

  ngOnInit() {
    this.Message = '';
    this.errMessage = '';
  }

  deleteTeacher(event) {
    event.preventDefault();
    this.Message = '';
    this.errMessage = '';
    const target = event.target;
    const code1 = target.querySelector('#codigo1').value;
    const code2 = target.querySelector('#codigo2').value;
    const code = {
      username: code1
    };
    if (code1 === code2) {
      this.Teacher.deleteTeacher(code).subscribe(data => {
        if (data.text() === 'Correctly deleted') {
          this.Message = data.text();
        } else {
          this.Message = 'Error';
        }
      }, error1 => {
        console.log(error1);
        this.errMessage = 'Error';
      });
    } else {
      this.errMessage = 'Codes does not match';
    }
  }

}
