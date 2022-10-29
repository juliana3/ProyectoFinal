import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImageService } from 'src/app/service/image.service';
import { ProyectoService } from 'src/app/service/proyecto.service';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.scss']
})
export class EditProyectoComponent implements OnInit {
  proye : Proyecto = null;
  constructor(private pService: ProyectoService, private activatedRouter: ActivatedRoute,
     private router: Router, public imageService: ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.pService.detail(id).subscribe(
      data=> {
        this.proye = data;
      }, err=>{
        alert("Error al modificar proyecto");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.pService.update(id, this.proye).subscribe(
      data=> {
        this.router.navigate(['']);
      }, err =>{
        alert("Error al modificar proyecto");
        this.router.navigate(['']);
      }
    )
  }

 

}
