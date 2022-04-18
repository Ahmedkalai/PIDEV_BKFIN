import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  constructor() { }
  contactinfo = [
    {
      icon: "fas fa-phone-alt",
      title: "Phone",
      text: "Start working with LOANLY that can provide everything",
      info: "+(347)123 456 7890",
    },
    {
      icon: "far fa-envelope",
      title: "Email",
      text: "Start working with LOANLY that can provide everything",
      info: "contact@example.com",
    },
    {
      icon: "fas fa-map-marker-alt",
      title: "Location",
      text: "Start working with LOANLY that can provide everything",
      info: "View on Google map",
    },
  ]

  ngOnInit(): void {
  }

}
