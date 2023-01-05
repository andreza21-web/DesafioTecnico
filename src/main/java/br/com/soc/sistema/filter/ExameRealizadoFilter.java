package br.com.soc.sistema.filter;

import br.com.soc.sistema.infra.OpcoesComboBuscarExames;

public class ExameRealizadoFilter {

    private OpcoesComboBuscarExames opcoesCombo;
    private String valorBusca;

    public String getValorBusca() {
        return valorBusca;
    }

    public ExameRealizadoFilter setValorBusca(String valorBusca) {
        this.valorBusca = valorBusca;
        return this;
    }

    public OpcoesComboBuscarExames getOpcoesCombo() {
        return opcoesCombo;
    }

    public ExameRealizadoFilter setOpcoesCombo(String codigo) {
        this.opcoesCombo = OpcoesComboBuscarExames.buscarPor(codigo);
        return this;
    }

    public boolean isNullOpcoesCombo() {
        return this.getOpcoesCombo() == null;
    }

    public static ExameFilter builder() {
        return new ExameFilter();
    }
}
