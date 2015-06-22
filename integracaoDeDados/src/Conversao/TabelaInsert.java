package Conversao;

import java.util.List;

public class TabelaInsert {
	private String tabela;
	private List<String> primaryKey;
	private List<String> atributos;
	private List<String> foreignKey;
	private boolean persistido;
	
	public TabelaInsert(){
		persistido = false;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public List<String> getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(List<String> primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<String> atributos) {
		this.atributos = atributos;
	}

	public List<String> getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(List<String> foreignKey) {
		this.foreignKey = foreignKey;
	}

	public boolean isPersistido() {
		return persistido;
	}

	public void setPersistido(boolean persistido) {
		this.persistido = persistido;
	}

}
