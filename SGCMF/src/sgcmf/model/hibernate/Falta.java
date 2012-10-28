package sgcmf.model.hibernate;
// Generated Oct 28, 2012 12:07:10 PM by Hibernate Tools 3.2.1.GA



/**
 * Falta generated by hbm2java
 */
public class Falta  implements java.io.Serializable {


     private short idoc;
     private Cartao cartao;
     private Ocorrencia ocorrencia;
     private Jogador jogador;
     private String tipo;

    public Falta() {
    }

	
    public Falta(short idoc, Ocorrencia ocorrencia, Jogador jogador, String tipo) {
        this.idoc = idoc;
        this.ocorrencia = ocorrencia;
        this.jogador = jogador;
        this.tipo = tipo;
    }
    public Falta(short idoc, Cartao cartao, Ocorrencia ocorrencia, Jogador jogador, String tipo) {
       this.idoc = idoc;
       this.cartao = cartao;
       this.ocorrencia = ocorrencia;
       this.jogador = jogador;
       this.tipo = tipo;
    }
   
    public short getIdoc() {
        return this.idoc;
    }
    
    public void setIdoc(short idoc) {
        this.idoc = idoc;
    }
    public Cartao getCartao() {
        return this.cartao;
    }
    
    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    public Ocorrencia getOcorrencia() {
        return this.ocorrencia;
    }
    
    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }
    public Jogador getJogador() {
        return this.jogador;
    }
    
    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}

