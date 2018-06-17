import { Injectable } from '@angular/core';
import {Headers, Http, RequestMethod, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/internal/Observable';

@Injectable()
export class NotesService {

  id;

  constructor(private http: Http) { }

  setId(id) {
    this.id = id;
    console.log(id);
  }

  getNotes(): Observable<any> {
    const url = 'http://localhost:8080/backend/notas/get?id=' + this.id;
    const headers = new Headers();
    headers.append('Accept', 'application/json; charset=utf-8');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Get,
      headers: headers,
      url: url
    });
    return this.http.get(url, requestOptions);
  }

  insertNotes(newGrades) {
    const inf = JSON.stringify(newGrades);
    const url = 'http://localhost:8080/backend/notas/insert';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'text/plain');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Post,
      headers: headers,
      url: url,
      body: inf
    });
    console.log(newGrades);
    return this.http.post(url, inf, requestOptions);
  }
}
