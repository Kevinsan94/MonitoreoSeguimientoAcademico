import { Component, OnInit } from '@angular/core';
import {TeacherService} from '../services/teacher.service';

@Component({
  selector: 'app-create-teacher',
  templateUrl: './create-teacher.component.html',
  styleUrls: ['./create-teacher.component.css']
})
export class CreateTeacherComponent implements OnInit {

  Message;
  errMessage;

  constructor(private Teacher: TeacherService) { }

  ngOnInit() {
    this.Message = '';
    this.errMessage = '';
  }

  createTeacher(event) {
    event.preventDefault();
    this.Message = '';
    this.errMessage = '';
    const target = event.target;
    const name = target.querySelector('#nombre').value;
    const lastname = target.querySelector('#apellido').value;
    const number = target.querySelector('#fono').value;
    const email = target.querySelector('#mail').value;
    const pass = target.querySelector('#pass').value;
    const newStudent = {
      name: name,
      last_name: lastname,
      number: number,
      email: email,
      password: pass
    };
    this.Teacher.createTeacher(newStudent).subscribe(data => {
      if (data.text() === 'Correctly created') {
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
