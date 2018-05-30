/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yosael.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwingutierrez
 */

@XmlRootElement
public class Persona {
    
    
    private int idPersona;
    private String nombres;
    private String apellidos;
    private Date fechaNac;
    private String sexo;
    private String direccion;
    private byte[] foto;
    
    
    
}
