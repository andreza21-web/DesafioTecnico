package br.com.soc.sistema.business;

import br.com.soc.sistema.dao.funcionario.FuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBusiness  {

    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
    private static final String NAO_FOI_POSSIVEL_REALIZAR_INCLUSAO = "Nao foi possivel realizar a inclusao do registro";
    private static final String NAO_FOI_POSSIVEL_ATUALIZAR_REGISTRO = "Nao foi possivel atualizar o registro";
    private  static  final String NOME_NAO_PODE_SER_BRANCO = "Nome nao pode ser em branco";

    private FuncionarioDao dao;

    public FuncionarioBusiness() {
        this.dao = new FuncionarioDao();
    }

    public List<FuncionarioVo> trazerTodosOsFuncionarios(){
        System.out.println(dao.findAllFuncionarios());
        return dao.findAllFuncionarios();

    }

    public void salvarFuncionario(FuncionarioVo funcionarioVo) {
        try {
            if(funcionarioVo.getNome().isEmpty())
                throw new IllegalArgumentException(NOME_NAO_PODE_SER_BRANCO);

            dao.insertFuncionario(funcionarioVo);
        } catch (Exception e) {
            throw new BusinessException(NAO_FOI_POSSIVEL_REALIZAR_INCLUSAO);
        }

    }

    public List<FuncionarioVo> filtrarFuncionario(FuncionarioFilter filter){
        List<FuncionarioVo> funcionarios = new ArrayList<>();

        switch (filter.getOpcoesCombo()) {
            case ID:
                try {
                    Integer codigo = Integer.parseInt(filter.getValorBusca());
                    funcionarios.add(dao.findByCodigo(codigo));
                }catch (NumberFormatException e) {
                    throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
                }
                break;

            case NOME:
                funcionarios.addAll(dao.findAllByNome(filter.getValorBusca()));
                break;
        }

        return funcionarios;
    }

    public FuncionarioVo buscarFuncionarioPor(String codigo) {
        try {
            Integer cod = Integer.parseInt(codigo);
            return dao.findByCodigo(cod);
        }catch (NumberFormatException e) {
            throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
        }
    }

    public void  editarFuncionario(FuncionarioVo funcionarioVo){
        try {
            if(funcionarioVo.getNome().isEmpty())
                throw new IllegalArgumentException(NOME_NAO_PODE_SER_BRANCO);

            dao.update(funcionarioVo);
        } catch (Exception e) {
            throw new BusinessException(NAO_FOI_POSSIVEL_ATUALIZAR_REGISTRO);
        }
    }

    public void excluirFuncionario(String codigoFuncionario){
        try {
            Integer codigo = Integer.parseInt(codigoFuncionario);
            dao.excluirFuncionario(codigo);
        }catch (NumberFormatException e) {
            throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
        }
    }
}
