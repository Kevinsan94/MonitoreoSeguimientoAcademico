import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  loginUser(event) {
    event.preventDefault();
    const target = event.target
    const username = target.getElementById('user');
    const password = target.getElementById('pass');
    console.log(event);
  }

}
