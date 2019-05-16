import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLeavereportCompComponent } from './add-leavereport-comp.component';

describe('AddLeavereportCompComponent', () => {
  let component: AddLeavereportCompComponent;
  let fixture: ComponentFixture<AddLeavereportCompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddLeavereportCompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLeavereportCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
