import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ChartsModule } from 'ng2-charts';

import { UserdashboardRoutingModule } from './userdashboard-routing.module';
import { UserdashboardComponent } from './userdashboard.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [UserdashboardComponent, ContentComponent],
  imports: [
    CommonModule,
    NgbModule,
    ChartsModule,
    NgCircleProgressModule.forRoot({
      // set defaults here
    }),
    UserdashboardRoutingModule,
    SharedModule
  ]
})
export class UserdashboardModule { }
