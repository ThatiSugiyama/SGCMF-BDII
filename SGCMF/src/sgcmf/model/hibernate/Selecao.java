package sgcmf.model.hibernate;
// Generated Oct 30, 2012 8:06:49 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Selecao generated by hbm2java
 */
public class Selecao  implements java.io.Serializable {


     private short id;
     private Usuario usuario;
     private String pais;
     private String caminhoimgbandeira;
     private Set jogosForIdselecaoii = new HashSet(0);
     private Set jogosForIdselecaoi = new HashSet(0);
     private Set jogadors = new HashSet(0);

    public Selecao() {
    }

	
    public Selecao(short id, Usuario usuario, String pais, String caminhoimgbandeira) {
        this.id = id;
        this.usuario = usuario;
        this.pais = pais;
        this.caminhoimgbandeira = caminhoimgbandeira;
    }
    public Selecao(short id, Usuario usuario, String pais, String caminhoimgbandeira, Set jogosForIdselecaoii, Set jogosForIdselecaoi, Set jogadors) {
       this.id = id;
       this.usuario = usuario;
       this.pais = pais;
       this.caminhoimgbandeira = caminhoimgbandeira;
       this.jogosForIdselecaoii = jogosForIdselecaoii;
       this.jogosForIdselecaoi = jogosForIdselecaoi;
       this.jogadors = jogadors;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCaminhoimgbandeira() {
        return this.caminhoimgbandeira;
    }
    
    public void setCaminhoimgbandeira(String caminhoimgbandeira) {
        this.caminhoimgbandeira = caminhoimgbandeira;
    }
    public Set getJogosForIdselecaoii() {
        return this.jogosForIdselecaoii;
    }
    
    public void setJogosForIdselecaoii(Set jogosForIdselecaoii) {
        this.jogosForIdselecaoii = jogosForIdselecaoii;
    }
    public Set getJogosForIdselecaoi() {
        return this.jogosForIdselecaoi;
    }
    
    public void setJogosForIdselecaoi(Set jogosForIdselecaoi) {
        this.jogosForIdselecaoi = jogosForIdselecaoi;
    }
    public Set getJogadors() {
        return this.jogadors;
    }
    
    public void setJogadors(Set jogadors) {
        this.jogadors = jogadors;
    }




}


