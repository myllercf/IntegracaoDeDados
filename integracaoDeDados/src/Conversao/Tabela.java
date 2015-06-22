package Conversao;

import java.util.ArrayList;
import java.util.List;

public class Tabela {
	private String nome;
	private List<String> campos;
	private List<String> primaryKey;
	private List<String> foreignKey;
	private List<String> referencias;
	private String classificacao;
	
	public Tabela(){
		campos = new ArrayList<String>();
		primaryKey = new ArrayList<String>();
		foreignKey = new ArrayList<String>();
		referencias = new ArrayList<String>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getCampos() {
		return campos;
	}

	public void setCampos(List<String> campos) {
		this.campos = campos;
	}

	public List<String> getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(List<String> primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<String> getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(List<String> foreignKey) {
		this.foreignKey = foreignKey;
	}

	public List<String> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<String> referencias) {
		this.referencias = referencias;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

}
