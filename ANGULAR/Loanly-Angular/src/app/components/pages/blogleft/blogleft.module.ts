import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxPaginationModule } from 'ngx-pagination';

import { BlogleftRoutingModule } from './blogleft-routing.module';
import { BlogleftComponent } from './blogleft.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [BlogleftComponent, ContentComponent],
  imports: [
    CommonModule,
    BlogleftRoutingModule,
    NgxPaginationModule,
    NgbModule,
    SharedModule
  ]
})
export class BlogleftModule { }
