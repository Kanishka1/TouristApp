import { Component, OnInit } from '@angular/core';
import { TouristPlaceService } from '../services/touristplace.service';
import { Touristplace } from '../touristplace';

@Component({
  selector: 'app-deleteplace',
  templateUrl: './deleteplace.component.html',
  styleUrls: ['./deleteplace.component.css']
})
export class DeleteplaceComponent implements OnInit {
places:Touristplace[];
  constructor(private touristplaceService:TouristPlaceService) { }

  ngOnInit() {
    this.touristplaceService.getPlaceList().subscribe(
      (data)=>{this.places=data;console.log(data)},
      (err)=>console.log(err),
      ()=>console.log("Done")
    );
  }
  deletePlace(id: number) {
    this.touristplaceService.deletePlace(id)
      .subscribe(
        data => {
          console.log(data);
        },
        error => console.log(error));
  }

}
