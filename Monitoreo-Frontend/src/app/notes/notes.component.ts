import { Component, OnInit } from '@angular/core';
import {NotesService} from '../services/notes.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {

  data: any = [];

  constructor(private Notes: NotesService, private router: Router) { }


  ngOnInit() {
    this.Notes.getNotes().subscribe(res => {
      this.data = JSON.parse(res['_body']);
      console.log(res);
    }, error1 => {
      console.log(error1);
      this.router.navigate(['login']);
    });
  }

}
