package dominio;

public final class Capitulo extends Publicacao{
	private String ISBN_livro;
	private String titulo_livro;
	private String editora_livro;
	private String edicao_livro;
	private static final String tipo = "capitulo";
	
	public Capitulo(String cod_publicacao, String titulo, String mes, String ano, String url, String ISBN_livro, String titulo_livro, String editora_livro, String edicao_livro){
		this.cod_publicacao = cod_publicacao;
 		this.titulo = titulo;
 		this.mes = mes;
 		this.ano = ano;
 		this.url = url;
		this.ISBN_livro = ISBN_livro;
		this.titulo_livro = titulo_livro;
		this.editora_livro = editora_livro;
		this.edicao_livro = edicao_livro;
	}

	public String getISBN_livro() {
		return ISBN_livro;
	}

	public void setISBN_livro(String iSBN_livro) {
		ISBN_livro = iSBN_livro;
	}

	public String getTitulo_livro() {
		return titulo_livro;
	}

	public void setTitulo_livro(String titulo_livro) {
		this.titulo_livro = titulo_livro;
	}

	public String getEditora_livro() {
		return editora_livro;
	}

	public void setEditora_livro(String editora_livro) {
		this.editora_livro = editora_livro;
	}

	public String getEdicao_livro() {
		return edicao_livro;
	}

	public void setEdicao_livro(String edicao_livro) {
		this.edicao_livro = edicao_livro;
	}
	
	public String getTipo(){
		return tipo;
	}

}