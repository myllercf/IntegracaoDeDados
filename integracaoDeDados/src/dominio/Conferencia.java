package dominio;

public final class Conferencia extends Artigo{
	private String titulo_anais;
	private String cidade;
	private String pais;
	private static final String tipo = "conferencia";
	
	public Conferencia(String cod_publicacao, String titulo, String mes, String ano, String url, String volume, String pagina_inicial, 
			String pagina_final, String circulacao, String qualis, String titulo_anais, String cidade, String pais){
		this.cod_publicacao = cod_publicacao;
		this.titulo = titulo;
		this.mes = mes;
		this.ano = ano;
		this.url = url;
		this.volume = volume;
		this.pagina_inicial = pagina_inicial;
		this.pagina_final = pagina_final;
		this.circulacao = circulacao;
		this.qualis = qualis;
		this.titulo_anais = titulo_anais;
		this.cidade = cidade;
		this.pais = pais;
	}

	public String getTitulo_anais() {
		return titulo_anais;
	}

	public void setTitulo_anais(String titulo_anais) {
		this.titulo_anais = titulo_anais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getTipo(){
		return tipo;
	}

}
