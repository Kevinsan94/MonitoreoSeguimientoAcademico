import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Monitoreo y Seguimiento Academico';

  constructor(private router: Router) {
    router.navigate(['/login']);
  }
  ngOnInit(): void {}

}
