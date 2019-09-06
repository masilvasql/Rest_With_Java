/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import Beans.NomeBeans;
import DAO.NomeDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class RnNome {
    
    public int incluirNome(NomeBeans nm){
        int resultado = 0;
        
        try{
            NomeDao nd = new NomeDao();
            resultado = nd.cadastrarNome(nm);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro em incluir nome RN");
        }
        return resultado;
    }
    
    public ArrayList buscaNomes(String nome){
        ArrayList listaNomes = new ArrayList();
        
        try {
            NomeDao nd = new NomeDao();
            listaNomes = nd.selecionarRegistros(nome);
                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em incluir buscaNomes RN");
        }
        return listaNomes;
    }
    
    public int deletarNome(int id){
        int resultado = 0;
        try {
            NomeDao nd = new NomeDao();
            resultado = nd.deletarNome(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em deletarNome RN");
        }
        return resultado;
    }
    
    public int atualizaRegistro(NomeBeans nb){
        int resultado = 0;
        try {
            NomeDao nd = new NomeDao();
            resultado = nd.atualizarRegistro(nb);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em Atualizar RN");
        }
        return resultado;
    }
    
}