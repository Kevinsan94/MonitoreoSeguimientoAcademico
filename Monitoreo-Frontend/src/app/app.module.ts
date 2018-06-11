import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import {LoginService} from './services/login.service';
import {HttpModule} from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
