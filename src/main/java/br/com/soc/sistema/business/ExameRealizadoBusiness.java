package br.com.soc.sistema.business;



import br.com.soc.sistema.dao.exameRealizado.ExameRealizadoDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExameRealizadoFilter;
import br.com.soc.sistema.vo.ExameRealizadoVo;

import java.util.ArrayList;
import java.util.List;

public class ExameRealizadoBusiness {



    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
    private static final String NAO_FOI_POSSIVEL_REALIZAR_INCLUSAO = "Nao foi possivel realizar a inclusao do registro";
    private static final String NAO_FOI_POSSIVEL_ATUALIZAR_REGISTRO = "Nao foi possivel atualizar o registroo";
    private  static  final String NOME_NAO_PODE_SER_BRANCO = "Nome nao pode ser em branco";

    private ExameRealizadoDao dao;

    public ExameRealizadoBusiness() {
        this.dao = new ExameRealizadoDao();
    }

    public List<ExameRealizadoVo> trazerTodosOsExamesRealizados(){
        System.out.println(dao.findAllExamesRealizado());

        return dao.findAllExamesRealizado();
    }

    public void salvarExameRealizado(ExameRealizadoVo exameRealizadoVo) {
        try {
            if(exameRealizadoVo.getNomeExame().isEmpty() & exameRealizadoVo.getNomeFuncionario().isEmpty())
                throw new IllegalArgumentException(NOME_NAO_PODE_SER_BRANCO);

            dao.insertExameRealizado(exameRealizadoVo);
        } catch (Exception e) {
            throw new BusinessException(NAO_FOI_POSSIVEL_REALIZAR_INCLUSAO);
        }

    }

    public List<ExameRealizadoVo> filtrarExamesRealizados(ExameRealizadoFilter filter){
        List<ExameRealizadoVo> exameRealizado = new ArrayList<>();

        switch (filter.getOpcoesCombo()) {
            case ID:
                try {
                    Integer codigo = Integer.parseInt(filter.getValorBusca());
                    exameRealizado.add(dao.findByCodigo(codigo));
                }catch (NumberFormatException e) {
                    throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
                }
                break;

            case NOME:
                exameRealizado.addAll(dao.findAllByNome(filter.getValorBusca()));
                break;
        }

        return exameRealizado;
    }

    public ExameRealizadoVo buscarExamePor(String codigo) {
        try {
            Integer cod = Integer.parseInt(codigo);
            return dao.findByCodigo(cod);
        }catch (NumberFormatException e) {
            throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
        }
    }

    public void  editarExameRealizado(ExameRealizadoVo exameRealizadoVo){
        try {
            if(exameRealizadoVo.getNomeExame().isEmpty() & exameRealizadoVo.getNomeFuncionario().isEmpty())
                throw new IllegalArgumentException(NOME_NAO_PODE_SER_BRANCO);

            dao.update(exameRealizadoVo);
        } catch (Exception e) {
            throw new BusinessException(NAO_FOI_POSSIVEL_ATUALIZAR_REGISTRO);
        }
    }

    public void excluirExameRealizado(String codigoExame){
        try {
            Integer codigo = Integer.parseInt(codigoExame);
            dao.excluirExameRealizado(codigo);
        }catch (NumberFormatException e) {
            throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
        }
    }
}
