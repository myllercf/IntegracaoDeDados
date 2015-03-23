package dominio;

public abstract class Publicacao {
	protected String cod_publicacao;
	protected String titulo;
	protected String mes;
	protected String ano;
	protected String url;
 	
 	/*protected Publicacao(String cod_publicacao, String titulo, String mes, String ano, String url){
 		this.cod_publicacao = cod_publicacao;
 		this.titulo = titulo;
 		this.mes = mes;
 		this.ano = ano;
 		this.url = url;
 	}*/
 	
 	public String getCod_publicacao() {
		return cod_publicacao;
	}
 	
 	public void setCod_publicacao(String cod_publicacao) {
		this.cod_publicacao = cod_publicacao;
	}
 	
 	public String getTitulo() {
		return titulo;
	}
 	
 	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
 	
 	public String getMes() {
		return mes;
	}
 	
 	public void setMes(String mes) {
		this.mes = mes;
	}
 	
 	public String getAno() {
		return ano;
	}
 	
 	public void setAno(String ano) {
		this.ano = ano;
	}
 	
 	public String getUrl() {
		return url;
	}
 	
 	public void setUrl(String url) {
		this.url = url;
	}

}