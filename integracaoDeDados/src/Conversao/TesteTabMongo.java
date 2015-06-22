package Conversao;

import java.util.ArrayList;
import java.util.List;

public class TesteTabMongo {

	public static void main(String[] args) {
		
		//PUBLICACAO
		List<String> camp1 = new ArrayList();
		camp1.add("titulo");
		camp1.add("mes");
		camp1.add("ano");
		camp1.add("url");
		List<String> primary1 = new ArrayList();
		primary1.add("cod_publicacao");
		Tabela tab1 = new Tabela(); 
		tab1.setNome("T_PUBLICACAO");
		tab1.setCampos(camp1);
		tab1.setPrimaryKey(primary1);
		tab1.setClassificacao("principal");
		
		//RELATORIO_TECNICO
		List<String> camp2 = new ArrayList();
		camp2.add("nro_paginas");
		List<String> primary2 = new ArrayList();
		primary2.add("numero");
		List<String> foreign2 = new ArrayList();
		foreign2.add("cod_publicacao");
		List<String> refs2 = new ArrayList();
		refs2.add("T_PUBLICACAO");		
		Tabela tab2 = new Tabela(); 
		tab2.setNome("T_RELATORIO_TECNICO");
		tab2.setCampos(camp2);
		tab2.setPrimaryKey(primary2);
		tab2.setForeignKey(foreign2);
		tab2.setReferencias(refs2);
		
		//ARTIGO
		List<String> camp3 = new ArrayList();
		camp3.add("volume");
		camp3.add("pagina_inicial");
		camp3.add("pagina_final");
		camp3.add("circulacao");
		camp3.add("qualis");
		List<String> primary3 = new ArrayList();
		primary3.add("cod_publicacao");
		List<String> foreign3 = new ArrayList();
		foreign3.add("cod_publicacao");
		List<String> refs3 = new ArrayList();
		refs3.add("T_PUBLICACAO");		
		Tabela tab3 = new Tabela(); 
		tab3.setNome("T_ARTIGO");
		tab3.setPrimaryKey(primary3);
		tab3.setCampos(camp3);
		tab3.setForeignKey(foreign3);
		tab3.setReferencias(refs3);
		
		//ARTIGO_CONFERENCIA
		List<String> camp4 = new ArrayList();
		camp4.add("titulo_anais");
		camp4.add("cidade");
		camp4.add("pais");
		List<String> primary4 = new ArrayList();
		primary4.add("cod_publicacao");
		List<String> foreign4 = new ArrayList();
		foreign4.add("cod_publicacao");
		List<String> refs4 = new ArrayList();
		refs4.add("T_ARTIGO");		
		Tabela tab4 = new Tabela(); 
		tab4.setNome("T_ARTIGO_CONFERENCIA");
		tab4.setCampos(camp4);
		tab4.setPrimaryKey(primary4);
		tab4.setForeignKey(foreign4);
		tab4.setReferencias(refs4);
		
		List<Tabela> DBr = new ArrayList();
		DBr.add(tab1);
		DBr.add(tab2);
		DBr.add(tab3);
		DBr.add(tab4);
		
		
		//inserts Publicacao
				List<String> campPub1 = new ArrayList();
				campPub1.add("Object Database systems: a survey");
				campPub1.add("02");
				campPub1.add("2002");
				campPub1.add(null);
				List<String> prima1 = new ArrayList();
				prima1.add("001");
				TabelaInsert ins1 = new TabelaInsert();
				ins1.setTabela("T_PUBLICACAO");
				ins1.setAtributos(campPub1);
				ins1.setPrimaryKey(prima1);
				
				List<String> campPub2 = new ArrayList();
				campPub2.add("Protocolos de roteamento para redes ad hoc");
				campPub2.add("05");
				campPub2.add("2000");
				campPub2.add(null);
				List<String> prima2 = new ArrayList();
				prima2.add("002");
				TabelaInsert ins2 = new TabelaInsert();
				ins2.setTabela("T_PUBLICACAO");
				ins2.setAtributos(campPub2);
				ins2.setPrimaryKey(prima2);
				
				//insert T_RELATORIO_TECNICO
				List<String> rela = new ArrayList();
				rela.add("30");
				List<String> rprima1 = new ArrayList();
				rprima1.add("TRIC09");
				List<String> fore1 = new ArrayList();
				fore1.add("002");
				TabelaInsert ins3 = new TabelaInsert();
				ins3.setTabela("T_RELATORIO_TECNICO");
				ins3.setAtributos(rela);
				ins3.setPrimaryKey(rprima1);
				ins3.setForeignKey(fore1);
				
				//artigo
				List<String> capart = new ArrayList();
				capart.add("1");
				capart.add("30");
				capart.add("38");
				capart.add("I");
				capart.add("A");
				List<String> primaart = new ArrayList();
				primaart.add("001");
				List<String> fore4 = new ArrayList();
				fore4.add("001");
				TabelaInsert ins4 = new TabelaInsert();
				ins4.setTabela("T_ARTIGO");
				ins4.setAtributos(capart);
				ins4.setPrimaryKey(primaart);
				ins4.setForeignKey(fore4);
				
				//insert T_ARTIGO_CONFERENCIA
				List<String> conf1 = new ArrayList();
				conf1.add("Internation Conference on Database Sysstems");
				conf1.add("Berlim");
				conf1.add("Alemanha");
				List<String> primaconf = new ArrayList();
				primaconf.add("001");
				List<String> fore2 = new ArrayList();
				fore2.add("001");
				TabelaInsert ins5 = new TabelaInsert();
				ins5.setTabela("T_ARTIGO_CONFERENCIA");
				ins5.setAtributos(conf1);
				ins5.setPrimaryKey(primaconf);
				ins5.setForeignKey(fore2);
				
				List<TabelaInsert> inserts = new ArrayList();
				inserts.add(ins1);
				inserts.add(ins2);
				inserts.add(ins3);
				inserts.add(ins4);
				inserts.add(ins5);
				
				
				//System.out.println(tab2.getReferencias().size());
				/*for(Tabela t: tabMong.tabelasFinais(DBr)){
					System.out.println(t.getNome());
				}*/
				
				TabelasParaMongo tabMong = new TabelasParaMongo(DBr, inserts);
				/*for(Tabela t: tabMong.tabelasFinais()){
					System.out.println(t.getNome());
				}*/
				
				//System.out.println("criar documentos");
				//tabMong.criarDocumentos();
				System.out.println("entrando no metodo...");
				for(TabelaInsert t: inserts){
					tabMong.criarDocumento(t);
				}
				//tabMong.criarDocumento(ins5);
				
				/*String s1 = "myller";
				String s2 = "claudino";
				StringBuffer s = new StringBuffer().append(s1).append(".").append(s2);
				String sx = s.toString();
				System.out.println(sx);*/
				
				//System.out.println(tabMong.acharTabelaPai("T_ARTIGO").getNome());
				//System.out.println(tabMong.acharInsert(tab3, ins4).getTabela()+", "+tabMong.acharInsert(tab4, ins5).getPrimaryKey().get(0));

	}

}