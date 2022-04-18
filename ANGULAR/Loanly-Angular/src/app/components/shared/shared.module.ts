import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BreadcrumbModule } from 'angular-crumbs';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SlickCarouselModule } from 'ngx-slick-carousel';


import { AdvertisementComponent } from './advertisement/advertisement.component';
import { BlogsidebarComponent } from './blogsidebar/blogsidebar.component';
import { BookappointmentComponent } from './bookappointment/bookappointment.component';
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { ServicesidebarComponent } from './servicesidebar/servicesidebar.component';



@NgModule({
  declarations: [AdvertisementComponent, BlogsidebarComponent, BookappointmentComponent, BreadcrumbComponent, FooterComponent, HeaderComponent, ServicesidebarComponent],
  imports: [
    CommonModule,
    RouterModule,
    NgbModule,
    SlickCarouselModule,
    BreadcrumbModule
  ],
  exports: [AdvertisementComponent, BlogsidebarComponent, BookappointmentComponent, BreadcrumbComponent, FooterComponent, HeaderComponent, ServicesidebarComponent]
})
export class SharedModule { }
