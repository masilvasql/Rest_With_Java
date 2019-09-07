/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import Beans.LoginBeans;
import DAO.LoginDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class RnLogin {
    
    public List<LoginBeans> buscarRegistros(String login) {
        List resultado = new ArrayList();
        
        try{
            LoginDao ld = new LoginDao();
            resultado = ld.buscarRegistros(login);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro em buscarRegistros - RnNome");
        }
        
        return resultado;
    
    }
    
     public LoginBeans buscarRegistro(String login) {
        LoginBeans lb  = new LoginBeans();
        
        try{
            LoginDao ld = new LoginDao();
            lb = ld.buscarRegistro(login);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro em buscarRegistros - RnNome");
        }
        
        return lb;
    
    }
    
}
