package dominio;

public abstract class Artigo extends Publicacao{
	protected String volume;
	protected String pagina_inicial;
	protected String pagina_final;
	protected String circulacao;
	protected String qualis;

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPagina_inicial() {
		return pagina_inicial;
	}

	public void setPagina_inicial(String pagina_inicial) {
		this.pagina_inicial = pagina_inicial;
	}

	public String getPagina_final() {
		return pagina_final;
	}

	public void setPagina_final(String pagina_final) {
		this.pagina_final = pagina_final;
	}

	public String getCirculacao() {
		return circulacao;
	}

	public void setCirculacao(String circulacao) {
		this.circulacao = circulacao;
	}

	public String getQualis() {
		return qualis;
	}

	public void setQualis(String qualis) {
		this.qualis = qualis;
	}

}