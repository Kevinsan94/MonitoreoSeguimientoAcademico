import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod} from '@angular/http';

@Injectable()
export class LoginService {

  constructor(private http: Http) {
  }

  getUserDetails(newUser) {
    const inf = JSON.stringify(newUser);
    const url = 'http://localhost:8080/backend/login';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'text/plain');
    const requestOptions = new RequestOptions({
      method: RequestMethod.Post,
      headers: headers,
      url: url,
      body: inf
    });
    console.log(newUser);
    return this.http.post(url, inf, requestOptions);
  }
}
