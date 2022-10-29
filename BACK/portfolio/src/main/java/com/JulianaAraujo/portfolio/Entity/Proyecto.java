
package com.JulianaAraujo.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min =1 , max= 50, message="No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min =1 , max= 200, message="No cumple con la longitud")
    private String descripcion;
    
    
    @NotNull
    private String link;
    

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String link) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
