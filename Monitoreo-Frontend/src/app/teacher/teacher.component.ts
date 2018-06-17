import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';
import {TeacherService} from '../services/teacher.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {

  code;
  data: any = [];


  constructor(private Teacher: TeacherService, private router: Router) { }

  ngOnInit() {
    this.code = this.Teacher.getId();
    this.Teacher.getTeacher().subscribe(res => {
      this.data = JSON.parse(res['_body']);
      console.log(res);
    }, error1 => {
      console.log(error1);
      this.router.navigate(['login']);
    });
  }

}
