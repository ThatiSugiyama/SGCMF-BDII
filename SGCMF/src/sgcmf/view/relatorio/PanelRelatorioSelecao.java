/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcmf.view.relatorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sgcmf.model.other.SGCMFIcons;
import sgcmf.view.UtilView;

/**
 *
 * @author Helio
 */
public class PanelRelatorioSelecao extends JPanel
{
    public PanelRelatorioSelecao()
    {
        this.setLayout(new BorderLayout());
        add(panelNorte(), BorderLayout.NORTH);
        add(panelCentral(), BorderLayout.CENTER);
    }

    public JPanel panelNorte()
    {
        JPanel jpPrincipal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jlSelecao = new JLabel("Seleção:");
        UtilView.alinhaLabel(jlSelecao);
        JTextField jtfSelecao = new JTextField(15);
        jtfSelecao.setEditable(false);
        JButton jbPesquisar = new JButton(SGCMFIcons.PESQUISAR);
        UtilView.ajustarTamanhoBotaoPesquisar(jbPesquisar);
        jpPrincipal.add(jlSelecao);
        jpPrincipal.add(jtfSelecao);
        jpPrincipal.add(jbPesquisar);
        jpPrincipal.setBorder(BorderFactory.createTitledBorder("Buscar por:"));
        return jpPrincipal;
    }

    public JPanel panelCentral()
    {
        JPanel jpPrincipal = new JPanel(new BorderLayout());
        jpPrincipal.add(panelCentralEsquerda(), BorderLayout.WEST);
        jpPrincipal.add(panelCentralDireita(), BorderLayout.EAST);
        
        return jpPrincipal;
    }

    public JPanel panelCentralEsquerda()
    {
        JPanel jpPrincipal = new JPanel(new GridLayout(6,2));
        
        JLabel jlNomeSelecao = new JLabel("Nome da Seleção:");
        UtilView.alinhaLabel(jlNomeSelecao);
        JLabel jlJogosDisputados = new JLabel("Jogos Disputados:");
        UtilView.alinhaLabel(jlJogosDisputados);
        JLabel jlVitorias = new JLabel("Vitórias:");
        UtilView.alinhaLabel(jlVitorias);
        JLabel jlDerrotas = new JLabel("Derrotas:");
        UtilView.alinhaLabel(jlDerrotas);
        JLabel jlEmpates = new JLabel("Empates:");
        UtilView.alinhaLabel(jlEmpates);
        JLabel jlAproveitamento = new JLabel("Aproveitamento:");
        UtilView.alinhaLabel(jlAproveitamento);

        JTextField jtfNomeSelecao = new JTextField(15);
        jtfNomeSelecao.setEditable(false);
        JTextField jtfJogosDisputados = new JTextField(15);
        jtfJogosDisputados.setEditable(false);
        JTextField jtfVitorias = new JTextField(15);
        jtfVitorias.setEditable(false);
        JTextField jtfDerrotas = new JTextField(15);
        jtfDerrotas.setEditable(false);
        JTextField jtfEmpates = new JTextField(15);
        jtfEmpates.setEditable(false);
        JTextField jtfAproveitamento = new JTextField(15);
        jtfAproveitamento.setEditable(false);
        
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlNomeSelecao));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfNomeSelecao, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlJogosDisputados));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfJogosDisputados, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlVitorias));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfVitorias, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlDerrotas));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfDerrotas, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlEmpates));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfEmpates, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlAproveitamento));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfAproveitamento, FlowLayout.LEFT));
        
        return jpPrincipal;
    }

    public JPanel panelCentralDireita()
    {
        JPanel jpPrincipal = new JPanel(new GridLayout(5, 2));
        
        JLabel jlFaltas = new JLabel("Faltas:");
        UtilView.alinhaLabel(jlFaltas);
        JLabel jlCartoes = new JLabel("Cartões:");
        UtilView.alinhaLabel(jlCartoes);
        JLabel jlGolsPro = new JLabel("Gols Pró:");
        UtilView.alinhaLabel(jlGolsPro);
        JLabel jlGolsContra = new JLabel("Gols Contra:");
        UtilView.alinhaLabel(jlGolsContra);
        JLabel jlSaldoGols = new JLabel("Saldo Gols:");
        UtilView.alinhaLabel(jlSaldoGols);

        JTextField jtfFaltas = new JTextField(15);
        jtfFaltas.setEditable(false);
        JTextField jtfCartoes = new JTextField(15);
        jtfCartoes.setEditable(false);
        JTextField jtfGolsPro = new JTextField(15);
        jtfGolsPro.setEditable(false);
        JTextField jtfGolsContra = new JTextField(15);
        jtfGolsContra.setEditable(false);
        JTextField jtfSaldoGols = new JTextField(15);
        jtfSaldoGols.setEditable(false);
        
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlFaltas));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfFaltas, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlCartoes));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfCartoes, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlGolsPro));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfGolsPro, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlGolsContra));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfGolsContra, FlowLayout.LEFT));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jlSaldoGols));
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jtfSaldoGols, FlowLayout.LEFT));
        
        return jpPrincipal;
    }
     public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame jf = new JFrame();
                PanelRelatorioSelecao panelRelatorioSelecao = new PanelRelatorioSelecao();
                jf.setVisible(true);
                jf.setSize(400,400);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.add(panelRelatorioSelecao);
            }
        });
    }
}