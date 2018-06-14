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

}
