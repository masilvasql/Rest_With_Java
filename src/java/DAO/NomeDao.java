package DAO;

import Beans.NomeBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marce
 */
public class NomeDao {
    
    Connection conn;
    
    private PreparedStatement incluirNome;
    private PreparedStatement buscarRegistros;
    private PreparedStatement deletarRegistro;
    private PreparedStatement atualizarRegistro;
    
    public NomeDao() throws SQLException{
        Conexao conexao = new Conexao();
        conn = conexao.getConexao();
        
        incluirNome = conn.prepareStatement("INSERT INTO nomeUsuario (nomeusuario) values (?)");
        buscarRegistros = conn.prepareStatement("SELECT * FROM nomeUsuario WHERE nomeusuario LIKE ? ");
        deletarRegistro = conn.prepareStatement("DELETE FROM nomeUsuario WHERE idnome = ?");
        atualizarRegistro = conn.prepareStatement("UPDATE nomeUsuario SET nomeusuario = (?) WHERE idnome = ?");
    }
    
     public int cadastrarNome (NomeBeans nb ) throws SQLException{
        int resultado;
        incluirNome.setString(1,nb.getNomeUsuario());
        resultado = incluirNome.executeUpdate();
        return resultado;
    }
     
    public int deletarNome(int id) throws SQLException{
        int resultado;
        deletarRegistro.setInt(1, id);
        resultado = deletarRegistro.executeUpdate();
        return resultado;
    }
    
     public int atualizarRegistro(NomeBeans nomeBeans) throws SQLException{
        int resultado;
        atualizarRegistro.setString(1, nomeBeans.getNomeUsuario());
        atualizarRegistro.setInt(2, nomeBeans.getIdUsuario());
        resultado = atualizarRegistro.executeUpdate();
        return resultado;
    }
     
    public ArrayList selecionarRegistros(String nome) throws SQLException{
        ArrayList listaNomes = new ArrayList();
        buscarRegistros.setString(1,"%"+ nome + "%");
        ResultSet resultado = buscarRegistros.executeQuery();
        while(resultado.next()){
            NomeBeans nb = new NomeBeans();
            nb.setIdUsuario(resultado.getInt(1));
            nb.setNomeUsuario(resultado.getString(2));
            listaNomes.add(nb);
        }
        return listaNomes;
    }
    
}