package sgcmf.view.comiteGestor.ocorrenciaJogo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import sgcmf.control.CtrSubstituicao;
import sgcmf.model.other.SGCMFIcons;
import sgcmf.view.comiteGestor.LimBuscarJogador;
import sgcmf.view.UtilView;
import sgcmf.view.tecnico.ISelecionarJogador;

public class LimRegistrarSubstituicao extends JDialog implements ISelecionarJogador
{
    private LimBuscarJogador limBuscarJogador;
    private LimGerenciarOcorrenciasJogo limGerenciarOcorrencias;
    private CtrSubstituicao ctrSubstituicao;
    private boolean selecaoJogadorSaiu;
    private JTextField jtfInstanteTempoMin;
    private JTextField jtfInstanteTempoSeg;
    private JTextField jtfJogadorSaiu;
    private JTextField jtfJogadorEntrou;
    private JRadioButton jrbMotivoEstrategica;
    private JRadioButton jrbMotivoContusao;
    private ButtonGroup bgMotivo;
    
    public LimRegistrarSubstituicao(CtrSubstituicao ctrSubstituicao, LimBuscarJogador limBuscarJogador, LimGerenciarOcorrenciasJogo limGerenciarOcorrencias)
    {
        this.ctrSubstituicao = ctrSubstituicao;        
        this.limGerenciarOcorrencias = limGerenciarOcorrencias;
        this.limBuscarJogador = limBuscarJogador;
        
        setTitle("Registrar Substituição");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        add(montaMainPanel());
        setModal(true);
        setSize(360, 220);
        setLocationRelativeTo(null);
    }
    
    private JPanel montaMainPanel()
    {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JPanel jpAuxJogadorSaiu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jpAuxJogadorEntrou = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelJRBMotivo = new JPanel(new GridLayout(2, 1));
        JPanel jpAuxTempo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel jlInstanteTempo = new JLabel("Instante de Tempo:");
        UtilView.alinhaLabel(jlInstanteTempo);
        JLabel jlJogadorSaiu = new JLabel("Jogador Saiu:");
        UtilView.alinhaLabel(jlJogadorSaiu);
        JLabel jlJogadorEntrou = new JLabel("Jogador Entrou:");
        UtilView.alinhaLabel(jlJogadorEntrou);
        JLabel jlMotivo = new JLabel("Motivo:");
        UtilView.alinhaLabel(jlMotivo);
        
        jtfInstanteTempoMin = new JTextField(4);
        JLabel jlMin = new JLabel("min");
        
        jtfInstanteTempoSeg = new JTextField(4);
        JLabel jlSeg = new JLabel("seg");
        
        jtfJogadorSaiu = new JTextField(10);
        jtfJogadorSaiu.setEditable(false);
        jtfJogadorEntrou = new JTextField(10);
        jtfJogadorEntrou.setEditable(false);
        
        jrbMotivoEstrategica = new JRadioButton("Estratégica");
        jrbMotivoEstrategica.setActionCommand("Estrategica");
        
        jrbMotivoContusao = new JRadioButton("Por contusão");
        jrbMotivoContusao.setActionCommand("Contusao");
        jrbMotivoEstrategica.setSelected(true);
        
        JButton jbRegistrarSubst = new JButton("Registrar Substituição");
        jbRegistrarSubst.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                registrarSubst();
            }
        });
        
        JButton jbPesqJogSaiu = new JButton(SGCMFIcons.PESQUISAR);
        UtilView.ajustarTamanhoBotaoPesquisar(jbPesqJogSaiu);
        JButton jbPesqJogEntrou = new JButton(SGCMFIcons.PESQUISAR);
        UtilView.ajustarTamanhoBotaoPesquisar(jbPesqJogEntrou);
        
        jbPesqJogSaiu.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selecaoJogadorSaiu = true;
                ativaTelaBuscarJogador();
            }
        });
        
        jbPesqJogEntrou.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ativaTelaBuscarJogador();
            }
        });
        
        bgMotivo = new ButtonGroup();
        bgMotivo.add(jrbMotivoEstrategica);
        bgMotivo.add(jrbMotivoContusao);
        
        formPanel.add(UtilView.putComponentInFlowLayoutPanel(jlInstanteTempo));
        jpAuxTempo.add(jtfInstanteTempoMin);
        jpAuxTempo.add(jlMin);
        jpAuxTempo.add(jtfInstanteTempoSeg);
        jpAuxTempo.add(jlSeg);
        formPanel.add(jpAuxTempo);
        
        formPanel.add(UtilView.putComponentInFlowLayoutPanel(jlJogadorSaiu));
        jpAuxJogadorSaiu.add(jtfJogadorSaiu);
        jpAuxJogadorSaiu.add(jbPesqJogSaiu);
        formPanel.add(jpAuxJogadorSaiu);
        
        formPanel.add(UtilView.putComponentInFlowLayoutPanel(jlJogadorEntrou));
        jpAuxJogadorEntrou.add(jtfJogadorEntrou);
        jpAuxJogadorEntrou.add(jbPesqJogEntrou);
        formPanel.add(jpAuxJogadorEntrou);
        
        formPanel.add(UtilView.putComponentInFlowLayoutPanel(jlMotivo));
        panelJRBMotivo.add(jrbMotivoEstrategica);
        panelJRBMotivo.add(jrbMotivoContusao);
        formPanel.add(panelJRBMotivo);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(UtilView.putComponentInFlowLayoutPanel(jbRegistrarSubst), BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    private void ativaTelaBuscarJogador()
    {
        limBuscarJogador.ativaTela(this);
    }
    
    @Override
    public void jogadorSelecionado(Short idJogador)
    {
        if (selecaoJogadorSaiu)
        {
            jtfJogadorSaiu.setText(idJogador + "");
            selecaoJogadorSaiu = false;
        }
        else
        {
            jtfJogadorEntrou.setText(idJogador + "");
        }
    }
    
    public void registrarSubst()
    {
        String tipo;
        
        tipo = bgMotivo.getSelection().getActionCommand();
        System.out.println(tipo);
    }
}
