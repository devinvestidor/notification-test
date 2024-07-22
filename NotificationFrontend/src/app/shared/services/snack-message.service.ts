import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackMessageService {

  constructor(private snackBar: MatSnackBar) { }

  public info(msg: string): void {
    this.snackBar.open(msg, "Info", {panelClass: 'blue-snackbar'});
  }

  public success(msg: string): void {
    this.snackBar.open(msg, "Success", {panelClass: 'green-snackbar'});
  }

  public warn(msg: string): void {
    this.snackBar.open(msg, "Warn", {panelClass: ['orange-snackbar']});

  }

  public error(msg: string): void {
    this.snackBar.open(msg, "Error", {panelClass: 'red-snackbar'});
  }
}
