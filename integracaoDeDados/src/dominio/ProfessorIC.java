package dominio;

public final class ProfessorIC extends Pessoa{
	private String info_complementares;
	private String matricula;
	private String tipo_dedicacao;
	private String sala;
	private static final String tipo = "IC";
	
	public ProfessorIC(String CPF, String RG, String data_nascimento, String naturalidade, String nacionalidade, String usuario, 
			String senha, String perfil, String email, String url, 
			String info_complementares, String matricula, String tipo_dedicacao, String sala){
		this.CPF = CPF;
		this.RG = RG;
		this.data_nascimento = data_nascimento;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.usuario = usuario;
		this.senha = senha;
		this.perfil = perfil;
		this.email = email;
		this.url = url;
		this.info_complementares = info_complementares;
		this.matricula = matricula;
		this.tipo_dedicacao = tipo_dedicacao;
		this.sala = sala;
	}

	public String getInfo_complementares() {
		return info_complementares;
	}

	public void setInfo_complementares(String info_complementares) {
		this.info_complementares = info_complementares;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipo_dedicacao() {
		return tipo_dedicacao;
	}

	public void setTipo_dedicacao(String tipo_dedicacao) {
		this.tipo_dedicacao = tipo_dedicacao;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public String getTipo(){
		return tipo;
	}

}