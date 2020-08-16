import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { Touristplace } from '../touristplace';
import { TouristPlaceService } from '../services/touristplace.service';

@Component({
  selector: 'app-placedetails',
  templateUrl: './placedetails.component.html',
  styleUrls: ['./placedetails.component.css']
})
export class PlacedetailsComponent implements OnInit {
id:string='';
places:Touristplace[];
  constructor(private touristplaceService: TouristPlaceService,private activatedRoute:ActivatedRoute,private route:Router) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((param:ParamMap)=>
    {
      console.log(param);
      this.id=param.get("name");
      console.log(this.id);
    })
    this.touristplaceService.getPlaceByName(this.id).subscribe(
      (data)=>{this.places=data;console.log(data)},
      (err)=>console.log(err),
      ()=>console.log("Done")
    );
  }
  OnSelect(touristplace:Touristplace)
  {
    this.route.navigate(['/touristplace']);
  }

}
