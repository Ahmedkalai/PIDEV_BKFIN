import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxPaginationModule } from 'ngx-pagination';

import { ServiceRoutingModule } from './service-routing.module';
import { ServiceComponent } from './service.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [ServiceComponent, ContentComponent],
  imports: [
    CommonModule,
    ServiceRoutingModule,
    NgxPaginationModule,
    NgbModule,
    SharedModule
  ]
})
export class ServiceModule { }
