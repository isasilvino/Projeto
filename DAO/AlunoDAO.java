
package DAO;

import DTO.AlunoDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Isa
 */
public class AlunoDAO {
    Connection conn;

    public ResultSet autenticacaoUsuario(AlunoDTO objAlunoDTO) {
        conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm;

        try {
            String sql = "SELECT * FROM alunos WHERE matricula = ? AND senha = ?";
             pstm = conn.prepareStatement(sql);
            pstm.setString(1, objAlunoDTO.getMatricula());
            pstm.setString(2, objAlunoDTO.getSenha());

            
            return pstm.executeQuery();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário: " + erro.getMessage());
            return null;
        }
    }
     public void cadastrarAluno(AlunoDTO objAlunoDTO) {
        String sql = "insert into alunos (nome, sobrenome, senha, matricula, serie, responsavel_nome, responsavel_telefone) "
                + "values (?, ?, ?, ?, ?, ?, ?)";

        conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm;
        

        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objAlunoDTO.getNome());
            pstm.setString(2, objAlunoDTO.getSobrenome());
            pstm.setString(3, objAlunoDTO.getSenha());
            pstm.setString(4, objAlunoDTO.getMatricula());
            pstm.setString(5, objAlunoDTO.getSerie());
            pstm.setString(6, objAlunoDTO.getResponsavel_nome());
            pstm.setString(7, objAlunoDTO.getResponsavel_telefone());
            
            
            
        
            
            pstm.execute();
            pstm.close();
        
            
            

        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "FuncionarioDAO " + erro);
        }
        }
    
}
    

