package br.com.soc.sistema.vo;

public class ExameVo {
	private String codigoExame;
	private String nome;	
	
	public ExameVo() {}
		
	public ExameVo(String codigoExame, String nome) {
		this.codigoExame = codigoExame;
		this.nome = nome;
	}

	public String getCodigoExame() {
		return codigoExame;
	}
	public void setCodigoExame(String codigoExame) {
		this.codigoExame = codigoExame;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "ExameVo [codigoExame=" + codigoExame + ", nome=" + nome + "]";
	}
}
