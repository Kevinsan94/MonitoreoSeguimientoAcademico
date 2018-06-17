import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {LoginService} from './services/login.service';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import {StudentService} from './services/student.service';
import {TeacherService} from './services/teacher.service';
import { CreateStudentComponent } from './create-student/create-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { DeleteStudentComponent } from './delete-student/delete-student.component';
import { CreateTeacherComponent } from './create-teacher/create-teacher.component';
import { UpdateTeacherComponent } from './update-teacher/update-teacher.component';
import { DeleteTeacherComponent } from './delete-teacher/delete-teacher.component';
import { FormsModule} from '@angular/forms';
import { TeacherComponent } from './teacher/teacher.component';
import {NotesService} from './services/notes.service';
import { InsertNotesComponent } from './insert-notes/insert-notes.component';
import { NotesComponent } from './notes/notes.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    StudentComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    DeleteStudentComponent,
    CreateTeacherComponent,
    UpdateTeacherComponent,
    DeleteTeacherComponent,
    TeacherComponent,
    InsertNotesComponent,
    NotesComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot([
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'student',
        component: StudentComponent
      },
      {
        path: 'teacher',
        component: TeacherComponent
      },
      {
        path: 'student/create',
        component: CreateStudentComponent
      },
      {
        path: 'teacher/create',
        component: CreateTeacherComponent
      },
      {
        path: 'student/update',
        component: UpdateStudentComponent
      },
      {
        path: 'teacher/update',
        component: UpdateTeacherComponent
      },
      {
        path: 'student/delete',
        component: DeleteStudentComponent
      },
      {
        path: 'teacher/delete',
        component: DeleteTeacherComponent
      },
      {
        path: 'notes',
        component: NotesComponent
      },
      {
        path: 'notes/insert',
        component: InsertNotesComponent
      }
    ])
  ],
  providers: [LoginService, StudentService, TeacherService, NotesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
