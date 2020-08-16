import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Touristplace } from '../touristplace';
import { TouristPlaceService } from '../services/touristplace.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-placelist',
  templateUrl: './placelist.component.html',
  styleUrls: ['./placelist.component.css']
})
export class PlacelistComponent implements OnInit {
places: Touristplace[];
tpid:string='';
  constructor(private touristplaceService: TouristPlaceService,private route:Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit() 
  {
    this.activatedRoute.paramMap.subscribe((param:ParamMap)=>
    {
      console.log(param);
      this.tpid=param.get("name");
      console.log(this.tpid);
    })
    this.touristplaceService.getPlaceList().subscribe(
      (data)=>{this.places=data;console.log(data)},
      (err)=>console.log(err),
      ()=>console.log("Done")
    );
  }
  OnSelect=(touristplace:Touristplace)=>
  {
    console.log(touristplace);
   this.route.navigate(["/touristplace",touristplace.name]);
  }
}
