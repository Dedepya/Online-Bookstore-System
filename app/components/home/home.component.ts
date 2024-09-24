import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  images=[
    {
      imageSrc:'assets/BestSellers.png',
      imageAlt:'BestSeller'
    },
    
    {
      imageSrc:'assets/bookscomingsoon-110123-topbanner.jpg',
      imageAlt:'Comingsoon'
    },
    {
      imageSrc:'assets/Featured Collection- All Together Now Eng.jpg',
      imageAlt:'Featured books'
    },
   
   
    

  ]
}
