package dominio;

public final class Livro extends Publicacao{
	private String ISBN;
	private String editora;
	private String edicao;
	private static final String tipo = "livro";
	
	public Livro(String cod_publicacao, String titulo, String mes, String ano, String url, String ISBN, String editora, String edicao){
		this.cod_publicacao = cod_publicacao;
		this.titulo = titulo;
		this.mes = mes;
		this.ano =ano;
		this.url = url;
		this.ISBN = ISBN;
		this.editora = editora;
		this.edicao = edicao;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	
	public String getTipo(){
		return tipo;
	}

}