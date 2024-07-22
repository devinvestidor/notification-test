import { Component, OnInit, ViewChild } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { LogService } from 'app/shared/api/log.service';
import { Log } from 'app/shared/models/log';
import { ResponseApp } from 'app/shared/models/response';
import { map, OperatorFunction } from 'rxjs';

@Component({
  selector: 'app-log',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatFormFieldModule, MatInputModule],
  templateUrl: './log.component.html',
  styleUrl: './log.component.scss'
})
export class LogComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  displayedColumns: string[] = ['sent', 'user', 'category', 'channel', 'status'];  
  dataSource = new MatTableDataSource<Log>();

  constructor(private logService: LogService) {}

  ngOnInit(): void {
    this.logService.listAll().pipe(this.formatLogResponse()).subscribe(res => {      
      this.dataSource.data = res;
      this.dataSource.paginator = this.paginator;
    })   
  }

  private formatLogResponse(): OperatorFunction<ResponseApp<Log[]>, Log[]> {
    return map((res: ResponseApp<Log[]>) => {
      if (res && res.body) return res.body.map((log: Log) => new Log(log));        
      else return [];      
    });
  }


  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}