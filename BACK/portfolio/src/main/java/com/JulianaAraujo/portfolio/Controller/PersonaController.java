/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianaAraujo.portfolio.Controller;

import com.JulianaAraujo.portfolio.Dto.dtoPersona;
import com.JulianaAraujo.portfolio.Entity.Persona;
import com.JulianaAraujo.portfolio.Security.Controller.Mensaje;
import com.JulianaAraujo.portfolio.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
    @Autowired 
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Persona persona = personaService.getOne(id).get();
        
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return  new ResponseEntity(new Mensaje("Ese ID no existe"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }*/
    
   /*/ @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoper){
        if(StringUtils.isBlank(dtoper.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(personaService.existsByNombre(dtoper.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(
        dtoper.getNombre(),dtoper.getApellido(),
                dtoper.getDescripcion(), dtoper.getImg());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoper){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("Ese ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtoper.getNombre()) && 
                personaService.getByNombre(dtoper.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya esiste"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoper.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setDescripcion(dtoper.getDescripcion());
        persona.setImg(dtoper.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
