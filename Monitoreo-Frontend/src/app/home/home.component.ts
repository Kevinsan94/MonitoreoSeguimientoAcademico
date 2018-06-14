import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  data: Observable<Array<any>>;

  constructor(private Student: StudentService) { }

  ngOnInit() {
    this.Student.getStudents().subscribe( res => {
      this.data = JSON.parse(res['_body']);
      console.log(this.data);
    });
  }

}
