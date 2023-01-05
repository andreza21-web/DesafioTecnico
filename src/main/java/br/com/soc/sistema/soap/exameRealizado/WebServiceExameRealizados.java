package br.com.soc.sistema.soap.exameRealizado;

import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServiceExameRealizados {

    @WebMethod
    public String buscarExameRealizado(String codigo);

    @WebMethod
    void editarExameRealizado(ExameRealizadoVo exameRealizadoVo);

    @WebMethod
    void excluirExameRealizado(String codigo);
}
