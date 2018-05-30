/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yosael.controller;

import com.yosael.model.Persona;
import com.yosael.wscliente.PersonaWSClient;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author edwingutierrez
 */

@ManagedBean
@SessionScoped
public class PersonaController {
    
    List<Persona> personas;
    
    @EJB
    PersonaWSClient personaCli;
    
    
    @PostConstruct
    public void init(){
        personas = personaCli.listarPersonas();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    
    
    
}
