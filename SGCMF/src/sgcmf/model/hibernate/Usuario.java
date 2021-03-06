package sgcmf.model.hibernate;
// Generated Oct 30, 2012 8:06:49 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private short id;
     private String nome;
     private String cpf;
     private String email;
     private String perfil;
     private String login;
     private String senha;
     private Set selecaos = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(short id, String nome, String cpf, String email, String perfil, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.perfil = perfil;
        this.login = login;
        this.senha = senha;
    }
    public Usuario(short id, String nome, String cpf, String email, String perfil, String login, String senha, Set selecaos) {
       this.id = id;
       this.nome = nome;
       this.cpf = cpf;
       this.email = email;
       this.perfil = perfil;
       this.login = login;
       this.senha = senha;
       this.selecaos = selecaos;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Set getSelecaos() {
        return this.selecaos;
    }
    
    public void setSelecaos(Set selecaos) {
        this.selecaos = selecaos;
    }




}


