import { Component, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import { CartService } from 'src/app/services/cart.service';
import { MatDialog } from '@angular/material/dialog';
import { EditbookComponent } from '../editbook/editbook.component';
import { AddbookComponent } from '../addbook/addbook.component';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
export interface UserData {
  id: string;
  name: string;
  image: string;
  price: string;
  actions:string;
}


@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.scss']
})
export class AdminhomeComponent {
  displayedColumns: string[] = ['id', 'name', 'image', 'price','actions'];
  
  dataSource: MatTableDataSource<UserData>;

  private paginator!: MatPaginator;
  private sort!: MatSort;
  thumbnail: any;

  constructor(public cart:CartService,public dialog: MatDialog,public http:HttpClient,public sanitizer:DomSanitizer) {
    
    // Assign the data to the data source for the table to render
    this.getallbooks();
    this.dataSource = new MatTableDataSource(this.cart.results);
  }

  @ViewChild(MatSort) set matSort(ms: MatSort) {
    this.sort = ms;
    this.setDataSourceAttributes();
  }

  @ViewChild(MatPaginator) set matPaginator(mp: MatPaginator) {
    this.paginator = mp;
    this.setDataSourceAttributes();
  }
  edit(_row:any){
    this.cart.editbook=_row;
    const dialogRef = this.dialog.open(EditbookComponent);
    
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
  getallbooks(){
    let url="http://localhost:8080/users/getBooks";
    let req={
      "featuredBooks":true,
      "topBooks":false,
      "newBooks":false
    }
    this.http.post(url,req).subscribe((res:any)=>{
      
      this.cart.results=res.details;
      
      
    });
    

  }
  addbook(){
    const dialogRef = this.dialog.open(AddbookComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
  setDataSourceAttributes() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  managebooks:boolean=false;
  manage_books(){
    this.managebooks=true;
  }
  empty(){
    this.managebooks=false;
  }
}