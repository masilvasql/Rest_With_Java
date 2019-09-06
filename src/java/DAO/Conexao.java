/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class Conexao {
    
    private Connection conexao;
    
    public  Conexao(){
        try{
            String url ="jdbc:postgresql://localhost:5432/Java01";
            String usuario = "postgres";
            String senha = "marcelo'25";

            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o banco de dados");
        }
    }
    
     public Connection getConexao(){
        return conexao;
    } 
    
}