/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miche
 */
public class ModuloConexao {
   
    public static Connection conector(){
        
        Connection conexao = null;
        
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbarbearia","root","");
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
}
