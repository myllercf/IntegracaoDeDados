package dominio;

public final class Doutorando extends Aluno{
	private static final String tipo = "doutorando";
	
	public Doutorando(String CPF, String RG, String data_nascimento, String naturalidade, String nacionalidade, String usuario, 
			String senha, String perfil, String email, String url, 
			String RA, String cod_situacao, String info_complementares, 
			String semestre_ingresso, String ano_ingresso, String data_ingresso){
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
		this.RA = RA;
		this.cod_situacao = cod_situacao;
		this.info_complementares = info_complementares;
		this.semestre_ingresso = semestre_ingresso;
		this.ano_ingresso =ano_ingresso;
		this.data_ingresso = data_ingresso;
	}
	
	public String getTipo(){
		return tipo;
	}

}