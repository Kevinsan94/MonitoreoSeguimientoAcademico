import { Component, OnInit } from '@angular/core';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
errMessage = '';
  constructor(private Login: LoginService) { }

  ngOnInit() {
  }

  loginUser(event) {
    event.preventDefault();
    const target = event.target;
    const user = target.querySelector('#user').value;
    const pass = target.querySelector('#pass').value;
    const newUser = {
      username: user,
      password: pass
    };
    this.Login.getUserDetails(newUser).subscribe(data => {
      this.errMessage = data.text();
      console.log(data);
    });
  }

}
