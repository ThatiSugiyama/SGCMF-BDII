package sgcmf.model;
// Generated Oct 27, 2012 11:54:54 AM by Hibernate Tools 3.2.1.GA



/**
 * Escalacao generated by hbm2java
 */
public class Escalacao  implements java.io.Serializable {


     private short id;
     private Selecao selecao;
     private Jogo jogo;
     private Jogador jogador;

    public Escalacao() {
    }

    public Escalacao(short id, Selecao selecao, Jogo jogo, Jogador jogador) {
       this.id = id;
       this.selecao = selecao;
       this.jogo = jogo;
       this.jogador = jogador;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public Selecao getSelecao() {
        return this.selecao;
    }
    
    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }
    public Jogo getJogo() {
        return this.jogo;
    }
    
    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    public Jogador getJogador() {
        return this.jogador;
    }
    
    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }




}


