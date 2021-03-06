package sgcmf.control;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import sgcmf.model.dao.GeneralDAO;
import sgcmf.model.dao.SubstituicaoDAO;
import sgcmf.model.hibernate.Jogador;
import sgcmf.model.hibernate.Ocorrencia;
import sgcmf.model.hibernate.Substituicao;
import sgcmf.model.other.ResultadoOperacao;
import sgcmf.model.other.TipoResultadoOperacao;

public class CtrSubstituicao
{
    private CtrMain ctrMain;

    public CtrSubstituicao(CtrMain ctrMain)
    {
        this.ctrMain = ctrMain;
    }

    public String[][] querySubstByIdJogo(Short idJogo)
    {
        ArrayList<Substituicao> alSubst;
        String[][] dadosCartao;
        SubstituicaoDAO substDAO;

        substDAO = new SubstituicaoDAO();
        alSubst = substDAO.querySubstByIdJogo(idJogo);
        dadosCartao = arrayList2StringMatrix(alSubst);
        substDAO.fecharSessao();

        return dadosCartao;
    }

    public String[][] arrayList2StringMatrix(ArrayList<Substituicao> alSubst)
    {
        String[][] dadosSubst;
        Substituicao s;
        Jogador jEntrou;
        Jogador jSaiu;

        dadosSubst = new String[alSubst.size()][6];
        for (int i = 0; i < alSubst.size(); i++)
        {
            s = alSubst.get(i);

            jEntrou = s.getJogadorByIdjogadorentrou();
            jSaiu = s.getJogadorByIdjogadorsaiu();

            dadosSubst[i][0] = String.valueOf(s.getIdoc());
            dadosSubst[i][1] = String.valueOf(s.getOcorrencia().getInstantetempo());
            dadosSubst[i][2] = String.valueOf(s.getJogadorByIdjogadorsaiu().getSelecao().getPais());
            dadosSubst[i][3] = "("+jSaiu.getNcamisa() + ") " + jSaiu.getNome();
            dadosSubst[i][4] = "("+jEntrou.getNcamisa() + ") " + jEntrou.getNome();
            dadosSubst[i][5] = s.getMotivo();
        }

        return dadosSubst;
    }

    public ResultadoOperacao registraSubstituicao(String min, String seg, Short idJogo, String idJogadorSaiu,
                                                  String idJogadorEntrou, String motivo)
    {
        GeneralDAO gdao;
        Short shortIdJogadorSaiu;
        Short shortIdJogadorEntrou;
        Transaction tr;
        Substituicao objSubst;
        Ocorrencia objOcorrencia;
        Jogador objJogadorSaiu;
        Jogador objJogadorEntrou;
        String errorMessage;
        ResultadoOperacao result;

        errorMessage = validaCampos(min, seg, idJogadorSaiu, idJogadorEntrou, idJogo);

        //se nao tiver erros nos campos, entao faz o cadastro
        if (errorMessage.equals(""))
        {
            gdao = new GeneralDAO();
            tr = gdao.getSessao().beginTransaction();
            try
            {
                objOcorrencia = ctrMain.getCtrOcorrenciaJogo().registraOcorrencia(gdao, min, seg, idJogo);

                shortIdJogadorSaiu = Short.parseShort(idJogadorSaiu);
                shortIdJogadorEntrou = Short.parseShort(idJogadorEntrou);

                objJogadorSaiu = ctrMain.getCtrJogador().carregaJogadorById(gdao, shortIdJogadorSaiu);
                objJogadorEntrou = ctrMain.getCtrJogador().carregaJogadorById(gdao, shortIdJogadorEntrou);

                objSubst = new Substituicao(objOcorrencia.getId(), objJogadorEntrou, objJogadorSaiu, objOcorrencia, motivo);
                gdao.salvar(objSubst);
                tr.commit();

                result = new ResultadoOperacao("Substituição registrada com êxito!", TipoResultadoOperacao.EXITO);
            }
            catch (HibernateException hex)
            {
                tr.rollback();
                result = new ResultadoOperacao("Erro do Hibernate:\n" + hex.getMessage(), TipoResultadoOperacao.ERRO);
            }
            gdao.fecharSessao();
        }
        else
        {
            result = new ResultadoOperacao(errorMessage, TipoResultadoOperacao.ERRO);
        }

        return result;
    }

    private String validaCampos(String min, String seg, String idJogadorSaiu, String idJogadorEntrou, Short idJogo)
    {
        String errorMessage;

        errorMessage = ctrMain.getCtrOcorrenciaJogo().validaCampos(min, seg, idJogo);

        //so faz o outro teste se passou no primeiro teste
        if (errorMessage.equals(""))
        {
            try
            {
                Short.parseShort(idJogadorSaiu);
            }
            catch (NumberFormatException nfe)
            {
                errorMessage = "Jogador: é obrigatório selecionar o jogador que saiu de campo.";
            }
        }

        if (errorMessage.equals(""))
        {
            try
            {
                Short.parseShort(idJogadorEntrou);
            }
            catch (NumberFormatException nfe)
            {
                errorMessage = "Jogador: é obrigatório selecionar o jogador que entrou em campo.";
            }
        }

        return errorMessage;
    }
    
    public ResultadoOperacao removeSubstituicao(Short idOc)
    {
        ResultadoOperacao result;
        Transaction tr;
        GeneralDAO gdao;
        Substituicao substParaRemover;
        Ocorrencia ocParaRemover;

        substParaRemover = new Substituicao();
        ocParaRemover = new Ocorrencia();

        gdao = new GeneralDAO();
        tr = gdao.getSessao().beginTransaction();

        try
        {
            gdao.carregar(substParaRemover, idOc);
            gdao.carregar(ocParaRemover, idOc);

            gdao.apagar(substParaRemover);
            gdao.apagar(ocParaRemover);

            tr.commit();
            result = new ResultadoOperacao("Substituição removida com êxito!", TipoResultadoOperacao.EXITO);
        }
        catch (HibernateException hex)
        {
            tr.rollback();
            result = new ResultadoOperacao("Erro do Hibernate:\n" + hex.getMessage(), TipoResultadoOperacao.ERRO);
        }
        gdao.fecharSessao();

        return result;
    }
}
