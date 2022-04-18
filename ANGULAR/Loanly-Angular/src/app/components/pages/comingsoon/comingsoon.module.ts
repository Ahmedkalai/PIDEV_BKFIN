import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CountdownModule } from "ng2-countdown-timer";

import { ComingsoonRoutingModule } from './comingsoon-routing.module';
import { ComingsoonComponent } from './comingsoon.component';

import { SharedModule } from '../../shared/shared.module';

@NgModule({
  declarations: [ComingsoonComponent],
  imports: [
    CommonModule,
    ComingsoonRoutingModule,
    CountdownModule,
    SharedModule
  ]
})
export class ComingsoonModule { }
