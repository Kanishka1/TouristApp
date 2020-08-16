import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlacelistComponent } from './placelist/placelist.component';
import { HttpClientModule } from '@angular/common/http';
import { TouristPlaceService } from './services/touristplace.service';
import { AboutComponent } from './about/about.component';
import { PlacedetailsComponent } from './placedetails/placedetails.component';
import { PlacenotfoundComponent } from './placenotfound/placenotfound.component';
import { AddplaceComponent } from './addplace/addplace.component';
import { PlacebycityComponent } from './placebycity/placebycity.component';
import { PlacebystateComponent } from './placebystate/placebystate.component';
import { DeleteplaceComponent } from './deleteplace/deleteplace.component';
@NgModule({
  declarations: [
    AppComponent,
    PlacelistComponent,
    AboutComponent,
    PlacedetailsComponent,
    PlacenotfoundComponent,
    AddplaceComponent,
    PlacebycityComponent,
    PlacebystateComponent,
    DeleteplaceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TouristPlaceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
