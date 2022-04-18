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
  // Homeloan
  homeloan = [
    {
      icon: "assets/images/homepage/icon1.png",
      title: "All Solution Immidiate.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon2.png",
      title: "Get Funds in Account.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon3.png",
      title: "Feel secure, start to finish.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
  ];
  // Carloan
  carloan = [
    {
      icon: "assets/images/homepage/icon3.png",
      title: "Feel secure, start to finish.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon2.png",
      title: "Get Funds in Account.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon1.png",
      title: "All Solution Immidiate.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
  ];
  // Businessloan
  businessloan = [
    {
      icon: "assets/images/homepage/icon2.png",
      title: "Get Funds in Account.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon1.png",
      title: "All Solution Immidiate.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon3.png",
      title: "Feel secure, start to finish.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
  ];
  // Propertyloan
  propertyloan = [
    {
      icon: "assets/images/homepage/icon3.png",
      title: "Feel secure, start to finish.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon1.png",
      title: "All Solution Immidiate.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon2.png",
      title: "Get Funds in Account.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
  ];
  // Educationloan
  educationloan = [
    {
      icon: "assets/images/homepage/icon2.png",
      title: "Get Funds in Account.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon1.png",
      title: "All Solution Immidiate.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon3.png",
      title: "Feel secure, start to finish.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
  ];
  // Personalloan
  personalloan = [
    {
      icon: "assets/images/homepage/icon3.png",
      title: "Feel secure, start to finish.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon2.png",
      title: "Get Funds in Account.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
    {
      icon: "assets/images/homepage/icon1.png",
      title: "All Solution Immidiate.",
      para: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    },
  ]

  ngOnInit(): void {
  }

}
