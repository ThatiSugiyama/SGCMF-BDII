package sgcmf.view.admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sgcmf.control.CtrAdmin;
import sgcmf.control.CtrRelatorio;
import sgcmf.model.other.SGCMFIcons;
import sgcmf.view.UtilView;

/**
 *
 * @author Raryel Costa Souza
 */
public class LimAdmin extends JFrame
{
    private LimGerenciarUsuario limGerenciarUsuario;
    private CtrAdmin ctrAdmin;
    private CtrRelatorio ctrRelatorio;

    public LimAdmin(CtrAdmin ctrAdmin)
    {
        setIconImage(SGCMFIcons.LOGO.getImage());
        this.ctrAdmin = ctrAdmin;
        ctrRelatorio = ctrAdmin.getCtrMain().getCtrRelatorio();
        setTitle("Usuário Administrador");
        add(montaPainel());
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        limGerenciarUsuario = new LimGerenciarUsuario();

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                acaoLogout();
            }
        });

    }

    private JPanel montaPainel()
    {
        JPanel jpPrincipal = new JPanel(new BorderLayout());
        JPanel jpAux = new JPanel(new GridLayout(1, 1));

        JButton jbGerenciarUsuarios = new JButton("Gerenciar Usuários", SGCMFIcons.USUARIO);
        jbGerenciarUsuarios.setVerticalTextPosition(JButton.BOTTOM);
        jbGerenciarUsuarios.setHorizontalTextPosition(JButton.CENTER);

        jbGerenciarUsuarios.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                limGerenciarUsuario.setVisible(true);
            }
        });

        JButton jbRelatorios = new JButton("Relatórios", SGCMFIcons.RELATORIO);
        jbRelatorios.setVerticalTextPosition(JButton.BOTTOM);
        jbRelatorios.setHorizontalTextPosition(JButton.CENTER);
        jbRelatorios.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ctrRelatorio.ativaTela();
            }
        });
        JButton jbTabelaCampeonato = new JButton("Tabela do Campeonato", SGCMFIcons.TABELA);
        jbTabelaCampeonato.setVerticalTextPosition(JButton.BOTTOM);
        jbTabelaCampeonato.setHorizontalTextPosition(JButton.CENTER);

        JButton jbLogout = new JButton("Logout", SGCMFIcons.LOGOUT);
        jbLogout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                acaoLogout();
            }
        });

        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jbGerenciarUsuarios));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jbRelatorios));
        jpAux.add(UtilView.putComponentInFlowLayoutPanel(jbTabelaCampeonato));

        jpPrincipal.add(jpAux, BorderLayout.CENTER);
        jpPrincipal.add(UtilView.putComponentInFlowLayoutPanel(jbLogout), BorderLayout.SOUTH);

        return jpPrincipal;
    }

    private void acaoLogout()
    {
        int op;

        op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja fazer logout do sistema?", "Confirmação de Logout", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.OK_OPTION)
        {
            setVisible(false);
            ctrAdmin.logout();
        }
    }
}
