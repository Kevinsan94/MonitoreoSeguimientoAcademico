import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/internal/Observable';
import {Headers, Http, RequestMethod, RequestOptions} from '@angular/http';

@Injectable()
export class TeacherService {

  id;

  constructor(private http: Http) { }

  setId(id) {
    this.id = id;
    console.log(id);
  }

  getId() {
    return this.id;
  }

  getTeachers(): Observable<any> {
    const url = 'http://localhost:8080/backend/teacher/get/all';
    const headers = new Headers();
    headers.append('Accept', 'application/json; charset=utf-8');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Get,
      headers: headers,
      url: url
    });
    return this.http.get(url, requestOptions);
  }

  getTeacher(): Observable<any> {
    const url = 'http://localhost:8080/backend/teacher/get?id=' + this.id;
    const headers = new Headers();
    headers.append('Accept', 'application/json; charset=utf-8');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Get,
      headers: headers,
      url: url
    });
    return this.http.get(url, requestOptions);
  }

  createTeacher(newTeacher) {
    const inf = JSON.stringify(newTeacher);
    const url = 'http://localhost:8080/backend/teacher/create';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'text/plain');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Post,
      headers: headers,
      url: url,
      body: inf
    });
    console.log(newTeacher);
    return this.http.post(url, inf, requestOptions);
  }

  updateTeacher(newTeacher) {
    const inf = JSON.stringify(newTeacher);
    const url = 'http://localhost:8080/backend/teacher/update';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'text/plain');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Put,
      headers: headers,
      url: url,
      body: inf
    });
    console.log(newTeacher);
    return this.http.post(url, inf, requestOptions);
  }

  deleteTeacher(code) {
    const inf = JSON.stringify(code);
    const url = 'http://localhost:8080/backend/teacher/delete';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'text/plain');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Delete,
      headers: headers,
      url: url,
      body: inf
    });
    console.log(code);
    return this.http.post(url, inf, requestOptions);
  }
}
