import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { PlacelistComponent } from './placelist/placelist.component';
import { PlacedetailsComponent } from './placedetails/placedetails.component';
import { PlacenotfoundComponent } from './placenotfound/placenotfound.component';
import { AddplaceComponent } from './addplace/addplace.component';
import { PlacebycityComponent } from './placebycity/placebycity.component';
import { PlacebystateComponent } from './placebystate/placebystate.component';
import { DeleteplaceComponent } from './deleteplace/deleteplace.component';

const routes: Routes = [ 
{path:'',component:AboutComponent},
{path:'about',component:AboutComponent},
{path:'touristplace',component:PlacelistComponent},
{path:'addtouristplace',component:AddplaceComponent},
{path:'touristplace/:name',component:PlacedetailsComponent},
{path:'city',component:PlacebycityComponent},
{path:'state',component:PlacebystateComponent},
{path:'delete',component:DeleteplaceComponent},
{path:'**',component:PlacenotfoundComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
