import { Component } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { CategoryService } from 'app/shared/api/category.service';
import { NotificationService } from 'app/shared/api/notification.service';
import { Category } from 'app/shared/models/category';

import { SnackMessageService } from 'app/shared/services/snack-message.service';

@Component({
  selector: 'app-notification',
  standalone: true,  
  imports: [ReactiveFormsModule, MatFormFieldModule, MatSelectModule, MatInputModule, FormsModule, MatButtonModule, MatIconModule],
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.scss'
})
export class NotificationComponent {
  formNotification =     this.formBuilder.group({
    category: [null, Validators.required],
    message: [null, Validators.required]
  });
  categories : Category[];

  constructor(private formBuilder: FormBuilder,
              private categoryService: CategoryService,
              private notificationService: NotificationService,
              private snackMessageService: SnackMessageService) {
    this.loadCategories();
  }  

  private loadCategories(): void {
    this.categoryService.listAll().subscribe(res => {      
      this.categories = res.body;
    })
  }

  public sendNotification(): void {
    if (this.formNotification.invalid) return this.snackMessageService.warn("Please fill in all required fields")
    
    this.notificationService.send(this.formNotification.value).subscribe(res=> {
      this.snackMessageService.info(res.message)
      this.formNotification.reset();
    });
  }
}
