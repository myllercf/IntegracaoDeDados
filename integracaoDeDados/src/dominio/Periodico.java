package dominio;

public final class Periodico extends Artigo{
	private String nome_periodico;
	private String nro_edicao;
	private static final String tipo = "periodico";
	//private String tipo;
	
	
	public Periodico(String cod_publicacao, String titulo, String mes, String ano, String url, 
			String volume, String pagina_inicial, String pagina_final, String circulacao, String qualis, 
			String nome_periodico, String nro_edicao){
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
		this.nome_periodico = nome_periodico;
		this.nro_edicao = nro_edicao;
		//this.tipo = "periodico";
	}
	
	public Periodico(){
		
	}

	public String getNome_periodico() {
		return nome_periodico;
	}

	public void setNome_periodico(String nome_periodico) {
		this.nome_periodico = nome_periodico;
	}

	public String getNro_edicao() {
		return nro_edicao;
	}

	public void setNro_edicao(String nro_edicao) {
		this.nro_edicao = nro_edicao;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	/*public void setTipo(String tipo){
		this.tipo = tipo;
	}*/

}