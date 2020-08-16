import { Component, OnInit } from '@angular/core';
import { TouristPlaceService } from '../services/touristplace.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Touristplace } from '../touristplace';

@Component({
  selector: 'app-placebycity',
  templateUrl: './placebycity.component.html',
  styleUrls: ['./placebycity.component.css']
})
export class PlacebycityComponent implements OnInit {
cityList:Touristplace[];
  constructor(private tpService:TouristPlaceService, private route:Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
  }
  findPlace(name:string)
  {
    console.log(name);
    this.tpService.getPlaceByCity(name).subscribe( (data)=>{console.log(data);this.cityList=data;},
    (err)=>console.log(err),
    ()=>console.log("Done")) 
  }
}
