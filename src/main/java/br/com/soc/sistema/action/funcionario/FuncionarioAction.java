package br.com.soc.sistema.action.funcionario;

import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarFuncionario;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuncionarioAction extends Action {

    private List<FuncionarioVo> funcionarios = new ArrayList<>();
    private FuncionarioBusiness business = new FuncionarioBusiness();
    private FuncionarioFilter filtrar = new FuncionarioFilter();
    private FuncionarioVo funcionarioVo = new FuncionarioVo();

    public String todos() {
        funcionarios.addAll(business.trazerTodosOsFuncionarios());

        return SUCCESS;
    }

    public String filtrar() {
        if(filtrar.isNullOpcoesCombo())
            return REDIRECT;

        funcionarios = business.filtrarFuncionario(filtrar);

        return SUCCESS;
    }

    public String novo() {
        if(funcionarioVo.getNome() == null)
            return INPUT;

        business.salvarFuncionario(funcionarioVo);

        return REDIRECT;
    }

    public String editar() {
        if(funcionarioVo.getNome() == null){
            funcionarioVo = business.buscarFuncionarioPor(funcionarioVo.getCodigoFuncionario());
            return EDIT;
        }else {
            business.editarFuncionario(funcionarioVo);
        }
            return REDIRECT;
        }

    public String excluir(){

        business.excluirFuncionario(funcionarioVo.getCodigoFuncionario());
        return REDIRECT;

    }

    public List<OpcoesComboBuscarFuncionario> getListaOpcoesCombo(){
        return Arrays.asList(OpcoesComboBuscarFuncionario.values());
    }
    
    public List<FuncionarioVo> getFuncionario() {
        return funcionarios;
    }

    public void setFuncionario(List<FuncionarioVo> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public FuncionarioFilter getFiltrar() {
        return filtrar;
    }
    
    public void setFiltrar(FuncionarioFilter filtrar) {
        this.filtrar = filtrar;
    }

    public FuncionarioVo getFuncionarioVo() {
        return funcionarioVo;
    }

    public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
        this.funcionarioVo = funcionarioVo;
    }
}
