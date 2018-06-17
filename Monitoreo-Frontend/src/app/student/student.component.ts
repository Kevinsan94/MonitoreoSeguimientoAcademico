import { Component, OnInit } from '@angular/core';
import {StudentService} from '../services/student.service';
import {NotesService} from '../services/notes.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  code;
  data: any = [];


  constructor(private Student: StudentService, private Notes: NotesService, private router: Router) { }

  ngOnInit() {
    this.Notes.setId(this.Student.getId());
    this.code = this.Student.getId();
    this.Student.getStudent().subscribe(res => {
      this.data = JSON.parse(res['_body']);
      console.log(res);
    }, error1 => {
      console.log(error1);
      this.router.navigate(['login']);
    });
  }

}
