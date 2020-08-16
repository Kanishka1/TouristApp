import { Component, OnInit } from '@angular/core';
import { Touristplace } from '../touristplace';
import { TouristPlaceService } from '../services/touristplace.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-placebystate',
  templateUrl: './placebystate.component.html',
  styleUrls: ['./placebystate.component.css']
})
export class PlacebystateComponent implements OnInit {
  cityList:Touristplace[];
  constructor(private tpService:TouristPlaceService) { }

  ngOnInit() {
  }
  findPlace(name:string)
  {
    console.log(name);
    this.tpService.getPlaceByState(name).subscribe( (data)=>{console.log(data);this.cityList=data;},
    (err)=>console.log(err),
    ()=>console.log("Done")) 
  }
}
