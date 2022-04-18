import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SlickCarouselModule } from 'ngx-slick-carousel';

import { AboutRoutingModule } from './about-routing.module';
import { AboutComponent } from './about.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';
 
@NgModule({
  declarations: [AboutComponent, ContentComponent],
  imports: [
    CommonModule,
    NgbModule,
    SlickCarouselModule,
    AboutRoutingModule,
    SharedModule
  ]
})
export class AboutModule { }
