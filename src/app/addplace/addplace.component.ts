import { Component, OnInit } from '@angular/core';
import { Touristplace } from '../touristplace';
import { TouristPlaceService } from '../services/touristplace.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addplace',
  templateUrl: './addplace.component.html',
  styleUrls: ['./addplace.component.css']
})
export class AddplaceComponent implements OnInit {
  place: Touristplace = new Touristplace();
  submitted = false;
  constructor(private tpService:TouristPlaceService,private router:Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;
    this.tpService.createTouristPlace(this.place)
    .subscribe(data => console.log(data), error => console.log(error));
  this.place = new Touristplace();
  this.router.navigate(['/touristplace']);
  }
}
