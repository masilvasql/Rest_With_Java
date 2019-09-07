/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Beans.NomeBeans;
import RegraDeNegocio.RnLogin;
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
@Path("Login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsRest01
     */
    public LoginResource() {
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Login/todos")
    public String getUsuarios(){
        RnLogin rl = new RnLogin();
        ArrayList list = rl.buscarRegistros("");
        Gson g = new Gson();
        
        return g.toJson(list);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Login/login/{login}")
    public String getUsuario(@PathParam("login") String login){
        RnLogin rl = new RnLogin();
        ArrayList list = rl.buscarRegistros(login);
        Gson g = new Gson();
        
        return g.toJson(list);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
