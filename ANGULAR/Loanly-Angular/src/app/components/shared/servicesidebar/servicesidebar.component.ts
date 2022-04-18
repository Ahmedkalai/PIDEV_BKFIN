import { Component, OnInit } from '@angular/core';
import serviceblock from '../../../data/services.json';
import blogbox from '../../../data/blog.json';

@Component({
  selector: 'app-servicesidebar',
  templateUrl: './servicesidebar.component.html',
  styleUrls: ['./servicesidebar.component.css']
})
export class ServicesidebarComponent implements OnInit {

  constructor() { }
  public blogbox: { id: number }[] = blogbox;
  public serviceblock: { id: number }[] = serviceblock;

  ngOnInit(): void {
  }

}
