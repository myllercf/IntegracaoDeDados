package Conversao;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EsquemaEntrada entrada = new EsquemaEntrada();
		StringBuffer texto = new StringBuffer(""
				+ " create table T_PUBLICACAO ( COD_PUBLICACAO serial, TITULO text not null, MES character ( 2 ) not null,"
				+ "ANO character ( 4 ) not null, URL text null, primary key (COD_PUBLICACAO) );"
				+ " create table T_RELATORIO_TECNICO ("
				+ "	NUMERO character ( 6 ), COD_PUBLICACAO integer not null, NRO PAGINAS integer not null,"
				+ "primary key (NUMERO), foreign key (COD_PUBLICACAO) references T_PUBLICACAO (COD_PUBLICACAO) on delete cascade);");
		
		List<Tabela> tabs = entrada.obterTabelas2(texto);
		for(int i=0; i <= tabs.size(); i++){
			System.out.println(tabs.get(i).getNome());
		}
		
		/*System.out.println(texto.substring( 12+texto.indexOf("create table"), texto.indexOf("(") ).replaceAll(" ","") );
		texto.delete(0, texto.indexOf("("));
		String x = texto.substring( texto.indexOf("(")+1, texto.indexOf(" ") );
		System.out.println("o primeiro atributo eh: " + x);
		*/
		/*System.out.println(texto);
		texto.delete(0, texto.indexOf("(")+1);
		System.out.println(texto);
		texto.delete(0, texto.indexOf(",")+1);
		System.out.println(texto);
		*/
		/*
		System.out.println(texto.substring(texto.indexOf("create table")));
		texto.delete(0, texto.indexOf("create table")+13);
		System.out.println(texto.substring(texto.indexOf("create table")));
		texto.delete(0, texto.indexOf("create table")+13);
		System.out.println(texto.substring(texto.indexOf("create table")));
		texto.delete(0, texto.indexOf("create table")+13);
		System.out.println(texto.substring(texto.indexOf("create table")));
		texto.delete(0, texto.indexOf("create table")+13);
		System.out.println(texto.substring(texto.indexOf("create table")));
		//System.out.println(texto.indexOf("("));
		/*texto.deleteCharAt(texto.indexOf("("));
		System.out.println(texto.indexOf("("));
		System.out.println("--");
		System.out.println(texto.charAt(0));
		if(texto.charAt(0) == ' ' || texto.charAt(0) == '\n' || texto.charAt(0) == '\t'){
			System.out.println("entrou");
			texto.deleteCharAt(texto.indexOf("("));
		}*/
		//System.out.println(texto.substring(texto.indexOf("(")));
		/*while(texto.charAt(0) == ' ' || texto.charAt(0) == '\n' || texto.charAt(0) == '\t'){
			System.out.println(texto);
			texto.deleteCharAt(0);
		}*/
		
		
		//System.out.println(entrada.obterPrimeiraTabela(texto).getNome());
		/*System.out.println("teste do obter primeira tabela");
		List<String> lista = new ArrayList();
		System.out.println(entrada.obterPrimeiraTabela(texto).getNome());
		lista = entrada.obterPrimeiraTabela(texto).getAtributos();
		for(int i=0; i<=lista.size(); i++){
			System.out.println("for");
			System.out.println(lista.get(i));
		}
		System.out.println(entrada.obterPrimeiraTabela(texto).getAtributos().get(0));
		*/
		///System.out.println(texto.indexOf("primary"));
		//System.out.println(texto.substring(19, 15));
		/*System.out.println(texto.length());
		for(int i=0; i<texto.length(); i++){
			System.out.println(i);
			texto.deleteCharAt(0);
			System.out.println(texto);
			int pos = texto.indexOf("substr");
			if (pos < 0){
				System.out.println("serve!");
			}
		}*/
		/*System.out.println("indice inicial: " + texto.indexOf("create table") + texto.indexOf("("));
		System.out.println("indice final: " + texto.indexOf("("));
		System.out.println(texto.substring( texto.indexOf("create table")+13, texto.indexOf("(") ).replaceAll(" ","") );
		*/
		//for (int i=0; i<2; i++){
		/*System.out.println(texto.substring(texto.indexOf("(")+1, texto.indexOf(")")));
		texto.delete(0, texto.indexOf(")")+1);
		System.out.println(texto);
			System.out.println(texto.substring( texto.indexOf("create table")+12, texto.indexOf("(") ).replaceAll(" ","") );
			texto.delete(0, texto.indexOf("(")+1);
			System.out.println(texto);
			System.out.println(texto.indexOf("create table")+12);
			System.out.println(texto.indexOf("(") );
		//*/
		//System.out.println(texto.substring(0, texto.indexOf("(")).replaceAll(" ","").equals("primary"));
		/*List<Tabela> tabs = entrada.obterTabelas(texto);
		for(Tabela tab: tabs){
			System.out.println(tab.getNome());
			for(String atributo: tab.getAtributos()){
				System.out.println(atributo);
			}
		}*/
		
		/*List<Tabela> tabelas = new ArrayList();
		//executando para cada tabela
		int condicao = texto.indexOf("create table");
		int p=0;
		while(condicao >= 0){
			p++;
			
			//System.out.println(condicao);
			List<String> atributos = new ArrayList();
			Tabela tabela = new Tabela();	
			
			System.out.println(texto);
			//pegando o nome da tabela
			tabela.setNome(texto.substring( texto.indexOf("create table")+12, texto.indexOf("(") ).replaceAll(" ","") );
			texto.delete(0, texto.indexOf("(")+1);
			
			//pegando atributos
			while ( ( (texto.indexOf("primary") > 0) && (texto.indexOf("primary") < texto.indexOf(")")) ) 
					|| ( (texto.indexOf("foreing") > 0) && (texto.indexOf("foreing") < texto.indexOf(")")) ) ){
				
				//deletando espacos em branco
				while(texto.charAt(0) == ' ' || texto.charAt(0) == '\n' || texto.charAt(0) == '\t'){
					texto.deleteCharAt(0);
				}
				
				//checar chave d novo
				if(texto.indexOf("primary") == 0 || texto.indexOf("foreing") == 0){
					break;
				}
				atributos.add(texto.substring( 0, texto.indexOf(" ") ) );
				
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
		*/
		//System.out.println(tabelas);
	}

}
