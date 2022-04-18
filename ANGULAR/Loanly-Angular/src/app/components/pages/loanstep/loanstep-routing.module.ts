import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoanstepComponent } from './loanstep.component';

const routes: Routes = [{ path: '', component: LoanstepComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoanstepRoutingModule { }
