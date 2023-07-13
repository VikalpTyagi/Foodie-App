import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCuisinesComponent } from './add-cuisines.component';

describe('AddCuisinesComponent', () => {
  let component: AddCuisinesComponent;
  let fixture: ComponentFixture<AddCuisinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCuisinesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCuisinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
