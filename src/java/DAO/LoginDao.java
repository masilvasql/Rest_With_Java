package DAO;

import Beans.LoginBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marce
 */
public class LoginDao {
    
    Connection conn;  
    private PreparedStatement buscaRegistros;
    
    
    public LoginDao() throws SQLException{
        Conexao conexao = new Conexao();
        conn = conexao.getConexao();
        
        buscaRegistros = conn.prepareStatement("SELECT * FROM login WHERE login LIKE ?");
        
    }
    
    public ArrayList buscarRegistros (String login) throws SQLException{
        ArrayList registros = new ArrayList();
        buscaRegistros.setString(1, "%" + login + "%");
        ResultSet resultado = buscaRegistros.executeQuery();
        
        while(resultado.next()){
            LoginBeans lb = new LoginBeans();
            lb.setIdLogin(resultado.getInt(1));
            lb.setNomeUsuario(resultado.getString(2));
            lb.setLoginUsuario(resultado.getString(3));
            lb.setSenhaUsuario(resultado.getString(4));
            registros.add(lb);
        }
        
        return registros;
    }
      
}


