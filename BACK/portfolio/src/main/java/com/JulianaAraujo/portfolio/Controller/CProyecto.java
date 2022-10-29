/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianaAraujo.portfolio.Controller;

import com.JulianaAraujo.portfolio.Dto.dtoProyecto;
import com.JulianaAraujo.portfolio.Entity.Proyecto;
import com.JulianaAraujo.portfolio.Security.Controller.Mensaje;
import com.JulianaAraujo.portfolio.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Proyecto proye = sProyecto.getOne(id).get();
        
        return new ResponseEntity(proye, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproy){
        if(StringUtils.isBlank(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyecto.existsByNombre(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto proye = new Proyecto(dtoproy.getNombre(), 
                dtoproy.getDescripcion(), dtoproy.getLink()
        );
        sProyecto.save(proye);
        
        return new ResponseEntity(new Mensaje("Proyecto agregao"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproy){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("Ese ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sProyecto.existsByNombre(dtoproy.getNombre()) && 
                sProyecto.getByNombre(dtoproy.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya esiste"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproy.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proye = sProyecto.getOne(id).get();
        
        proye.setNombre(dtoproy.getNombre());
        proye.setDescripcion(dtoproy.getDescripcion());
        proye.setLink(dtoproy.getLink());
        
        sProyecto.save(proye);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
         if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
         sProyecto.delete(id);
         
         return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
}
