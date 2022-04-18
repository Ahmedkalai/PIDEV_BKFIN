import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BlogleftComponent } from './blogleft.component';

const routes: Routes = [{ path: '', component: BlogleftComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlogleftRoutingModule { }
