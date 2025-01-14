
package DAO;

import DTO.AlunoDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Isa
 */
public class AlunoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AlunoDTO> lista = new ArrayList<>();

    public ResultSet autenticacaoUsuario(AlunoDTO objAlunoDTO) {
        conn = new ConexaoDAO().conectaBD();
        

        try {
            String sql = "SELECT * FROM alunos WHERE matricula = ? AND senha = ?";
             pstm = conn.prepareStatement(sql);
            pstm.setString(1, objAlunoDTO.getMatricula());
            pstm.setString(2, objAlunoDTO.getSenha());

            // retorna o ResultSet
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
        
            
            

        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "AlunoDAO Cadastro " + erro);
        }
        }
     
     
     
     public ArrayList <AlunoDTO> pesquisarAluno(){
         
         String sql = "Select id, nome, sobrenome, serie, nota, faltas from alunos";
         conn = new ConexaoDAO().conectaBD();
         
         try {
             
             pstm = conn.prepareStatement(sql);
             rs= pstm.executeQuery();
             
             while (rs.next()){// fica colocando todos os nomes independente da quantidade
                 AlunoDTO objAlunoDTO = new AlunoDTO();
                 
                 objAlunoDTO.setId(rs.getString("id"));
                 objAlunoDTO.setNome(rs.getString("nome"));
                 objAlunoDTO.setSobrenome((rs.getString("sobrenome")));
                 objAlunoDTO.setSerie(rs.getString("serie"));
                 objAlunoDTO.setNota(rs.getString("nota"));
                 objAlunoDTO.setFaltas(rs.getString("faltas"));
                 
                 lista.add(objAlunoDTO);
                 
             }
             
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "AlunoDAO Pesquisar " + erro);
         }
         
         return lista; //retorna a lista pronta
     }
     
     
    public void alterarAluno(AlunoDTO objAlunoDTO){
        
        String sql = "update alunos set nome = ?, sobrenome = ?, serie =?, nota = ?, faltas = ? where id = ?";
        
        conn = new ConexaoDAO().conectaBD();
       
        

        try {
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objAlunoDTO.getNome());
            pstm.setString(2, objAlunoDTO.getSobrenome());
            pstm.setString(3, objAlunoDTO.getSerie());
            pstm.setString(4, objAlunoDTO.getNota());
            pstm.setString(5, objAlunoDTO.getFaltas());
            pstm.setString(6, objAlunoDTO.getId());
           
            
            
            
            pstm.execute();
            pstm.close();
        
            
            

        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "AlunoDAO Alterar " + erro);
        }
    }
}
    

