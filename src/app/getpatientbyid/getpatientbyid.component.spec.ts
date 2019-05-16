import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetpatientbyidComponent } from './getpatientbyid.component';

describe('GetpatientbyidComponent', () => {
  let component: GetpatientbyidComponent;
  let fixture: ComponentFixture<GetpatientbyidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetpatientbyidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetpatientbyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
