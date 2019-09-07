/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Beans.NomeBeans;
import RegraDeNegocio.RnNome;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author marce
 */
@Path("Usuarios")
public class wsRest01 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsRest01
     */
    public wsRest01() {
    }

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "meu primeiro ws";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuarios/get")
    public String getNomes(){
        RnNome rn = new RnNome();
        NomeBeans n = new NomeBeans();
        
        n.setNomeUsuario("Marcelo");
        n.setEmailUsuario("marcelo-solo@123456.com");
        Gson gson = new Gson();
        String json = gson.toJson(n); 

        return json;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuarios/list")
    public String listNomes(){
        List<NomeBeans> lista = new ArrayList<NomeBeans>();
        NomeBeans n = new NomeBeans();
        
        n.setNomeUsuario("Marcelo");
        n.setEmailUsuario("marcelo-solo@123456.com");
        
        lista.add(n);
        
        n = new NomeBeans();
        
        n.setNomeUsuario("teste");
        n.setEmailUsuario("teste-solo@123456.com");
        
        lista.add(n);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(lista); 

        return json;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuarios/getUsuario/{nome}")
    public String getUsuario( @PathParam("nome") String nome){
        RnNome rn = new RnNome();
        NomeBeans n = new NomeBeans();
        ArrayList listaNomes = rn.buscaNomes(nome);
        Gson g = new Gson();
  
        return g.toJson(listaNomes);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuarios/getUsuarios")
    public String getUsuarios(){
        RnNome rn = new RnNome();
        ArrayList list = rn.buscaNomes("");
        Gson g = new Gson();
        
        return g.toJson(list);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
