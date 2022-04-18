import { Component, AfterContentInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import serviceblock from '../../../../data/services.json';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements AfterContentInit {

  constructor(private router: ActivatedRoute) { }
  public servicedetails: { title: string, id: number }[] = serviceblock;

  public setPost(id: any) {
    this.servicedetails = serviceblock.filter((item: { id: any; }) => { return item.id == id });
  }
  settingsConfig = {
    slidesToShow: 1,
    slidesToScroll: 1,
    dots: false,
    arrows: false,
    infinite: true,
    autoplay: true,
    autoplaySpeed: 2000,
    speed: 400,
    focusOnSelect: true,
    cssEase: 'linear'
  }

  ngAfterContentInit(): void {
    this.setPost(this.router.snapshot.params.id);
  }

}
