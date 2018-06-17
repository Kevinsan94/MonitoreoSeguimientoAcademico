import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';
import {TeacherService} from '../services/teacher.service';

@Component({
  selector: 'app-update-teacher',
  templateUrl: './update-teacher.component.html',
  styleUrls: ['./update-teacher.component.css']
})
export class UpdateTeacherComponent implements OnInit {

  Message;
  errMessage;

  constructor(private Teacher: TeacherService) { }

  ngOnInit() {
    this.Message = '';
    this.errMessage = '';
  }

  updateTeacher(event) {
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
    const newTeacher = {
      code: code,
      name: name,
      last_name: lastname,
      number: number,
      email: email,
      password: pass
    };
    this.Teacher.updateTeacher(newTeacher).subscribe(data => {
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
