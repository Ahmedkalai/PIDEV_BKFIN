import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ComingsoonComponent } from './comingsoon.component';

const routes: Routes = [{ path: '', component: ComingsoonComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ComingsoonRoutingModule { }
