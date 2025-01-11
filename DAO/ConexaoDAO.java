
package DAO;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 *
 * @author Isa
 */
public class ConexaoDAO {
    
    private String nome ="root";
    private String senha = "root";
    Connection conn = null;
    
    private final String URL = "jdbc:mysql://localhost:3306/Projeto?user=" + nome + "&password=" + senha;
    /* jdbc = JAVA DATA BASE CONNECTION
    é a biblioteca que faz a conexao do java com mysql
    */
    
    
    
    public Connection conectaBD(){
        
        
        try {
            
            conn = DriverManager.getConnection(URL);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"CONEXAO "+ erro.getMessage());
            
        }
        return conn;
            
            
        
        
        
   }
    
    
    
}
