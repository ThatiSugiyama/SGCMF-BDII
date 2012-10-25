package sgcmf.control;

import sgcmf.view.comiteGestor.LimComiteGestor;

public class CtrComiteGestor
{
    private LimComiteGestor limComiteGestor;
    private CtrMain ctrMain;

    public CtrComiteGestor(CtrMain ctrMain)
    {
        this.ctrMain = ctrMain;
        limComiteGestor = new LimComiteGestor(this);
    }

    public void ativaTela()
    {
        limComiteGestor.setVisible(true);
    }

    public void logout()
    {
        ctrMain.ativaTela();
    }
}
