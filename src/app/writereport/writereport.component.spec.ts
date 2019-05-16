import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WritereportComponent } from './writereport.component';

describe('WritereportComponent', () => {
  let component: WritereportComponent;
  let fixture: ComponentFixture<WritereportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WritereportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WritereportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
