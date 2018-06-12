import { Component, OnInit } from '@angular/core';
import {LoginService} from '../services/login.service';
import {Router} from '@angular/router';
import {StudentService} from '../services/student.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
errMessage = '';
  constructor(private Login: LoginService, private router: Router, private Student: StudentService) { }

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
      if (data.text() === 'Accepted') {
        this.errMessage = '';
        this.router.navigate(['student']);
        console.log(data.text());
        this.Student.setId(user);
      } else {
        this.errMessage = data.text();
      }
    });
  }

}
