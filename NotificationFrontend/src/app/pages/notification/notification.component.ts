import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [ReactiveFormsModule, MatFormFieldModule, MatSelectModule, MatInputModule, FormsModule, MatButtonModule, MatIconModule],
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.scss'
})
export class NotificationComponent {
  formNotification : FormGroup;
  categories = [
    {value: 'SPORTS', viewValue: 'Sports'},
    {value: 'FINANCE', viewValue: 'Finance'},
    {value: 'MOVIES ', viewValue: 'Movies'},
  ];

  constructor(private formBuilder: FormBuilder) {
    this.formNotification = this.formBuilder.group({
      category: [null, Validators.required],
      message: [null, Validators.required]
    });
  }


}
