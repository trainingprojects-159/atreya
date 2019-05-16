import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPatientCompComponent } from './edit-patient-comp.component';

describe('EditPatientCompComponent', () => {
  let component: EditPatientCompComponent;
  let fixture: ComponentFixture<EditPatientCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditPatientCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPatientCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
