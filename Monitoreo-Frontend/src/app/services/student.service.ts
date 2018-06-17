import { Injectable } from '@angular/core';
import {Headers, Http, RequestMethod, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/internal/Observable';

@Injectable()
export class StudentService {

  id;

  constructor(private http: Http) { }

  setId(id) {
    this.id = id;
    console.log(id);
  }

  getId() {
    return this.id;
  }

  getStudents(): Observable<any> {
    const url = 'http://localhost:8080/backend/student/get/all';
    const headers = new Headers();
    headers.append('Accept', 'application/json; charset=utf-8');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Get,
      headers: headers,
      url: url
    });
    return this.http.get(url, requestOptions);
  }

  getStudent(): Observable<any> {
    const url = 'http://localhost:8080/backend/student/get?id=' + this.id;
    const headers = new Headers();
    headers.append('Accept', 'application/json; charset=utf-8');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Get,
      headers: headers,
      url: url
    });
    return this.http.get(url, requestOptions);
  }

  createStudent(newStudent) {
    const inf = JSON.stringify(newStudent);
    const url = 'http://localhost:8080/backend/student/create';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'text/plain');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Post,
      headers: headers,
      url: url,
      body: inf
    });
    console.log(newStudent);
    return this.http.post(url, inf, requestOptions);
  }

  updateStudent(newStudent) {
    const inf = JSON.stringify(newStudent);
    const url = 'http://localhost:8080/backend/student/update';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'text/plain');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Put,
      headers: headers,
      url: url,
      body: inf
    });
    console.log(newStudent);
    return this.http.post(url, inf, requestOptions);
  }

  deleteStudent(code) {
    const inf = JSON.stringify(code);
    const url = 'http://localhost:8080/backend/student/delete';
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
