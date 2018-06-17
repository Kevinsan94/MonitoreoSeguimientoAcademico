import { Component, OnInit } from '@angular/core';
import {NotesService} from '../services/notes.service';

@Component({
  selector: 'app-insert-notes',
  templateUrl: './insert-notes.component.html',
  styleUrls: ['./insert-notes.component.css']
})
export class InsertNotesComponent implements OnInit {

  Message;
  errMessage;

  constructor(private Notes: NotesService) { }

  ngOnInit() {
    this.Message = '';
    this.errMessage = '';
  }

  insertGrades(event) {
    event.preventDefault();
    this.Message = '';
    this.errMessage = '';
    const target = event.target;
    const code = target.querySelector('#code').value;
    const subject = target.querySelector('#subject').value;
    const p1 = target.querySelector('#p1').value;
    const p2 = target.querySelector('#p2').value;
    const p3 = target.querySelector('#p3').value;
    const newGrades = {
      student_id: code,
      materia: subject,
      p1: p1,
      p2: p2,
      p3: p3
    };
    this.Notes.insertNotes(newGrades).subscribe(data => {
      if (data.text() === 'Correctly inserted') {
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
