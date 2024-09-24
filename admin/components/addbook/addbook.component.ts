import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.scss']
})
export class AddbookComponent {
  AddBookForm = new FormGroup({
    bookTitle: new FormControl(''),
    authorname: new FormControl(''),
    price: new FormControl(''),
    coverpage:new FormControl(''),
    description:new FormControl('')
  });
  
}
