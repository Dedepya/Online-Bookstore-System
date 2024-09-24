import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookDetailsComponent } from 'src/shared/components/book-details/book-details.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserModule } from '@angular/platform-browser';

import { LoggedinuserComponent } from 'src/loggineduser/login/loggedinuser/loggedinuser.component';
import { CheckoutComponent } from 'src/loggineduser/checkout/checkout.component';
import { ManagecartComponent } from 'src/loggineduser/managecart/managecart.component';
import { OrderHistoryComponent } from 'src/loggineduser/order-history/order-history.component';
import { TrackOrderComponent } from 'src/loggineduser/track-order/track-order.component';
import { RegisteruserComponent } from 'src/loggineduser/registeruser/registeruser.component';
import { EditprofileComponent } from 'src/loggineduser/editprofile/editprofile.component';
import { AdminloginComponent } from 'src/admin/components/adminlogin/adminlogin.component';
import { AdminhomeComponent } from 'src/admin/components/adminhome/adminhome.component';

const routes: Routes = [
  {
    path: 'home', component: HomeComponent,
    // children: [
    //   {
    //     path: 'bookdetails', component: BookDetailsComponent
    //   }
    // ],
    
  },
  
  {path:'home/manageCart',component:ManagecartComponent},
  {path:'home/checkOut',component:CheckoutComponent},
  {path:'home/orderHistory',component:OrderHistoryComponent},
  {path:'home/TrackOrder',component:TrackOrderComponent},
  {path:'home/editProfile',component:EditprofileComponent},
  {path:'login',component:LoggedinuserComponent},
  {path:'register',component:RegisteruserComponent},
  {path:'admin/login',component:AdminloginComponent},
  {path:'admin/home',component:AdminhomeComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [BrowserModule,RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
