import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './componentes/home/home.component';
import { LoginComponent } from './componentes/login/login.component';
import { NewExperienciaComponent } from './componentes/experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './componentes/experiencia/edit-experiencia.component';
import { NewEducacionComponent } from './componentes/estudios/new-educacion.component';
import { EditEducacionComponent } from './componentes/estudios/edit-educacion/edit-educacion.component';
import { NewHysComponent } from './componentes/habilidades/new-hys/new-hys.component';
import { EditHysComponent } from './componentes/habilidades/edit-hys/edit-hys.component';
import { EditAcercaDeComponent } from './componentes/acerca-de/edit-acerca-de/edit-acerca-de.component';
import { EditProyectoComponent } from './componentes/proyectos/edit-proyecto/edit-proyecto.component';
import { NewProyectoComponent } from './componentes/proyectos/new-proyecto/new-proyecto.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexp', component: NewExperienciaComponent},
  {path:'editexp/:id', component: EditExperienciaComponent},
  {path:'nuevaedu', component: NewEducacionComponent},
  {path:'editedu/:id', component: EditEducacionComponent},
  {path:'nuevahab', component: NewHysComponent},
  {path:'edithab/:id', component: EditHysComponent},
  {path:'editacercade/:id', component: EditAcercaDeComponent},
  {path:'nuevoproy', component: NewProyectoComponent},
  {path:'editproy/:id', component: EditProyectoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
