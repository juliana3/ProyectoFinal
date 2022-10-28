import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-edit-hys',
  templateUrl: './edit-hys.component.html',
  styleUrls: ['./edit-hys.component.scss']
})
export class EditHysComponent implements OnInit {
  skill: Skill = null;
  
  constructor(private skillS: SkillService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.skillS.detail(id).subscribe(
      data=> {
        this.skill = data;
      }, err =>{
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(){
    const id = this.activatedRoute.snapshot.params['id'];
    this.skillS.update(id, this.skill).subscribe(
      data=> {
        this.router.navigate(['']);
      }, err=> {
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

}
