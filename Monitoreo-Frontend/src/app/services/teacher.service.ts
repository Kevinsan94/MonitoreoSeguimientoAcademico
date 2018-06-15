import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/internal/Observable';
import {Headers, Http, RequestMethod, RequestOptions} from '@angular/http';

@Injectable()
export class TeacherService {

  constructor(private http: Http) { }

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
}
