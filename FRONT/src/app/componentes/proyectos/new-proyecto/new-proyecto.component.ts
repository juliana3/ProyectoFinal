import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.scss']
})
export class NewProyectoComponent implements OnInit {
  nombrePr: string = '';
  descripcionPr: string = '';
  linkPr: string ='';
  

  constructor(private pService: ProyectoService, private router: Router,
    private activatedRouter: ActivatedRoute,public imageService: ImageService ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const proye = new Proyecto(this.nombrePr, this.descripcionPr, this.linkPr);
    this.pService.save(proye).subscribe(
      data => {
        alert("Proyecto añadido");
        this.router.navigate(['']);
      }, err =>{
        alert("Fallo");
        this.router.navigate(['']);
      }
    )
  }
  

}
