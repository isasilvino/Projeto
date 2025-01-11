package DAO;




import DTO.ProfessorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Isa
 */
public class ProfessorDAO {

    Connection conn;
    PreparedStatement pstm;

    public ResultSet autenticacaoUsuario(ProfessorDTO objProfessorDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT * FROM professores WHERE dominio = ? AND senha = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProfessorDTO.getDominio());
            pstm.setString(2, objProfessorDTO.getSenha());

            // Retorna o ResultSet
            return pstm.executeQuery();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário: " + erro.getMessage());
            return null;
        }

    }

    public void cadastrarProfessor(ProfessorDTO objProfessorDTO) {
        String sql = "insert into professores (nome, sobrenome, senha, dominio, cargo, disciplina, serie) "
                + "values (?, ?, ?, ?, ?, ?, ?)";

        conn = new ConexaoDAO().conectaBD();
        
        

        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProfessorDTO.getNome());
            pstm.setString(2, objProfessorDTO.getSobrenome());
            pstm.setString(3, objProfessorDTO.getSenha());
            pstm.setString(4, objProfessorDTO.getDominio());
            pstm.setString(5, objProfessorDTO.getCargo());
            pstm.setString(6, objProfessorDTO.getDisciplina());
            pstm.setString(7, objProfessorDTO.getSerie());
            
            
            
        
            
            pstm.execute();
            pstm.close();
        
            
            

        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "FuncionarioDAO " + erro);
        }
        }

    }


