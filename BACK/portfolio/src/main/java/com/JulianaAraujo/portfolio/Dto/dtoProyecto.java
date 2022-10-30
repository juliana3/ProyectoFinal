/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JulianaAraujo.portfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
   private String nombrePr;
    
    @NotBlank
   private String descripcionPr;
    
    @NotBlank
    private String linkPr;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombrePr, String descripcionPr, String linkPr) {
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
        this.linkPr = linkPr;
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
