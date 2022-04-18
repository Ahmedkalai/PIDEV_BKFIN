import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { SlickCarouselModule } from 'ngx-slick-carousel';

import { ServicedetailRoutingModule } from './servicedetail-routing.module';
import { ServicedetailComponent } from './servicedetail.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [ServicedetailComponent, ContentComponent],
  imports: [
    CommonModule,
    NgbModule,
    HttpClientModule,
    SlickCarouselModule,
    ServicedetailRoutingModule,
    SharedModule
  ]
})
export class ServicedetailModule { }
