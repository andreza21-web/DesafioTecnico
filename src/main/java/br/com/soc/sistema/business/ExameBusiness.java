package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.exames.ExameDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.vo.ExameVo;

public class ExameBusiness {

	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private static final String NAO_FOI_POSSIVEL_REALIZAR_INCLUSAO = "Nao foi possivel realizar a inclusao do registro";
	private static final String NAO_FOI_POSSIVEL_ATUALIZAR_REGISTRO = "Nao foi possivel atualizar o registroo";
	private  static  final String NOME_NAO_PODE_SER_BRANCO = "Nome nao pode ser em branco";

	private ExameDao dao;
	
	public ExameBusiness() {
		this.dao = new ExameDao();
	}
	
	public List<ExameVo> trazerTodosOsExames(){
		return dao.findAllExames();
	}	
	
	public void salvarExame(ExameVo exameVo) {
		try {
			if(exameVo.getNome().isEmpty())
				throw new IllegalArgumentException(NOME_NAO_PODE_SER_BRANCO);
			
			dao.insertExame(exameVo);
		} catch (Exception e) {
			throw new BusinessException(NAO_FOI_POSSIVEL_REALIZAR_INCLUSAO);
		}
		
	}	
	
	public List<ExameVo> filtrarExames(ExameFilter filter){
		List<ExameVo> exames = new ArrayList<>();
		
		switch (filter.getOpcoesCombo()) {
			case ID:
				try {
					Integer codigo = Integer.parseInt(filter.getValorBusca());
					exames.add(dao.findByCodigo(codigo));
				}catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			break;

			case NOME:
				exames.addAll(dao.findAllByNome(filter.getValorBusca()));
			break;
		}
		
		return exames;
	}
	
	public ExameVo buscarExamePor(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		}catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public void  editarExame(ExameVo exameVo){
		try {
			if(exameVo.getNome().isEmpty())
				throw new IllegalArgumentException(NOME_NAO_PODE_SER_BRANCO);

			dao.update(exameVo);
		} catch (Exception e) {
			throw new BusinessException(NAO_FOI_POSSIVEL_ATUALIZAR_REGISTRO);
		}
	}

	public void excluirExame(String codigoExame){
		try {
			Integer codigo = Integer.parseInt(codigoExame);
			dao.excluirExame(codigo);
		}catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}
}
