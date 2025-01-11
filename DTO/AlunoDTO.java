package DTO;

/**
 *
 * @author Isa
 */
public class AlunoDTO {
    
    private String nome;
    private String sobrenome;
    private String matricula;
    private String senha;
    private String confirmarSenha;

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    private String serie;
    private String responsavel_nome;
    private String responsavel_telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getResponsavel_nome() {
        return responsavel_nome;
    }

    public void setResponsavel_nome(String responsavel_nome) {
        this.responsavel_nome = responsavel_nome;
    }

    public String getResponsavel_telefone() {
        return responsavel_telefone;
    }

    public void setResponsavel_telefone(String responsavel_telefone) {
        this.responsavel_telefone = responsavel_telefone;
    }

    
    private String id;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

}
