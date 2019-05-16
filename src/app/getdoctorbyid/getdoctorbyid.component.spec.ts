import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetdoctorbyidComponent } from './getdoctorbyid.component';

describe('GetdoctorbyidComponent', () => {
  let component: GetdoctorbyidComponent;
  let fixture: ComponentFixture<GetdoctorbyidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetdoctorbyidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetdoctorbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
