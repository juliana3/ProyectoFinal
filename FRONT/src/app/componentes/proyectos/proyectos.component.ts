import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.scss']
})
export class ProyectosComponent implements OnInit {
  proye: Proyecto[] = [];

  constructor(private pService: ProyectoService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarProyecto();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarProyecto(): void{
    this.pService.lista().subscribe(
      data => {this.proye = data;}
    )
  }

  delete(id?: number){
    if(id != undefined){
      this.pService.delete(id).subscribe(
        data=> {
          this.cargarProyecto();
        }, err=>{
          alert("No se pudo borrar el proyecto");
        }
      )
    }
  }

}
