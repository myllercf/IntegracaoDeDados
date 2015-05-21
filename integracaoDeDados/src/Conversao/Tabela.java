package Conversao;

import java.util.List;

public class Tabela {
	String nome;
	String primaryKey;
	List<String> atributos;
	List<String> foringKey;
	List<String> referencias;
	
	public Tabela(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<String> atributos) {
		this.atributos = atributos;
	}

	public List<String> getForingKey() {
		return foringKey;
	}

	public void setForingKey(List<String> foringKey) {
		this.foringKey = foringKey;
	}

	public List<String> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<String> referencias) {
		this.referencias = referencias;
	}

}
