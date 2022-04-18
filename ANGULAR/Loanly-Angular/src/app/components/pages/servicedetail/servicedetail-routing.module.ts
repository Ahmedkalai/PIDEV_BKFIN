import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ServicedetailComponent } from './servicedetail.component';

const routes: Routes = [{ path: '', component: ServicedetailComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServicedetailRoutingModule { }
