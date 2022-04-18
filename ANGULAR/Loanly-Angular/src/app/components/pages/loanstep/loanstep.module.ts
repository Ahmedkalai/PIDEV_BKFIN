import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoanstepRoutingModule } from './loanstep-routing.module';
import { LoanstepComponent } from './loanstep.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [LoanstepComponent, ContentComponent],
  imports: [
    CommonModule,
    LoanstepRoutingModule,
    SharedModule
  ]
})
export class LoanstepModule { }
