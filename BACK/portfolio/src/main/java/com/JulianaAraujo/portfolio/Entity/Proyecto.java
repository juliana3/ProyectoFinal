
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
    private String nombrePr;
    
    @NotNull
    @Size(min =1 , max= 200, message="No cumple con la longitud")
    private String descripcionPr;
    
    
    @NotNull
    @Size(min =1 , max= 200, message="No cumple con la longitud")
    private String linkPr;

    public Proyecto() {
    }

    public Proyecto(String nombrePr, String descripcionPr, String linkPr) {
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
        this.linkPr = linkPr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public String getDescripcionPr() {
        return descripcionPr;
    }

    public void setDescripcionPr(String descripcionPr) {
        this.descripcionPr = descripcionPr;
    }

    public String getLinkPr() {
        return linkPr;
    }

    public void setLinkPr(String linkPr) {
        this.linkPr = linkPr;
    }
}
