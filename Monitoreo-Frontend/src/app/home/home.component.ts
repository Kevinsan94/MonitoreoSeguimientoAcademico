import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';
import {Observable} from 'rxjs';
import {TeacherService} from '../services/teacher.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  data: Observable<Array<any>>;
  data1: Observable<Array<any>>;

  constructor(private Student: StudentService, private Teacher: TeacherService) { }

  ngOnInit() {
    this.Student.getStudents().subscribe( res => {
      this.data = JSON.parse(res['_body']);
      console.log(this.data);
    });
    this.Teacher.getTeachers().subscribe(res => {
      this.data1 = JSON.parse(res['_body']);
      console.log(this.data1);
    });
  }

}
