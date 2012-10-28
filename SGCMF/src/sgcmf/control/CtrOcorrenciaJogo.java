package sgcmf.control;

import java.sql.Time;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import sgcmf.model.util.ResultadoOperacao;
import sgcmf.model.util.TipoResultadoOperacao;
import sgcmf.model.dao.GeneralDAO;
import sgcmf.model.hibernate.Gol;
import sgcmf.model.hibernate.Jogador;
import sgcmf.model.hibernate.Jogo;
import sgcmf.model.hibernate.Ocorrencia;

public class CtrOcorrenciaJogo
{
	private CtrMain ctrMain;
	
	public CtrOcorrenciaJogo(CtrMain ctrMain)
	{
		this.ctrMain = ctrMain;
	}
	
	private Ocorrencia registraOcorrencia(GeneralDAO gdao, String min, String seg, Short idJogo)
	{
		Ocorrencia oc;
		Jogo jogo;
		Time tempo;
		
		jogo = ctrMain.getCtrJogo().carregarJogoById(idJogo);

		tempo = new Time(0, Integer.parseInt(min), Integer.parseInt(seg));
		
		oc = new Ocorrencia();
		oc.setInstantetempo(tempo);
		oc.setJogo(jogo);		
		
		gdao.salvar(oc);
		
		return oc;
	}
	
	public ResultadoOperacao registraGol(String min, String seg, Short idJogo, String idJogadorAutor, String idJogadorAssist,
							String tipoGol, String modoGol)
	{
		Short shortIdJogadorAutor;
		Short shortIdJogadorAssist;
		GeneralDAO gdao;
		Transaction tr;
		Gol g;
		Ocorrencia o;	
		Jogador jAutor;
		Jogador jAssist;		
		String errorMessage;
		ResultadoOperacao result;
		
		errorMessage = validaCamposGol(min, seg, idJogo, idJogadorAutor);
		
		//se nao tiver erros nos campos, entao faz o cadastro
		if (errorMessage.equals(""))
		{
			gdao = new GeneralDAO();
			tr = gdao.getSessao().beginTransaction();
			try
			{
				o = registraOcorrencia(gdao, min, seg, idJogo);
				
				//carrega o jogador autor
				shortIdJogadorAutor = Short.parseShort(idJogadorAutor);
				jAutor = ctrMain.getCtrJogador().carregaJogadorById(shortIdJogadorAutor);
				
				//se tiver jogador assistente, ele eh carregado
				if (!idJogadorAssist.equals(""))
				{
					shortIdJogadorAssist = Short.parseShort(idJogadorAssist);
					jAssist = ctrMain.getCtrJogador().carregaJogadorById(shortIdJogadorAssist);
					g = new Gol(o.getId(), jAutor, o, jAssist, tipoGol, modoGol);
				}
				else
				{
					g = new Gol(o.getId(), jAutor, o, tipoGol, modoGol);
				}
				
				//salva o gol e commita
				gdao.salvar(g);
				tr.commit();
				
				result = new ResultadoOperacao("Gol cadastrado com êxito!", TipoResultadoOperacao.EXITO);
			}
			catch(HibernateException hex)
			{
				tr.rollback();
				result = new ResultadoOperacao("Erro do Hibernate:\n" + hex.getMessage(), TipoResultadoOperacao.ERRO);			
			}
		}
		else
		{
			result = new ResultadoOperacao(errorMessage, TipoResultadoOperacao.ERRO);
		}
		
		return result;
	}
	
	private String validaCamposGol(String min, String seg, Short idJogo, String idJogadorAutor)
	{
		String errorMessage;
		
		errorMessage = "";
		try
		{
			Integer.parseInt(min);
			Integer.parseInt(seg);
		}
		catch (NumberFormatException nfe)
		{
			errorMessage = "Instante de tempo: digite números válidos.";
		}
		
		//so faz o outro teste se passou no primeiro teste
		if (errorMessage.equals(""))		
		{
			try
			{
				Short.parseShort(idJogadorAutor);
			}
			catch(NumberFormatException nfe)
			{
				errorMessage = "Jogador autor: é obrigatório selecionar o jogador autor.";
			}
		}
		
		return errorMessage;
	}
	
	public void removeGol(Short idOc)
	{
		GeneralDAO gdao;
		Transaction tr;
		
		Gol golParaRemover;
		Ocorrencia ocParaRemover;
		
		golParaRemover = new Gol();
		ocParaRemover = new Ocorrencia();
		
		gdao= new GeneralDAO();
		tr = gdao.getSessao().beginTransaction();
		
		try
		{
			golParaRemover = (Gol) gdao.carregar(golParaRemover, idOc);
			ocParaRemover = (Ocorrencia) gdao.carregar(ocParaRemover, idOc);
			
			gdao.apagar(golParaRemover);
			gdao.apagar(ocParaRemover);
			
			tr.commit();
		}
		catch(HibernateException hex)
		{
			tr.rollback();
			System.out.println(hex.getMessage());
		}
		
		gdao.fecharSessao();
	}
	
	public String[][] queryGolTodos()
	{
		GeneralDAO<Gol> gdao;
		ArrayList<Gol> alGol;
		String[][] dadosGol;
		
		gdao = new GeneralDAO<Gol>();
		alGol = gdao.listaTodos("Gol");
		dadosGol = arrayList2StringMatrix(alGol);
		
		gdao.fecharSessao();
		return dadosGol;
	}
	
	public String[][] arrayList2StringMatrix(ArrayList<Gol> alGol)
	{
		String[][] dadosGol;
		Gol g;
		
		dadosGol = new String[alGol.size()][6];
		for (int i = 0; i < alGol.size(); i++)
		{
			g = alGol.get(i);
			dadosGol[i][0] = String.valueOf(g.getIdoc());
			dadosGol[i][1] = String.valueOf(g.getOcorrencia().getInstantetempo());
			dadosGol[i][2] = g.getJogadorByIdjogadorautor().getNome();
			
			if (g.getJogadorByIdjogadorassistencia() != null)
			{
				dadosGol[i][3] = g.getJogadorByIdjogadorassistencia().getNome();
			}
			else
			{
				dadosGol[i][3] = "";
			}
			
			dadosGol[i][4] = g.getTipo();
			dadosGol[i][5] = g.getModo();
		}
		
		return dadosGol;
	}
}