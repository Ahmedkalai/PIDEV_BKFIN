import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SlickCarouselModule } from 'ngx-slick-carousel';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [HomeComponent, ContentComponent],
  imports: [
    CommonModule,
    NgbModule,
    SlickCarouselModule,
    HomeRoutingModule,
    SharedModule
  ]
})
export class HomeModule { }
