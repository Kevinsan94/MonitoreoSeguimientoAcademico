import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  Message;
  errMessage;

  constructor(private Student: StudentService) { }

  ngOnInit() {
    this.Message = '';
    this.errMessage = '';
  }

  updateStudent(event) {
    event.preventDefault();
    this.Message = '';
    this.errMessage = '';
    const target = event.target;
    const code = target.querySelector('#codigo').value;
    const name = target.querySelector('#nombre').value;
    const lastname = target.querySelector('#apellido').value;
    const number = target.querySelector('#fono').value;
    const email = target.querySelector('#mail').value;
    const pass = target.querySelector('#pass').value;
    const newStudent = {
      code: code,
      name: name,
      lastname: lastname,
      number: number,
      email: email,
      password: pass
    };
    this.Student.updateStudent(newStudent).subscribe(data => {
      if (data.text() === 'Correctly updated') {
        this.Message = data.text();
      } else {
        this.Message = 'Error';
      }
    }, error1 => {
      console.log(error1);
      this.errMessage = 'You must enter correct data';
    });
  }
}
