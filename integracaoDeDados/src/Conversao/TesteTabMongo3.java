package Conversao;

import java.util.ArrayList;
import java.util.List;

public class TesteTabMongo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// exemplo
		List<String> camp = new ArrayList();
		camp.add("");
		List<String> prima = new ArrayList();
		prima.add("");
		List<String> fore = new ArrayList();
		fore.add("");
		List<String> refe = new ArrayList();
		refe.add("");
		Tabela tab = new Tabela();
		tab.setCampos(camp);
		tab.setPrimaryKey(prima);
		tab.setForeignKey(fore);
		tab.setReferencias(refe);
		tab.setNome("");

		// PUBLICACAO
		List<String> camp1x = new ArrayList();
		camp1x.add("titulo");
		camp1x.add("mes");
		camp1x.add("ano");
		camp1x.add("url");
		List<String> primary1x = new ArrayList();
		primary1x.add("cod_publicacao");
		Tabela tab1x = new Tabela();
		tab1x.setNome("T_PUBLICACAO");
		tab1x.setCampos(camp1x);
		tab1x.setPrimaryKey(primary1x);
		tab1x.setClassificacao("principal");

		// RELATORIO_TECNICO
		List<String> camp2x = new ArrayList();
		camp2x.add("nro_paginas");
		List<String> primary2x = new ArrayList();
		primary2x.add("numero");
		List<String> foreign2x = new ArrayList();
		foreign2x.add("cod_publicacao");
		List<String> refs2x = new ArrayList();
		refs2x.add("T_PUBLICACAO");
		Tabela tab2x = new Tabela();
		tab2x.setNome("T_RELATORIO_TECNICO");
		tab2x.setCampos(camp2x);
		tab2x.setPrimaryKey(primary2x);
		tab2x.setForeignKey(foreign2x);
		tab2x.setReferencias(refs2x);
		tab2x.setClassificacao("subclasse");

		// ARTIGO
		List<String> camp3x = new ArrayList();
		camp3x.add("volume");
		camp3x.add("pagina_inicial");
		camp3x.add("pagina_final");
		camp3x.add("circulacao");
		camp3x.add("qualis");
		List<String> primary3x = new ArrayList();
		primary3x.add("cod_publicacao");
		List<String> foreign3x = new ArrayList();
		foreign3x.add("cod_publicacao");
		List<String> refs3x = new ArrayList();
		refs3x.add("T_PUBLICACAO");
		Tabela tab3x = new Tabela();
		tab3x.setNome("T_ARTIGO");
		tab3x.setPrimaryKey(primary3x);
		tab3x.setCampos(camp3x);
		tab3x.setForeignKey(foreign3x);
		tab3x.setReferencias(refs3x);
		tab3x.setClassificacao("subclasse");

		// ARTIGO_CONFERENCIA
		List<String> camp4x = new ArrayList();
		camp4x.add("titulo_anais");
		camp4x.add("cidade");
		camp4x.add("pais");
		List<String> primary4x = new ArrayList();
		primary4x.add("cod_publicacao");
		List<String> foreign4x = new ArrayList();
		foreign4x.add("cod_publicacao");
		List<String> refs4x = new ArrayList();
		refs4x.add("T_ARTIGO");
		Tabela tab4x = new Tabela();
		tab4x.setNome("T_ARTIGO_CONFERENCIA");
		tab4x.setCampos(camp4x);
		tab4x.setPrimaryKey(primary4x);
		tab4x.setForeignKey(foreign4x);
		tab4x.setReferencias(refs4x);
		tab4x.setClassificacao("subcalsse");

		// ARTIGO_PERIODICO
		List<String> camp6x = new ArrayList();
		camp6x.add("nome_periodico");
		camp6x.add("nro_edicao");
		List<String> primary6x = new ArrayList();
		primary6x.add("cod_publicacao");
		List<String> foreign6x = new ArrayList();
		foreign6x.add("cod_publicacao");
		List<String> refs6x = new ArrayList();
		refs6x.add("T_ARTIGO");
		Tabela tab6x = new Tabela();
		tab6x.setNome("T_ARTIGO_PERIODICO");
		tab6x.setCampos(camp6x);
		tab6x.setPrimaryKey(primary6x);
		tab6x.setForeignKey(foreign6x);
		tab6x.setReferencias(refs6x);
		tab6x.setClassificacao("subclasse");

		// CAPITULO_LIVRO
		List<String> camp5x = new ArrayList();
		camp5x.add("ISBN_livro");
		camp5x.add("titulo_livro");
		camp5x.add("editora_livro");
		camp5x.add("edicao");
		List<String> primary5x = new ArrayList();
		primary5x.add("cod_publicacao");
		List<String> foreign5x = new ArrayList();
		foreign5x.add("cod_publicacao");
		List<String> refs5x = new ArrayList();
		refs5x.add("T_PUBLICACAO");
		Tabela tab5x = new Tabela();
		tab5x.setNome("T_CAPITULO_LIVRO");
		tab5x.setCampos(camp5x);
		tab5x.setPrimaryKey(primary5x);
		tab5x.setForeignKey(foreign5x);
		tab5x.setReferencias(refs5x);
		tab5x.setClassificacao("subclasse");

		List<Tabela> DBr = new ArrayList();
		DBr.add(tab1x);
		DBr.add(tab2x);
		DBr.add(tab3x);
		DBr.add(tab4x);
		DBr.add(tab5x);
		DBr.add(tab6x);

		// inserts Publicacao
		List<String> campPub1x = new ArrayList();
		campPub1x.add("Object Database systems: a survey");
		campPub1x.add("02");
		campPub1x.add("2002");
		campPub1x.add(null);
		List<String> prima1x = new ArrayList();
		prima1x.add("001");
		TabelaInsert ins1x = new TabelaInsert();
		ins1x.setTabela("T_PUBLICACAO");
		ins1x.setAtributos(campPub1x);
		ins1x.setPrimaryKey(prima1x);

		List<String> campPub2x = new ArrayList();
		campPub2x.add("Protocolos de roteamento para redes ad hoc");
		campPub2x.add("05");
		campPub2x.add("2000");
		campPub2x.add(null);
		List<String> prima2x = new ArrayList();
		prima2x.add("002");
		TabelaInsert ins2x = new TabelaInsert();
		ins2x.setTabela("T_PUBLICACAO");
		ins2x.setAtributos(campPub2x);
		ins2x.setPrimaryKey(prima2x);

		List<String> campPub6x = new ArrayList();
		campPub6x.add("Arquitetura de SGBD");
		campPub6x.add("09");
		campPub6x.add("2003");
		campPub6x.add(null);
		List<String> prima6x = new ArrayList();
		prima6x.add("004");
		TabelaInsert ins6x = new TabelaInsert();
		ins6x.setTabela("T_PUBLICACAO");
		ins6x.setAtributos(campPub6x);
		ins6x.setPrimaryKey(prima6x);

		List<String> campPub8x = new ArrayList();
		campPub8x.add("Algoritmo de ordenacao logn");
		campPub8x.add("02");
		campPub8x.add("2002");
		campPub8x.add(null);
		List<String> prima8x = new ArrayList();
		prima8x.add("005");
		TabelaInsert ins8x = new TabelaInsert();
		ins8x.setTabela("T_PUBLICACAO");
		ins8x.setAtributos(campPub8x);
		ins8x.setPrimaryKey(prima8x);

		// insert T_RELATORIO_TECNICO
		List<String> relax = new ArrayList();
		relax.add("30");
		List<String> rprima1x = new ArrayList();
		rprima1x.add("TRIC09");
		List<String> fore1x = new ArrayList();
		fore1x.add("002");
		TabelaInsert ins3x = new TabelaInsert();
		ins3x.setTabela("T_RELATORIO_TECNICO");
		ins3x.setAtributos(relax);
		ins3x.setPrimaryKey(rprima1x);
		ins3x.setForeignKey(fore1x);

		// artigo
		List<String> capartx = new ArrayList();
		capartx.add("1");
		capartx.add("30");
		capartx.add("38");
		capartx.add("I");
		capartx.add("A");
		List<String> primaartx = new ArrayList();
		primaartx.add("001");
		List<String> fore4x = new ArrayList();
		fore4x.add("001");
		TabelaInsert ins4x = new TabelaInsert();
		ins4x.setTabela("T_ARTIGO");
		ins4x.setAtributos(capartx);
		ins4x.setPrimaryKey(primaartx);
		ins4x.setForeignKey(fore4x);

		List<String> capart2x = new ArrayList();
		capart2x.add("3");
		capart2x.add("50");
		capart2x.add("57");
		capart2x.add("N");
		capart2x.add("A");
		List<String> primaart2x = new ArrayList();
		primaart2x.add("005");
		List<String> fore4x2 = new ArrayList();
		fore4x2.add("005");
		TabelaInsert ins4x2 = new TabelaInsert();
		ins4x2.setTabela("T_ARTIGO");
		ins4x2.setAtributos(capart2x);
		ins4x2.setPrimaryKey(primaart2x);
		ins4x2.setForeignKey(fore4x2);

		// insert T_ARTIGO_CONFERENCIA
		List<String> conf1x = new ArrayList();
		conf1x.add("Internation Conference on Database Sysstems");
		conf1x.add("Berlim");
		conf1x.add("Alemanha");
		List<String> primaconfx = new ArrayList();
		primaconfx.add("001");
		List<String> fore2x = new ArrayList();
		fore2x.add("001");
		TabelaInsert ins5x = new TabelaInsert();
		ins5x.setTabela("T_ARTIGO_CONFERENCIA");
		ins5x.setAtributos(conf1x);
		ins5x.setPrimaryKey(primaconfx);
		ins5x.setForeignKey(fore2x);

		// insert T_ARTIGO_PERIODICO
		List<String> conf2x = new ArrayList();
		conf2x.add("Algoritmos");
		conf2x.add("5");
		List<String> primaconf2x = new ArrayList();
		primaconf2x.add("005");
		List<String> fore2x2 = new ArrayList();
		fore2x2.add("005");
		TabelaInsert ins5x2 = new TabelaInsert();
		ins5x2.setTabela("T_ARTIGO_PERIODICO");
		ins5x2.setAtributos(conf2x);
		ins5x2.setPrimaryKey(primaconf2x);
		ins5x2.setForeignKey(fore2x2);

		// inser T_CAPITULO_LIVRO
		List<String> conf7x = new ArrayList();
		conf7x.add("1234569870");
		conf7x.add("Fundamentos de banco de dados");
		conf7x.add("Springer");
		conf7x.add("2");
		List<String> primaconf7x = new ArrayList();
		primaconf7x.add("004");
		List<String> fore7x = new ArrayList();
		fore7x.add("004");
		TabelaInsert ins7x = new TabelaInsert();
		ins7x.setTabela("T_CAPITULO_LIVRO");
		ins7x.setAtributos(conf7x);
		ins7x.setPrimaryKey(primaconf7x);
		ins7x.setForeignKey(fore7x);

		List<TabelaInsert> inserts = new ArrayList();
		inserts.add(ins1x);
		inserts.add(ins2x);
		inserts.add(ins3x);
		inserts.add(ins4x);
		inserts.add(ins5x);
		inserts.add(ins6x);
		inserts.add(ins7x);
		inserts.add(ins8x);
		inserts.add(ins4x2);
		inserts.add(ins5x2);

		// -----------------------------

		// Pessoa
		List<String> camp1 = new ArrayList();
		camp1.add("rg");
		camp1.add("nome");
		camp1.add("data_nascimento");
		camp1.add("naturalidade");
		camp1.add("nacionalidade");
		camp1.add("e_mail");
		camp1.add("url");
		camp1.add("usuario");
		camp1.add("senha");
		camp1.add("perfil");
		List<String> prima1 = new ArrayList();
		prima1.add("cpf");
		Tabela tab1 = new Tabela();
		tab1.setCampos(camp1);
		tab1.setPrimaryKey(prima1);
		tab1.setNome("T_PESSOA");
		tab1.setClassificacao("principal");
		// tab1.setPrincipal(true);

		// Aluno
		List<String> camp2 = new ArrayList();
		camp2.add("info_complementares");
		List<String> prima2 = new ArrayList();
		prima2.add("ra");
		List<String> fore2 = new ArrayList();
		fore2.add("cpf");
		List<String> refe2 = new ArrayList();
		refe2.add("T_PESSOA");
		Tabela tab2 = new Tabela();
		tab2.setCampos(camp2);
		tab2.setPrimaryKey(prima2);
		tab2.setForeignKey(fore2);
		tab2.setReferencias(refe2);
		tab2.setNome("T_ALUNO");
		tab2.setClassificacao("subclasse");

		// Mestrando
		List<String> camp3 = new ArrayList();
		camp3.add("semestre_ingresso");
		camp3.add("ano_egresso");
		camp3.add("data_egresso");
		List<String> prima3 = new ArrayList();
		prima3.add("ramestrando");
		List<String> fore3 = new ArrayList();
		fore3.add("ramestrando");
		List<String> refe3 = new ArrayList();
		refe3.add("T_ALUNO");
		Tabela tab3 = new Tabela();
		tab3.setCampos(camp3);
		tab3.setPrimaryKey(prima3);
		tab3.setForeignKey(fore3);
		tab3.setReferencias(refe3);
		tab3.setNome("T_MESTRANDO");
		tab3.setClassificacao("subclasse");

		// Doutorando
		List<String> camp4 = new ArrayList();
		camp4.add("semestre_ingresso");
		camp4.add("ano_ingresso");
		camp4.add("data_egresso");
		List<String> prima4 = new ArrayList();
		prima4.add("radoutorando");
		List<String> fore4 = new ArrayList();
		fore4.add("radoutorando");
		List<String> refe4 = new ArrayList();
		refe4.add("T_ALUNO");
		Tabela tab4 = new Tabela();
		tab4.setCampos(camp4);
		tab4.setPrimaryKey(prima4);
		tab4.setForeignKey(fore4);
		tab4.setReferencias(refe4);
		tab4.setNome("T_DOUTORANDO");
		tab4.setClassificacao("subclasse");

		// Professor
		List<String> camp5 = new ArrayList();
		camp5.add("info_complementares");
		List<String> prima5 = new ArrayList();
		prima5.add("cpf");
		List<String> fore5 = new ArrayList();
		fore5.add("cpf");
		List<String> refe5 = new ArrayList();
		refe5.add("T_PESSOA");
		Tabela tab5 = new Tabela();
		tab5.setCampos(camp5);
		tab5.setPrimaryKey(prima5);
		tab5.setForeignKey(fore5);
		tab5.setReferencias(refe5);
		tab5.setNome("T_PROFESSOR");
		tab5.setClassificacao("subclasse");

		// Professor IC
		List<String> camp6 = new ArrayList();
		camp6.add("tipo_dedicacao");
		camp6.add("sala");
		List<String> prima6 = new ArrayList();
		prima6.add("matricula");
		List<String> fore6 = new ArrayList();
		fore6.add("cpf");
		List<String> refe6 = new ArrayList();
		refe6.add("T_PROFESSOR");
		Tabela tab6 = new Tabela();
		tab6.setCampos(camp6);
		tab6.setPrimaryKey(prima6);
		tab6.setForeignKey(fore6);
		tab6.setReferencias(refe6);
		tab6.setNome("T_PROFESSOR_IC");
		tab6.setClassificacao("subclasse");

		// Professor Visitante
		List<String> camp7 = new ArrayList();
		camp7.add("universidade");
		camp7.add("depto");
		List<String> prima7 = new ArrayList();
		prima7.add("cpf");
		List<String> fore7 = new ArrayList();
		fore7.add("cpf");
		List<String> refe7 = new ArrayList();
		refe7.add("T_PROFESSOR");
		Tabela tab7 = new Tabela();
		tab7.setCampos(camp7);
		tab7.setPrimaryKey(prima7);
		tab7.setForeignKey(fore7);
		tab7.setReferencias(refe7);
		tab7.setNome("T_PROFESSOR_VISITANTE");
		tab7.setClassificacao("subclasse");

		// List<Tabela> DBr = new ArrayList();
		DBr.add(tab1);
		DBr.add(tab2);
		DBr.add(tab3);
		DBr.add(tab4);
		DBr.add(tab5);
		DBr.add(tab6);
		DBr.add(tab7);

		// -------------------------------------------------------------

		// Exemplo
		List<String> atrib = new ArrayList();
		atrib.add("");
		List<String> primar = new ArrayList();
		primar.add("");
		TabelaInsert ins = new TabelaInsert();
		ins.setTabela("");
		ins.setAtributos(atrib);
		ins.setPrimaryKey(primar);

		// Pessoa
		List<String> atrib1 = new ArrayList();
		atrib1.add("12456789");
		atrib1.add("Chuck Norris");
		atrib1.add("1000-01-01");
		atrib1.add("Belem");
		atrib1.add("Brasileira");
		atrib1.add("chuck@email.com");
		atrib1.add("http://chuck.com");
		atrib1.add("chuck");
		atrib1.add("chuck");
		atrib1.add("U");
		List<String> primar1 = new ArrayList();
		primar1.add("98763214587");
		TabelaInsert ins1 = new TabelaInsert();
		ins1.setTabela("T_PESSOA");
		ins1.setAtributos(atrib1);
		ins1.setPrimaryKey(primar1);

		// Pessoa
		List<String> atrib2 = new ArrayList();
		atrib2.add("84759632");
		atrib2.add("Torvalds");
		atrib2.add("1991-06-06");
		atrib2.add("Campinas");
		atrib2.add("Brasileira");
		atrib2.add("linus@ic.com");
		atrib2.add("http://linus.com");
		atrib2.add("linus");
		atrib2.add("linus");
		atrib2.add("A");
		List<String> primar2 = new ArrayList();
		primar2.add("98632541754");
		TabelaInsert ins2 = new TabelaInsert();
		ins2.setTabela("T_PESSOA");
		ins2.setAtributos(atrib2);
		ins2.setPrimaryKey(primar2);

		// Pessoa
		List<String> atrib8 = new ArrayList();
		atrib8.add("95874123");
		atrib8.add("Knuth");
		atrib8.add("1910-06-06");
		atrib8.add("Campinas");
		atrib8.add("Brasileira");
		atrib8.add("k@ic.com");
		atrib8.add("http://k.com");
		atrib8.add("k");
		atrib8.add("k");
		atrib8.add("U");
		List<String> primar8 = new ArrayList();
		primar8.add("95175368429");
		TabelaInsert ins8 = new TabelaInsert();
		ins8.setTabela("T_PESSOA");
		ins8.setAtributos(atrib8);
		ins8.setPrimaryKey(primar8);

		// Pessoa
		List<String> atrib10 = new ArrayList();
		atrib10.add("10987312");
		atrib10.add("Bill Gates");
		atrib10.add("1960-01-05");
		atrib10.add("Redmond");
		atrib10.add("Estadunidense");
		atrib10.add("gates@ms.com");
		atrib10.add("http://ms.com");
		atrib10.add("gates");
		atrib10.add("gates");
		atrib10.add("U");
		List<String> primar10 = new ArrayList();
		primar10.add("74852963214");
		TabelaInsert ins10 = new TabelaInsert();
		ins10.setTabela("T_PESSOA");
		ins10.setAtributos(atrib10);
		ins10.setPrimaryKey(primar10);

		// Professor
		List<String> atrib3 = new ArrayList();
		atrib3.add("Professor Emerito");
		List<String> primar3 = new ArrayList();
		primar3.add("98763214587");
		List<String> foren3 = new ArrayList();
		foren3.add("98763214587");
		TabelaInsert ins3 = new TabelaInsert();
		ins3.setTabela("T_PROFESSOR");
		ins3.setAtributos(atrib3);
		ins3.setPrimaryKey(primar3);
		ins3.setForeignKey(foren3);

		// Professor
		List<String> atrib4 = new ArrayList();
		atrib4.add("Boas habilidades de programacao");
		List<String> primar4 = new ArrayList();
		primar4.add("98632541754");
		List<String> foren4 = new ArrayList();
		foren4.add("98632541754");
		TabelaInsert ins4 = new TabelaInsert();
		ins4.setTabela("T_PROFESSOR");
		ins4.setAtributos(atrib4);
		ins4.setPrimaryKey(primar4);
		ins4.setForeignKey(foren4);

		// Professor
		List<String> atrib9 = new ArrayList();
		atrib9.add(null);
		List<String> primar9 = new ArrayList();
		primar9.add("95175368429");
		List<String> foren9 = new ArrayList();
		foren9.add("95175368429");
		TabelaInsert ins9 = new TabelaInsert();
		ins9.setTabela("T_PROFESSOR");
		ins9.setAtributos(atrib9);
		ins9.setPrimaryKey(primar9);
		ins9.setForeignKey(foren9);

		// Professor IC
		List<String> atrib5 = new ArrayList();
		atrib5.add("P");
		atrib5.add("IC-1 01");
		List<String> primar5 = new ArrayList();
		primar5.add("020099");
		List<String> foren5 = new ArrayList();
		foren5.add("98763214587");
		TabelaInsert ins5 = new TabelaInsert();
		ins5.setTabela("T_PROFESSOR_IC");
		ins5.setAtributos(atrib5);
		ins5.setPrimaryKey(primar5);
		ins5.setForeignKey(foren5);

		// Professor IC
		List<String> atrib6 = new ArrayList();
		atrib6.add("D");
		atrib6.add("IC-1 02");
		List<String> primar6 = new ArrayList();
		primar6.add("444444");
		List<String> foren6 = new ArrayList();
		foren6.add("98632541754");
		TabelaInsert ins6 = new TabelaInsert();
		ins6.setTabela("T_PROFESSOR_IC");
		ins6.setAtributos(atrib6);
		ins6.setPrimaryKey(primar6);
		ins6.setForeignKey(foren6);

		// Visitante
		List<String> atrib7 = new ArrayList();
		atrib7.add("University of Beijim");
		atrib7.add("Institute of Computing");
		List<String> primar7 = new ArrayList();
		primar7.add("95175368429");
		List<String> foren7 = new ArrayList();
		foren7.add("95175368429");
		TabelaInsert ins7 = new TabelaInsert();
		ins7.setTabela("T_PROFESSOR_VISITANTE");
		ins7.setAtributos(atrib7);
		ins7.setPrimaryKey(primar7);
		ins7.setForeignKey(foren7);

		// Mestrando
		List<String> atrib11 = new ArrayList();
		atrib11.add("1");
		atrib11.add("1981");
		atrib11.add("1981-03-19");
		List<String> primar11 = new ArrayList();
		primar11.add("790099");
		List<String> foren11 = new ArrayList();
		foren11.add("790099");
		TabelaInsert ins11 = new TabelaInsert();
		ins11.setTabela("T_MESTRANDO");
		ins11.setAtributos(atrib11);
		ins11.setPrimaryKey(primar11);
		ins11.setForeignKey(foren11);

		// Aluno
		List<String> atrib12 = new ArrayList();
		atrib12.add("Co-autor de 19 artigos.");
		List<String> primar12 = new ArrayList();
		primar12.add("790099");
		List<String> foren12 = new ArrayList();
		foren12.add("74852963214");
		TabelaInsert ins12 = new TabelaInsert();
		ins12.setTabela("T_ALUNO");
		ins12.setAtributos(atrib12);
		ins12.setPrimaryKey(primar12);
		ins12.setForeignKey(foren12);

		// List<TabelaInsert> inserts = new ArrayList();
		inserts.add(ins1);
		inserts.add(ins2);
		inserts.add(ins3);
		inserts.add(ins4);
		inserts.add(ins5);
		inserts.add(ins6);
		// inserts.add(ins7);
		inserts.add(ins10);
		inserts.add(ins12);
		inserts.add(ins11);

		// ------------------------------ // ---------------------------
		// Tabela T_PESSOA_X_PUBLICACAO
		List<String> prima8 = new ArrayList();
		prima8.add("cpf");
		prima8.add("cod_publicacao");
		List<String> fore8 = new ArrayList();
		fore8.add("cpf");
		fore8.add("cod_publicacao");
		List<String> refe8 = new ArrayList();
		refe8.add("T_PESSOA");
		refe8.add("T_PUBLICACAO");
		Tabela tab8 = new Tabela();
		tab8.setNome("T_PESSOA_X_PUBLICACAO");
		tab8.setPrimaryKey(prima8);
		tab8.setForeignKey(fore8);
		tab8.setReferencias(refe8);
		tab8.setClassificacao("relacionamento");

		DBr.add(tab8);

		List<String> primar13 = new ArrayList();
		primar13.add("98632541754");
		primar13.add("004");
		List<String> foren13 = new ArrayList();
		foren13.add("98632541754");
		foren13.add("004");
		TabelaInsert ins13 = new TabelaInsert();
		ins13.setTabela("T_PESSOA_X_PUBLICACAO");
		ins13.setPrimaryKey(primar13);
		ins13.setForeignKey(foren13);

		List<String> primar14 = new ArrayList();
		primar14.add("98632541754");
		primar14.add("005");
		List<String> foren14 = new ArrayList();
		foren14.add("98632541754");
		foren14.add("005");
		TabelaInsert ins14 = new TabelaInsert();
		ins14.setTabela("T_PESSOA_X_PUBLICACAO");
		ins14.setPrimaryKey(primar14);
		ins14.setForeignKey(foren14);

		inserts.add(ins13);
		inserts.add(ins14);
		
		TabelasParaMongo tabMong = new TabelasParaMongo(DBr, inserts);
		
		for(TabelaInsert in: inserts){
			tabMong.conversao(in);
		}

	}

}
