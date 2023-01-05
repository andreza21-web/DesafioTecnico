package br.com.soc.sistema.soap.funcionario;

import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.vo.FuncionarioVo;

import javax.jws.WebService;

@WebService(endpointInterface = "br.com.soc.sistema.soap.funcionario.WebServiceFuncionario" )
public class WebServiceFuncionarioImpl implements WebServiceFuncionario {

    private FuncionarioBusiness business;

    public WebServiceFuncionarioImpl() {
        this.business = new FuncionarioBusiness();
    }

    @Override
    public String buscarFuncionario(String codigo) {
        return business.buscarFuncionarioPor(codigo).toString();
    }

    @Override
    public void editarFuncionario(FuncionarioVo funcionarioVo) { business.editarFuncionario(funcionarioVo); }


    @Override
    public void excluirFuncionario(String  codigo){ business.excluirFuncionario(codigo);}
}
