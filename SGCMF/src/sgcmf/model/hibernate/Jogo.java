package sgcmf.model.hibernate;
// Generated Oct 30, 2012 8:06:49 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Jogo generated by hbm2java
 */
public class Jogo  implements java.io.Serializable {


     private short id;
     private Selecao selecaoByIdselecaoi;
     private Selecao selecaoByIdselecaoii;
     private String tipo;
     private String cidade;
     private String nomeestadio;
     private boolean prorrogacao;
     private Date datahora;
     private Set ocorrencias = new HashSet(0);

    public Jogo() {
    }

	
    public Jogo(short id, String tipo, String cidade, String nomeestadio, boolean prorrogacao, Date datahora) {
        this.id = id;
        this.tipo = tipo;
        this.cidade = cidade;
        this.nomeestadio = nomeestadio;
        this.prorrogacao = prorrogacao;
        this.datahora = datahora;
    }
    public Jogo(short id, Selecao selecaoByIdselecaoi, Selecao selecaoByIdselecaoii, String tipo, String cidade, String nomeestadio, boolean prorrogacao, Date datahora, Set ocorrencias) {
       this.id = id;
       this.selecaoByIdselecaoi = selecaoByIdselecaoi;
       this.selecaoByIdselecaoii = selecaoByIdselecaoii;
       this.tipo = tipo;
       this.cidade = cidade;
       this.nomeestadio = nomeestadio;
       this.prorrogacao = prorrogacao;
       this.datahora = datahora;
       this.ocorrencias = ocorrencias;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public Selecao getSelecaoByIdselecaoi() {
        return this.selecaoByIdselecaoi;
    }
    
    public void setSelecaoByIdselecaoi(Selecao selecaoByIdselecaoi) {
        this.selecaoByIdselecaoi = selecaoByIdselecaoi;
    }
    public Selecao getSelecaoByIdselecaoii() {
        return this.selecaoByIdselecaoii;
    }
    
    public void setSelecaoByIdselecaoii(Selecao selecaoByIdselecaoii) {
        this.selecaoByIdselecaoii = selecaoByIdselecaoii;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getNomeestadio() {
        return this.nomeestadio;
    }
    
    public void setNomeestadio(String nomeestadio) {
        this.nomeestadio = nomeestadio;
    }
    public boolean isProrrogacao() {
        return this.prorrogacao;
    }
    
    public void setProrrogacao(boolean prorrogacao) {
        this.prorrogacao = prorrogacao;
    }
    public Date getDatahora() {
        return this.datahora;
    }
    
    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }
    public Set getOcorrencias() {
        return this.ocorrencias;
    }
    
    public void setOcorrencias(Set ocorrencias) {
        this.ocorrencias = ocorrencias;
    }




}


