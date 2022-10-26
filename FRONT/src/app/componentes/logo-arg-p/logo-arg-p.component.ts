import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logo-arg-p',
  templateUrl: './logo-arg-p.component.html',
  styleUrls: ['./logo-arg-p.component.scss']
})
export class LogoArgPComponent implements OnInit {

  constructor(private router:Router) {}

  ngOnInit(): void {
  }

  login(){
    this.router.navigate(['/login'])
  }

}
