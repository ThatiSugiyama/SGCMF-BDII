package sgcmf.view.comiteGestor.disputaPenalti;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import sgcmf.control.CtrComiteGestor;
import sgcmf.control.CtrJogo;
import sgcmf.model.other.SGCMFIcons;
import sgcmf.view.comiteGestor.LimBuscarJogador;
import sgcmf.view.comiteGestor.LimConsultarJogo;

public class LimGerDispPenaltiSelecionarJogo extends LimConsultarJogo
{
	private LimGerDisputaPenalti limGerDisputaPenalti;
	
	public LimGerDispPenaltiSelecionarJogo(CtrComiteGestor ctrComiteGestor, LimBuscarJogador limBuscarJogador)
	{
		super(ctrComiteGestor.getCtrJogo());
		setIconImage(SGCMFIcons.PENALTI.getImage());
		setTitle("Gerenciar Disputa de Pênaltis: Selecione um Jogo");
		
		limGerDisputaPenalti = new LimGerDisputaPenalti(limBuscarJogador);
		
		mainPanel.add(montaSouthPanel(), BorderLayout.SOUTH);
	}
	
	
	private JPanel montaSouthPanel()
	{
		JPanel southPanel = new JPanel();
		
		JButton jbGerenciarOcorrencias = new JButton("Gerenciar Disputa de Pênaltis para o Jogo Selecionado");
		jbGerenciarOcorrencias.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				limGerDisputaPenalti.setVisible(true);
			}
		});
		
		southPanel.add(jbGerenciarOcorrencias);
		
		return southPanel;
	}
}
