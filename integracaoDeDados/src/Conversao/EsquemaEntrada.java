package Conversao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EsquemaEntrada {
	
	public StringBuffer obterEsquema(String sql){
		StringBuffer esquema = new StringBuffer();
		File file = new File(sql);
		
		try{
			FileReader reader = new FileReader(file);
			BufferedReader input = new BufferedReader(reader);
			String linha;
			
			while (input.ready()) {
				linha = input.readLine();
				esquema.append(linha);
			}
			
		} catch(IOException e){
			System.out.println(e);
		}
		
		return esquema;
	}
	
	public List<Tabela> obterTabelas(StringBuffer texto){
		List<Tabela> tabelas = new ArrayList();
		//executando para cada tabela
		int condicao = texto.indexOf("create table");
		int p=0;
		while(condicao >= 0){
			p++;
			//System.out.println(condicao);
			List<String> atributos = new ArrayList();
			Tabela tabela = new Tabela();			
			//pegando o nome da tabela
			System.out.println(texto);
			tabela.setNome(texto.substring( texto.indexOf("create table")+12, texto.indexOf("(") ).replaceAll(" ","") );
			texto.delete(0, texto.indexOf("(")+1);
			//System.out.println(texto);
			//pegando atributos
			while ( ( (texto.indexOf("primary") > 0) && (texto.indexOf("primary") < texto.indexOf(")")) ) 
					|| ( (texto.indexOf("foreing") > 0) && (texto.indexOf("foreing") < texto.indexOf(")")) ) ){
				//deletando espacos em branco
				while(texto.charAt(0) == ' ' || texto.charAt(0) == '\n' || texto.charAt(0) == '\t'){
					texto.deleteCharAt(0);
				}
				System.out.println(texto);
				//checar chave d novo
				if(texto.indexOf("primary") == 0 || texto.indexOf("foreing") == 0){
					break;
				}
				atributos.add(texto.substring( 0, texto.indexOf(" ") ) );
				//System.out.println("sendo apagado:"+texto.substring(0, texto.indexOf(",")+1));
				texto.delete(0, texto.indexOf(",")+1);
			}
			
			while(texto.charAt(0) == ' ' || texto.charAt(0) == '\n' || texto.charAt(0) == '\t'){
				texto.deleteCharAt(0);
			}
			
			//pegando chave primaria
			if(texto.substring(0, texto.indexOf("(")).replaceAll(" ","").equals("primarykey")){
				tabela.setPrimaryKey(texto.substring(texto.indexOf("(")+1, texto.indexOf(")")));
				texto.delete(0, texto.indexOf(")")+1);
			}
			tabela.setAtributos(atributos);
			tabelas.add(tabela);
		}
		System.out.println("foi aqui");
		return tabelas;
	}
	
	public List<Tabela> obterTabelas2 (StringBuffer texto){
		List<Tabela> tabelas = new ArrayList();
		
		while( texto.indexOf("create table") > 0){
			Tabela tab = new Tabela();
			tab.setNome(texto.substring(texto.indexOf("create table")+12, texto.indexOf("(")).replaceAll(" ", ""));
			System.out.println(texto.substring(texto.indexOf("create table")+12, texto.indexOf("(")).replaceAll(" ", ""));
		}
		//tabelas.add(tab);
		return tabelas;
	}
	
	/*public Tabela obterPrimeiraTabela(StringBuffer texto){
		Tabela t = new Tabela();
		List<String> atribs = new ArrayList();
		
		t.setNome(texto.substring(texto.indexOf("create table ") + 13, texto.indexOf("(")));
		texto.delete(0, texto.indexOf("(")+1);
		
		while(texto.charAt(0) == ' ' || texto.charAt(0) == '\n' || texto.charAt(0) == '\t'){
			texto.deleteCharAt(0);
		}
		atribs.add(texto.substring(0, texto.indexOf(" ")));
		t.setAtributos(atribs);
		return t;
	}*/

}
