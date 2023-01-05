package br.com.soc.sistema.action.exameRealizado;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.filter.ExameRealizadoFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarExames;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExameRealizadoAction extends Action {

    private ExameVo exameVo = new ExameVo();
    private FuncionarioVo funcionarioVo = new FuncionarioVo();
    private ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();

    private List<ExameVo> exames = new ArrayList<>();
    private List<FuncionarioVo> funcionarios = new ArrayList<>();
    private List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
    private ExameRealizadoFilter filtrar = new ExameRealizadoFilter();

    private FuncionarioBusiness funcionarioBusiness = new FuncionarioBusiness();

    private ExameBusiness exameBusiness = new ExameBusiness();
    private ExameRealizadoBusiness exameRealizadoBusiness = new ExameRealizadoBusiness();
    private ArrayList<String> func = new ArrayList<>();
    private ArrayList<String> exame = new ArrayList<>();

    public String retornarTodosExames() {
        examesRealizados.addAll(exameRealizadoBusiness.trazerTodosOsExamesRealizados());
        return SUCCESS;
    }

    public String novo() {
        if (exameRealizadoVo.getCodigoExameRealizado() == null) {
            funcionarios = funcionarioBusiness.trazerTodosOsFuncionarios();
            exames = exameBusiness.trazerTodosOsExames();
            return INPUT;

        } else {
            exameRealizadoVo.setCodigoFuncionario(func.get(0));
            exameRealizadoVo.setCodigoExame(exame.get(0));
            exameRealizadoBusiness.salvarExameRealizado(exameRealizadoVo);
            return REDIRECT;

        }

    }

    public String filtrar() {
        if (filtrar.isNullOpcoesCombo())
            return REDIRECT;

        examesRealizados = exameRealizadoBusiness.filtrarExamesRealizados(filtrar);

        return SUCCESS;
    }
    public String editar() {
        if(func.isEmpty()){
            exameRealizadoVo = exameRealizadoBusiness.buscarExamePor(exameRealizadoVo.getCodigoExameRealizado());
            funcionarios = funcionarioBusiness.trazerTodosOsFuncionarios();
            exames = exameBusiness.trazerTodosOsExames();
            return EDIT;
        }else {
            exameRealizadoBusiness.editarExameRealizado(exameRealizadoVo);
        }
        return REDIRECT;
    }

    public String excluir(){

        exameRealizadoBusiness.excluirExameRealizado(exameRealizadoVo.getDataExameRealizado());
        return REDIRECT;

    }

    public List<ExameRealizadoVo> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(List<ExameRealizadoVo> examesRealizados) {
        this.examesRealizados = examesRealizados;
    }

    public List<OpcoesComboBuscarExames> getListaOpcoesCombo(){
        return Arrays.asList(OpcoesComboBuscarExames.values());
    }

    public ExameVo getExameVo() {
        return exameVo;
    }

    public void setExameVo(ExameVo exameVo) {
        this.exameVo = exameVo;
    }

    public FuncionarioVo getFuncionarioVo() {
        return funcionarioVo;
    }

    public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
        this.funcionarioVo = funcionarioVo;
    }

    public ExameRealizadoFilter getFiltrar() {
        return filtrar;
    }

    public void setFiltrar(ExameRealizadoFilter filtrar) {
        this.filtrar = filtrar;
    }

    public ExameRealizadoVo getExameRealizadoVo() {
        return exameRealizadoVo;
    }

    public void setExameRealizadoVo(ExameRealizadoVo exameRealizadoVo) {
        this.exameRealizadoVo = exameRealizadoVo;
    }

    public List<ExameVo> getExames() {
        return exames;
    }

    public void setExames(List<ExameVo> exames) {
        this.exames = exames;
    }

    public List<FuncionarioVo> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioVo> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public FuncionarioBusiness getFuncionarioBusiness() {
        return funcionarioBusiness;
    }

    public void setFuncionarioBusiness(FuncionarioBusiness funcionarioBusiness) {
        this.funcionarioBusiness = funcionarioBusiness;
    }

    public ExameBusiness getExameBusiness() {
        return exameBusiness;
    }

    public void setExameBusiness(ExameBusiness exameBusiness) {
        this.exameBusiness = exameBusiness;
    }

    public ExameRealizadoBusiness getExameRealizadoBusiness() {
        return exameRealizadoBusiness;
    }

    public void setExameRealizadoBusiness(ExameRealizadoBusiness exameRealizadoBusiness) {
        this.exameRealizadoBusiness = exameRealizadoBusiness;
    }

    public ArrayList<String> getFunc() {
        return func;
    }

    public void setFunc(ArrayList<String> func) {
        this.func = func;
    }

    public ArrayList<String> getExame() {
        return exame;
    }

    public void setExame(ArrayList<String> exame) {
        this.exame = exame;
    }
}
