/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcmf.view.tecnico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sgcmf.control.CtrMain;
import sgcmf.control.CtrSelecao;
import sgcmf.control.CtrTecnico;
import sgcmf.model.hibernate.Jogador;
import sgcmf.model.other.SGCMFIcons;
import sgcmf.view.UtilView;

/**
 *
 * @author Helio
 */
public class PanelCadastrarJogador extends JPanel
{
    private LimSelecionarSelecao limSelecionarSelecao;
    private CtrTecnico ctrTecnico;
    private CtrMain ctrMain;
    private CtrSelecao ctrSelecao;
    private String[] items =
    {
        "Goleiro", "Lateral Esquerdo", "Lateral Direito",
        "Atacante", "Volante", "Zagueiro"
    };

    public PanelCadastrarJogador(CtrTecnico ctrTecnico)
    {
        this.ctrTecnico = ctrTecnico;
        ctrMain = ctrTecnico.getCtrMain();
        ctrSelecao = ctrMain.getCtrSelecao();
        limSelecionarSelecao = new LimSelecionarSelecao(ctrSelecao);
        setLayout(new BorderLayout());
        montaPainel();
    }

    private void montaPainel()
    {
        JPanel jpAux = new JPanel(new GridLayout(6, 1));
        JPanel jpAux2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel jlNumeroCamisa = new JLabel("Número da Camisa:");
        UtilView.alinhaLabel(jlNumeroCamisa);
        JLabel jlNome = new JLabel("Nome:");
        UtilView.alinhaLabel(jlNome);
        JLabel jlDataNascimento = new JLabel("Data Nascimento:");
        UtilView.alinhaLabel(jlDataNascimento);
        JLabel jlAltura = new JLabel("Altura:");
        UtilView.alinhaLabel(jlAltura);
        JLabel jlPosicao = new JLabel("Posição:");
        UtilView.alinhaLabel(jlPosicao);
        JLabel jlSelecao = new JLabel("Seleção:");
        UtilView.alinhaLabel(jlSelecao);

        final JTextField jtfNumeroCamisa = new JTextField(10);
        final JTextField jtfNome = new JTextField(10);
        final JTextField jtfDataNascimento = new JTextField(10);
        final JTextField jtfAltura = new JTextField(10);
        final JTextField jtfSelecao = new JTextField(10);

        final JComboBox jcbPosicao = new JComboBox(items);
        jcbPosicao.setEditable(false);
        jcbPosicao.setPreferredSize(new Dimension(132, 20));

        JButton jbCadastrar = new JButton("Cadastrar");
        jbCadastrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Jogador j;
                j = new Jogador();
                j.setNcamisa(Short.parseShort(jtfNumeroCamisa.getText()));
                j.setNome(jtfNome.getText());
                j.setDatanasc(new Date(jtfDataNascimento.getText())); //Verificar qual a data sem ser deprecada.
                j.setAltura(new BigDecimal(jtfAltura.getText()));
                j.setPosicao(jcbPosicao.getSelectedItem().toString()); //Tem que mudar pra comboBox eu acho...

            }
        });

        JButton jbPesquisar = new JButton(SGCMFIcons.PESQUISAR);
        UtilView.ajustarTamanhoBotaoPesquisar(jbPesquisar);

        jbPesquisar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                limSelecionarSelecao.ativaTela();
            }
        });

        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jlNumeroCamisa));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jtfNumeroCamisa, FlowLayout.LEFT));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jlNome));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jtfNome, FlowLayout.LEFT));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jlDataNascimento));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jtfDataNascimento, FlowLayout.LEFT));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jlAltura));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jtfAltura, FlowLayout.LEFT));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jlPosicao));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jcbPosicao, FlowLayout.LEFT));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jlSelecao));
        jpAux2.add(jtfSelecao);
        jpAux2.add(jbPesquisar);
        jpAux.add(jpAux2);
        jpAux.setBorder(BorderFactory.createEtchedBorder());

        this.add(jpAux, BorderLayout.CENTER);
        this.add(UtilView.putComponentInFlowLayoutPanel(jbCadastrar), BorderLayout.SOUTH);
    }
}
