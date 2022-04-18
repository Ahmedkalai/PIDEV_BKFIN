import { Component, OnInit } from '@angular/core';
import teamblock from '../../../../data/team.json';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  constructor() { }
  public teamblock: { id: number }[] = teamblock;

  ngOnInit(): void {
  }

}
