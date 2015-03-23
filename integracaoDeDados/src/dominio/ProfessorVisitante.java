package dominio;

public final class ProfessorVisitante extends Pessoa{
	private String universidade;
	private String departamento;
	private static final String tipo = "visitante";
	
	public ProfessorVisitante(String CPF, String RG, String data_nascimento, String naturalidade, String nacionalidade, String usuario, 
			String senha, String perfil, String email, String url, 
			String universidade, String departamento){
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
		this.universidade = universidade;
		this.departamento = departamento;
	}

	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getTipo(){
		return tipo;
	}

}