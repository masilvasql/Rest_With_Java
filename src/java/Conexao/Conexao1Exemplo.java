/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class Conexao1Exemplo {
    
    private Connection conexao;
    
    public  Conexao1Exemplo(){
        try{
            String url ="jdbc:postgresql://localhost:5432/Java01";
            String usuario = "postgres";
            String senha = "suasenha";

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