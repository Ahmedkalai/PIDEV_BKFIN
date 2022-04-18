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
  // team
  teamConfig = {
    slidesToShow: 4,
    slidesToScroll: 1,
    dots: false,
    arrows: true,
    infinite: true,
    loop: true,
    autoplay: true,
    speed: 400,
    cssEase: 'linear',
    responsive: [
      {
        breakpoint: 992,
        settings: {
          arrows: true,
          slidesToShow: 3
        }
      }, {
        breakpoint: 768,
        settings: {
          arrows: false,
          dots: true,
          slidesToShow: 2
        }
      }, {
        breakpoint: 480,
        settings: {
          arrows: false,
          dots: true,
          slidesToShow: 1
        }
      }
    ]
  }
  ngOnInit(): void {
  }

}
