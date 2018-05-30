/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yosael.wscliente;

import com.yosael.model.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author edwingutierrez
 */

@Stateless
public class PersonaWSClient {
    
    private static final String URL_BASE = "http://localhost:8080/WSRestPersona/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private Invocation.Builder invocationBuilder;
    private Response response;
    
    public PersonaWSClient(){
        cliente = ClientBuilder.newClient();
        webTarget = cliente.target(URL_BASE).path("/personas");
    }
    
    public Persona buscarPersonaPorId(int id){

        Persona persona = new Persona();
        persona = webTarget.path("/"+id).request(MediaType.APPLICATION_XML).get(Persona.class);
        
        return persona;
    }
    
    
    public List<Persona> listarPersonas(){
        List<Persona> personas;
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class)
                .readEntity(new GenericType<List<Persona>>(){});
        
        
        return personas;
    }
    
    public int agregarPersona(Persona persona){
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(persona, MediaType.APPLICATION_XML));
        
        return response.getStatus();
    }
    
}
