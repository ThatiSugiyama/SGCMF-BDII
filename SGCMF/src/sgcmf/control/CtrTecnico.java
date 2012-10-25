package sgcmf.control;

import sgcmf.view.tecnico.LimTecnico;

public class CtrTecnico
{
    private LimTecnico limTecnico;
    private CtrMain ctrMain;

    public CtrTecnico(CtrMain ctrMain)
    {
        this.ctrMain = ctrMain;
        limTecnico = new LimTecnico(this);
    }

    public void ativaTela()
    {
        limTecnico.setVisible(true);
    }

    public void logout()
    {
        ctrMain.ativaTela();
    }
}
