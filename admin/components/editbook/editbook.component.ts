import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-editbook',
  templateUrl: './editbook.component.html',
  styleUrls: ['./editbook.component.scss']
})
export class EditbookComponent {
  EditBookForm = new FormGroup({
    bookTitle: new FormControl(''),
    authorname: new FormControl(''),
    price: new FormControl(''),
    coverpage:new FormControl(''),
    description:new FormControl('')
  });
  constructor(public cart:CartService){
    console.log(this.cart.editbook);
    this.EditBookForm.controls.bookTitle.setValue(this.cart.editbook.name);
    this.EditBookForm.controls.authorname.setValue(this.cart.editbook.Author);
    this.EditBookForm.controls.price.setValue(this.cart.editbook.price);
    this.EditBookForm.controls.coverpage.setValue(this.cart.editbook.image);
    this.EditBookForm.controls.description.setValue(this.cart.editbook.Details);
  }
}
