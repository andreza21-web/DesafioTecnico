package br.com.soc.sistema.soap.exame;

import br.com.soc.sistema.vo.ExameVo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceExames {
	@WebMethod
	public String buscarExame(String codigo);

	@WebMethod
	void editarExame(ExameVo exameVo);

	@WebMethod
	void excluirExame(String codigo);
}
