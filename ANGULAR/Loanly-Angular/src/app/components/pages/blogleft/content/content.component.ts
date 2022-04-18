import { Component, OnInit } from '@angular/core';
import blogbox from '../../../../data/blog.json';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  // pagination
  page: number = 1;
  constructor() { }
  public blogbox: { id: number }[] = blogbox;

  ngOnInit(): void {
  }

}
