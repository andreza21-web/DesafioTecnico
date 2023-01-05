package br.com.soc.sistema.vo;

public class ExameRealizadoVo {

    private String codigoExameRealizado;
    private String codigoFuncionario;
    private String codigoExame;
    private String nomeExame;
    private String nomeFuncionario;
    private String dataInicial;
    private String dataFinal;
    private String dataExameRealizado;

    public ExameRealizadoVo() {
    }

    public ExameRealizadoVo(String codigoExameRealizado, String codigoFuncionario, String codigoExame, String nomeExame, String nomeFuncionario, String dataInicial, String dataFinal, String dataExameRealizado) {
        this.codigoExameRealizado = codigoExameRealizado;
        this.codigoFuncionario = codigoFuncionario;
        this.codigoExame = codigoExame;
        this.nomeExame = nomeExame;
        this.nomeFuncionario = nomeFuncionario;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.dataExameRealizado = dataExameRealizado;
    }

    public String getCodigoExameRealizado() {
        return codigoExameRealizado;
    }

    public void setCodigoExameRealizado(String codigoExameRealizado) {
        this.codigoExameRealizado = codigoExameRealizado;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCodigoExame() {
        return codigoExame;
    }

    public void setCodigoExame(String codigoExame) {
        this.codigoExame = codigoExame;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDataExameRealizado() {
        return dataExameRealizado;
    }

    public void setDataExameRealizado(String dataExameRealizado) {
        this.dataExameRealizado = dataExameRealizado;
    }

    @Override
    public String toString() {
        return "ExameRealizadoVo{" +
                "codigoExameRealizado='" + codigoExameRealizado + '\'' +
                ", codigoFuncionario='" + codigoFuncionario + '\'' +
                ", codigoExame='" + codigoExame + '\'' +
                ", nomeExame='" + nomeExame + '\'' +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", dataExameRealizado='" + dataExameRealizado + '\'' +
                '}';
    }
}
