/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JulianaAraujo.portfolio.Interface;

import com.JulianaAraujo.portfolio.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer 1 persona
    public List<Persona> getPersona();
    
    //guardar 1 obj de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar 1 obj buscando por id
    public void deletePersona(Long id);
    
    //buscar persona por id
    public Persona findPersona(Long id);
}
