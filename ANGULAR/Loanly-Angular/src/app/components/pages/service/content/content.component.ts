import { Component, OnInit } from '@angular/core';
import serviceblock from '../../../../data/services.json';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  // pagination
  page: number = 1;
  constructor() { }
  public serviceblock: { id: number }[] = serviceblock;
  ngOnInit(): void {
  }

}
