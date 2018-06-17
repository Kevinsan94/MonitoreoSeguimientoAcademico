import {Component, OnInit, ViewChild} from '@angular/core';
import {StudentService} from '../services/student.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})


export class CreateStudentComponent implements OnInit {

  Message;
  errMessage;
  constructor(private Student: StudentService) { }

  ngOnInit() {
    this.Message = '';
    this.errMessage = '';
  }

  createStudent(event) {
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
      lastname: lastname,
      number: number,
      email: email,
      password: pass
    };
    this.Student.createStudent(newStudent).subscribe(data => {
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
