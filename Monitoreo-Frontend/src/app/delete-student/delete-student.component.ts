import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.css']
})
export class DeleteStudentComponent implements OnInit {

  Message;
  errMessage;

  constructor(private Student: StudentService) { }

  ngOnInit() {
    this.Message = '';
    this.errMessage = '';
  }

  deleteStudent(event) {
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
      this.Student.deleteStudent(code).subscribe(data => {
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
