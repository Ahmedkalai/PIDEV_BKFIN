import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';

import { BlogdetailRoutingModule } from './blogdetail-routing.module';
import { BlogdetailComponent } from './blogdetail.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [BlogdetailComponent, ContentComponent],
  imports: [
    CommonModule,
    NgbModule,
    HttpClientModule,
    BlogdetailRoutingModule,
    SharedModule
  ]
})
export class BlogdetailModule { }
