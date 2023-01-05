package br.com.soc.sistema.soap.funcionario;

import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServiceFuncionario {

    @WebMethod
    public String buscarFuncionario(String codigo);

    @WebMethod
    void editarFuncionario(FuncionarioVo funcionarioVo);

    @WebMethod
    void excluirFuncionario(String codigo);
}
