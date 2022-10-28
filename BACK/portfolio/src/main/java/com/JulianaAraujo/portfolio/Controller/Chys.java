
package com.JulianaAraujo.portfolio.Controller;

import com.JulianaAraujo.portfolio.Dto.dtoHys;
import com.JulianaAraujo.portfolio.Entity.Hys;
import com.JulianaAraujo.portfolio.Security.Controller.Mensaje;
import com.JulianaAraujo.portfolio.Service.Shys;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class Chys {
    @Autowired
    Shys servicehys;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list(){
        List<Hys> list = servicehys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id){
        if(!servicehys.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        
        Hys hys = servicehys.getOne(id).get();
        
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!servicehys.existsById(id)){
            return  new ResponseEntity(new Mensaje("Ese ID no existe"), HttpStatus.NOT_FOUND);
        }
        servicehys.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys){
        if(StringUtils.isBlank(dtohys.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(servicehys.existsByNombre(dtohys.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Hys hys = new Hys(
        dtohys.getNombre(), dtohys.getPorcentaje());
        
        servicehys.save(hys);
        return new ResponseEntity(new Mensaje("Skill creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys){
        if(!servicehys.existsById(id)){
            return new ResponseEntity(new Mensaje("Ese ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(servicehys.existsByNombre(dtohys.getNombre()) && 
                servicehys.getByNombre(dtohys.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya esiste"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohys.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Hys hys = servicehys.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje(dtohys.getPorcentaje());
        
        servicehys.save(hys);
        
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}
