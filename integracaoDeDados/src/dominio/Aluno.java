package dominio;

public abstract class Aluno extends Pessoa{
	protected String RA;
	protected String cod_situacao;
	protected String info_complementares;
	protected String semestre_ingresso;
	protected String ano_ingresso;
	protected String data_ingresso;

	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}

	public String getCod_situacao() {
		return cod_situacao;
	}

	public void setCod_situacao(String cod_situacao) {
		this.cod_situacao = cod_situacao;
	}

	public String getInfo_complementares() {
		return info_complementares;
	}

	public void setInfo_complementares(String info_complementares) {
		this.info_complementares = info_complementares;
	}
	
	public String getSemestre_ingresso() {
		return semestre_ingresso;
	}

	public void setSemestre_ingresso(String semestre_ingresso) {
		this.semestre_ingresso = semestre_ingresso;
	}

	public String getAno_ingresso() {
		return ano_ingresso;
	}

	public void setAno_ingresso(String ano_ingresso) {
		this.ano_ingresso = ano_ingresso;
	}

	public String getData_ingresso() {
		return data_ingresso;
	}

	public void setData_ingresso(String data_ingresso) {
		this.data_ingresso = data_ingresso;
	}
	

}