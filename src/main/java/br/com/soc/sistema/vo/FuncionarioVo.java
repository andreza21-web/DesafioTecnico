package br.com.soc.sistema.vo;

public class FuncionarioVo {

    private String codigoFuncionario;
    private String nome;

    public FuncionarioVo() {}

    public FuncionarioVo(String codigoFuncionario, String nome) {
        this.codigoFuncionario = codigoFuncionario;
        this.nome = nome;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }
    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "FuncionarioVo [codigoFuncionario=" + codigoFuncionario + ", nome=" + nome + "]";
    }
}
