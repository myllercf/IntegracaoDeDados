package dominio;

public abstract class Pessoa {
	protected String CPF;
	protected String RG;
	protected String data_nascimento;
	protected String naturalidade;
	protected String nacionalidade;
	protected String usuario;
	protected String senha;
	protected String perfil;
	protected String email;
	protected String url;
	
	/*protected Pessoa(String CPF, String RG, String data_nascimento, String naturalidade, String nacionalidade, String usuario, 
			String senha, String perfil, String email, String url){
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
	}*/

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}