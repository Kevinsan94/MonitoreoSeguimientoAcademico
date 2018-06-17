import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertNotesComponent } from './insert-notes.component';

describe('InsertNotesComponent', () => {
  let component: InsertNotesComponent;
  let fixture: ComponentFixture<InsertNotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertNotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
