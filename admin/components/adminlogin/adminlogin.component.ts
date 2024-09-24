import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.scss']
})
export class AdminloginComponent {
  AdminLoginForm = new FormGroup({
    userName: new FormControl('',Validators.required),
    password:new FormControl('',Validators.required)
  });
  constructor(public cart:CartService,private _router: Router,private http:HttpClient){

  }
  ngOnInit() {
    this.cart.isAdmin=true;
  }
  submit(){
    let url ="http://localhost:8080/users/signin";
      let req={
        "userName": this.AdminLoginForm.controls.userName.value,
        "password": this.AdminLoginForm.controls.password.value
      }
      this.http.post(url,req).subscribe((res:any)=>{
        this.cart.token=res.token;
        
        if(res.roles=="ADMIN"){
          this._router.navigate(['admin/home']);
        }
        
      });
    
  }
}
