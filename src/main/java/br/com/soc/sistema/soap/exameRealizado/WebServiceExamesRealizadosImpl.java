package br.com.soc.sistema.soap.exameRealizado;
import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.vo.ExameRealizadoVo;

import javax.jws.WebService;

@WebService(endpointInterface = "br.com.soc.sistema.soap.exameRealizado.WebServiceExameRealizados" )

public class WebServiceExamesRealizadosImpl implements WebServiceExameRealizados {

    private ExameRealizadoBusiness business;

    public WebServiceExamesRealizadosImpl() {
        this.business = new ExameRealizadoBusiness();
    }

    @Override
    public String buscarExameRealizado(String codigo) {
     return  business.buscarExamePor(codigo).toString();
    }

    @Override
    public void editarExameRealizado(ExameRealizadoVo exameRealizadoVo) {
         business.editarExameRealizado(exameRealizadoVo);
    }

    @Override
    public void excluirExameRealizado(String codigo) {
        business.excluirExameRealizado(codigo);
    }
}
