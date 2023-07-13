import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResturantLoginComponent } from './resturant-login.component';

describe('ResturantLoginComponent', () => {
  let component: ResturantLoginComponent;
  let fixture: ComponentFixture<ResturantLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResturantLoginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResturantLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
