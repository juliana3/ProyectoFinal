/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.JulianaAraujo.portfolio.Entity;

import javax.persistence.Entity;


@Entity
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private String img;
}
