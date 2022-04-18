import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  constructor() { }
  // Increment decrement
  public counter: number = 50000
  increment() {
    this.counter += 1000;
  }
  decrement() {
    this.counter -= 1000;
  }

  ngOnInit(): void {
  }

}
