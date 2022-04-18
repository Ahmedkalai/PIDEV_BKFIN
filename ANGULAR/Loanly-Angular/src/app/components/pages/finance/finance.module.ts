import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgWizardModule, NgWizardConfig, THEME } from 'ng-wizard';

const ngWizardConfig: NgWizardConfig = {
  theme: THEME.default
};

import { FinanceRoutingModule } from './finance-routing.module';
import { FinanceComponent } from './finance.component';

import { SharedModule } from '../../shared/shared.module';
import { ContentComponent } from './content/content.component';

@NgModule({
  declarations: [FinanceComponent, ContentComponent],
  imports: [
    CommonModule,
    NgbModule,
    NgWizardModule.forRoot(ngWizardConfig),
    FinanceRoutingModule,
    SharedModule
  ]
})
export class FinanceModule { }
