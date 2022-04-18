import { Component, OnInit } from '@angular/core';
import blogbox from '../../../data/blog.json';
import blogcategory from '../../../data/blogcategory.json';

@Component({
  selector: 'app-blogsidebar',
  templateUrl: './blogsidebar.component.html',
  styleUrls: ['./blogsidebar.component.css']
})
export class BlogsidebarComponent implements OnInit {

  constructor() { }
  public blogbox: { id: number }[] = blogbox;
  public blogcategory: { id: number }[] = blogcategory;

  ngOnInit(): void {
  }

}
