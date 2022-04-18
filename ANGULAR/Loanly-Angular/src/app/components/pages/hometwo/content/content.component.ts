import { Component, OnInit } from '@angular/core';
import banner from "../../../../data/banner.json";
import blogbox from '../../../../data/blog.json';
import intropost from '../../../../data/intro.json';
import processbox from '../../../../data/process.json'
import serviceblock from '../../../../data/services.json'
import teamblock from '../../../../data/team.json';
import testimonials from '../../../../data/testimonial.json';
import clients from '../../../../data/client.json';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  constructor() { }
  public banner: { id: number }[] = banner;
  public intropost: { id: number }[] = intropost;
  public serviceblock: { id: number }[] = serviceblock;
  public processbox: { id: number }[] = processbox;
  public teamblock: { id: number }[] = teamblock;
  public testimonials: { id: number }[] = testimonials;
  public clients: { id: number }[] = clients;
  public blogbox: { id: number }[] = blogbox;
  bannerConfig = {
    slidesToShow: 1,
    slidesToScroll: 1,
    dots: false,
    arrows: false,
    infinite: true,
    autoplay: true,
    speed: 400,
    focusOnSelect: true,
    cssEase: 'linear'
  }
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
  testimonialmainConfig = {
    infinite: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: false,
    draggable: false,
    dots: false,
    vertical: true,
    asNavFor: '.testimonial-nav'
  }
  testimonialnavConfig = {
    infinite: true,
    slidesToShow: 5,
    slidesToScroll: 1,
    arrows: false,
    dots: false,
    centerMode: true,
    centerPadding: '0px',
    focusOnSelect: true,
    asNavFor: '.testimonial-for',
    responsive: [{
      breakpoint: 576,
      settings: {
        slidesToShow: 3,
        arrows: false,
      }
    }]
  }
  blogConfig = {
    slidesToShow: 3,
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
          slidesToShow: 2,
        }
      }, {
        breakpoint: 768,
        settings: {
          arrows: false,
          dots: true,
          slidesToShow: 1,
        }
      }
    ]
  }
  // features
  features = [
    {
        icon: "flaticon-live-show",
        title: "Live Advisor",
        text: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.",
    },
    {
        icon: "flaticon-website",
        title: "Get Registration",
        text: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.",
    },
    {
        icon: "flaticon-customer-service",
        title: "Instant Support",
        text: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text.",
    },
]

  ngOnInit(): void {
  }

}
