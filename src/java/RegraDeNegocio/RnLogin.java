/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import DAO.LoginDao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class RnLogin {
    
    public ArrayList buscarRegistros(String login) {
        ArrayList resultado = new ArrayList();
        
        try{
            LoginDao ld = new LoginDao();
            resultado = ld.buscarRegistros(login);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro em buscarRegistros - RnNome");
        }
        
        return resultado;
    
    }
    
}
