import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoancalculatorRoutingModule } from './loancalculator-routing.module';
import { LoancalculatorComponent } from './loancalculator.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [LoancalculatorComponent, ContentComponent],
  imports: [
    CommonModule,
    LoancalculatorRoutingModule,
    SharedModule
  ]
})
export class LoancalculatorModule { }
