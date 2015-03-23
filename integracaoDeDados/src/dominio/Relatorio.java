package dominio;

public final class Relatorio extends Publicacao{
	private String numero;
	private String nro_paginas;
	private static final String tipo = "relatorio";
	
	public Relatorio(String cod_publicacao, String titulo, String mes, String ano, String url, String numero, String nro_paginas){
		this.cod_publicacao = cod_publicacao;
		this.titulo = titulo;
		this.mes = mes;
		this.ano =ano;
		this.url = url;
		this.numero = numero;
		this.nro_paginas = nro_paginas;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNro_paginas() {
		return nro_paginas;
	}
	
	public void setNro_paginas(String nro_paginas) {
		this.nro_paginas = nro_paginas;
	}
	
	public String getTipo(){
		return tipo;
	}

}