package Conversao;

import java.util.ArrayList;
import java.util.List;

public class TesteTabMongo {

	public static void main(String[] args) {
		TabelasParaMongo tabMong = new TabelasParaMongo();
		
		//tabela 1
		List<String> camp1 = new ArrayList();
		camp1.add("titulo");
		camp1.add("mes");
		camp1.add("ano");
		camp1.add("url");
		Tabela tab1 = new Tabela(); 
		tab1.setNome("T_PUBLICACAO");
		tab1.setAtributos(camp1);
		tab1.setPrimaryKey("cod_publicacao");
		
		//tabela 2
		List<String> camp2 = new ArrayList();
		camp2.add("nro_paginas");		
		List<String> foreign2 = new ArrayList();
		foreign2.add("cod_publicacao");
		List<String> refs2 = new ArrayList();
		refs2.add("T_PUBLICACAO");		
		Tabela tab2 = new Tabela(); 
		tab2.setNome("T_RELATORIO_TECNICO");
		tab2.setAtributos(camp2);
		tab2.setPrimaryKey("numero");
		tab2.setForingKey(foreign2);
		tab2.setReferencias(refs2);
		
		//tabela 3
		List<String> camp3 = new ArrayList();
		camp3.add("volume");
		camp3.add("pagina_inicial");
		camp3.add("pagina_final");
		camp3.add("circulacao");
		camp3.add("qualis");
		List<String> foreign3 = new ArrayList();
		foreign3.add("cod_publicacao");
		List<String> refs3 = new ArrayList();
		refs3.add("T_PUBLICACAO");		
		Tabela tab3 = new Tabela(); 
		tab3.setNome("T_ARTIGO");
		tab3.setAtributos(camp3);
		tab3.setPrimaryKey("cod_publicacao");
		tab3.setForingKey(foreign3);
		tab3.setReferencias(refs3);
		
		//tabela 4
		List<String> camp4 = new ArrayList();
		camp4.add("titulo_anais");
		camp4.add("cidade");
		camp4.add("pais");
		List<String> foreign4 = new ArrayList();
		foreign4.add("cod_publicacao");
		List<String> refs4 = new ArrayList();
		refs4.add("T_ARTIGO");		
		Tabela tab4 = new Tabela(); 
		tab4.setNome("T_ARTIGO_CONFERENCIA");
		tab4.setAtributos(camp3);
		tab4.setPrimaryKey("cod_publicacao");
		tab4.setForingKey(foreign3);
		tab4.setReferencias(refs4);
		
		List<Tabela> DBr = new ArrayList();
		DBr.add(tab1);
		DBr.add(tab2);
		DBr.add(tab3);
		DBr.add(tab4);
		
		System.out.println(tab2.getReferencias().size());
		for(Tabela t: tabMong.tabelasFinais(DBr)){
			System.out.println("resultados:");
			System.out.println(t.getNome());
		}

	}

}
