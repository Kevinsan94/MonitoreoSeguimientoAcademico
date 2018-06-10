import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import {RequestMethod, RequestOptions} from '@angular/http';

@Injectable
export class LoginService {

  constructor(private http: HttpClient) {}

}
