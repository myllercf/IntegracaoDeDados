package Conversao;

import java.util.ArrayList;
import java.util.List;

public class Insercoes {
	List<TabelaInsert> instancias = new ArrayList();
	
	public Insercoes(){
		//T_PESSOA
				List<String> atrib1 = new ArrayList();
				atrib1.add("10123123");
				atrib1.add("Fulano de Tal");
				atrib1.add("1980-12-01");
				atrib1.add("Brasilia");
				atrib1.add("Brasileira");
				atrib1.add("email@email.com");
				atrib1.add("http://dominio.com");
				atrib1.add("fulano");
				atrib1.add("fulano");
				atrib1.add("U");
				atrib1.add("mestrando");
				List<String> primar1 = new ArrayList();
				primar1.add("12345678910");
				TabelaInsert ins1 = new TabelaInsert();
				ins1.setTabela("T_PESSOA");
				ins1.setAtributos(atrib1);
				ins1.setPrimaryKey(primar1);
				
				List<String> atrib2 = new ArrayList();
				atrib2.add("10456789");
				atrib2.add("Jose Silva");
				atrib2.add("1980-04-30");
				atrib2.add("Rio de Janeiro");
				atrib2.add("Brasileira");
				atrib2.add("email@email.com");
				atrib2.add("http://dominio.com");
				atrib2.add("jsilva");
				atrib2.add("jsilva");
				atrib2.add("U");
				atrib2.add("pessoa");
				List<String> primar2 = new ArrayList();
				primar2.add("12951753684");
				TabelaInsert ins2 = new TabelaInsert();
				ins2.setTabela("T_PESSOA");
				ins2.setAtributos(atrib2);
				ins2.setPrimaryKey(primar2);
				
				List<String> atrib3= new ArrayList();
				atrib3.add("10987312");
				atrib3.add("Bill Gates");
				atrib3.add("1960-01-05");
				atrib3.add("Redmond");
				atrib3.add("Estadunidense");
				atrib3.add("gates@ms.com");
				atrib3.add("http://ms.com");
				atrib3.add("gates");
				atrib3.add("gates");
				atrib3.add("U");
				atrib3.add("mestrando");
				List<String> primar3 = new ArrayList();
				primar3.add("74852963214");
				TabelaInsert ins3 = new TabelaInsert();
				ins3.setTabela("T_PESSOA");
				ins3.setAtributos(atrib3);
				ins3.setPrimaryKey(primar3);
				
				List<String> atrib4= new ArrayList();
				atrib4.add("74852963");
				atrib4.add("Silvio Santos");
				atrib4.add("1840-07-09");
				atrib4.add("Sao Paulo");
				atrib4.add("Brasileira");
				atrib4.add("silvio@sbt.com");
				atrib4.add(null);
				atrib4.add("silvio");
				atrib4.add("silvio");
				atrib4.add("U");
				atrib4.add("doutorando");
				List<String> primar4 = new ArrayList();
				primar4.add("98765432185");
				TabelaInsert ins4 = new TabelaInsert();
				ins4.setTabela("T_PESSOA");
				ins4.setAtributos(atrib4);
				ins4.setPrimaryKey(primar4);
				
				List<String> atrib5= new ArrayList();
				atrib5.add("14258369");
				atrib5.add("Vera");
				atrib5.add("1978-06-06");
				atrib5.add("Campinas");
				atrib5.add("Brasileira");
				atrib5.add("vera@ic.com");
				atrib5.add("http://ic.com");
				atrib5.add("vera");
				atrib5.add("vera");
				atrib5.add("A");
				atrib5.add("pessoa");
				List<String> primar5 = new ArrayList();
				primar5.add("95175368421");
				TabelaInsert ins5 = new TabelaInsert();
				ins5.setTabela("T_PESSOA");
				ins5.setAtributos(atrib5);
				ins5.setPrimaryKey(primar5);
				
				List<String> atrib6 = new ArrayList();
				atrib6.add("12456789");
				atrib6.add("Chuck Norris");
				atrib6.add("1000-01-01");
				atrib6.add("Belem");
				atrib6.add("Brasileira");
				atrib6.add("chuck@email.com");
				atrib6.add("http://chuck.com");
				atrib6.add("chuck");
				atrib6.add("chuck");
				atrib6.add("U");
				atrib6.add("ic");
				List<String> primar6 = new ArrayList();
				primar6.add("98763214587");
				TabelaInsert ins6 = new TabelaInsert();
				ins6.setTabela("T_PESSOA");
				ins6.setAtributos(atrib6);
				ins6.setPrimaryKey(primar6);
				
				List<String> atrib7 = new ArrayList();
				atrib7.add("95874123");
				atrib7.add("Knuth");
				atrib7.add("1910-06-06");
				atrib7.add("Campinas");
				atrib7.add("Brasileira");
				atrib7.add("k@ic.com");
				atrib7.add("http://k.com");
				atrib7.add("k");
				atrib7.add("k");
				atrib7.add("U");
				atrib7.add("visitante");
				List<String> primar7 = new ArrayList();
				primar7.add("95175368429");
				TabelaInsert ins7 = new TabelaInsert();
				ins7.setTabela("T_PESSOA");
				ins7.setAtributos(atrib7);
				ins7.setPrimaryKey(primar7);
				
				List<String> atrib8 = new ArrayList();
				atrib8.add("84759632");
				atrib8.add("Torvalds");
				atrib8.add("1991-06-06");
				atrib8.add("Campinas");
				atrib8.add("Brasileira");
				atrib8.add("linus@ic.com");
				atrib8.add("http://linus.com");
				atrib8.add("linus");
				atrib8.add("linus");
				atrib8.add("A");
				atrib8.add("ic");
				List<String> primar8 = new ArrayList();
				primar8.add("98632541754");
				TabelaInsert ins8 = new TabelaInsert();
				ins8.setTabela("T_PESSOA");
				ins8.setAtributos(atrib8);
				ins8.setPrimaryKey(primar8);
				
				List<String> atrib9 = new ArrayList();
				atrib9.add("96387412");
				atrib9.add("Turing");
				atrib9.add("1991-06-06");
				atrib9.add("Campinas");
				atrib9.add("Brasileira");
				atrib9.add("t@ic.com");
				atrib9.add("http://turing.com");
				atrib9.add("turing");
				atrib9.add("ttt");
				atrib9.add("U");
				atrib9.add("ic");
				List<String> primar9 = new ArrayList();
				primar9.add("99958741111");
				TabelaInsert ins9 = new TabelaInsert();
				ins9.setTabela("T_PESSOA");
				ins9.setAtributos(atrib9);
				ins9.setPrimaryKey(primar9);
				
				
				//-----------
				//T_PROFESSOR
				List<String> atrib10 = new ArrayList();
				atrib10.add("Professor Emerito");
				List<String> primar10 = new ArrayList();
				primar10.add("98763214587");
				List<String> foren10 = new ArrayList();
				foren10.add("98763214587");
				TabelaInsert ins10 = new TabelaInsert();
				ins10.setTabela("T_PROFESSOR");
				ins10.setAtributos(atrib10);
				ins10.setPrimaryKey(primar10);
				ins10.setForeignKey(foren10);
				
				List<String> atrib11 = new ArrayList();
				atrib11.add(null);
				List<String> primar11 = new ArrayList();
				primar11.add("95175368429");
				List<String> foren11 = new ArrayList();
				foren11.add("95175368429");
				TabelaInsert ins11 = new TabelaInsert();
				ins11.setTabela("T_PROFESSOR");
				ins11.setAtributos(atrib11);
				ins11.setPrimaryKey(primar11);
				ins11.setForeignKey(foren11);
				
				List<String> atrib12 = new ArrayList();
				atrib12.add("Boas habilidades de programacao");
				List<String> primar12 = new ArrayList();
				primar12.add("98632541754");
				List<String> foren12 = new ArrayList();
				foren12.add("98632541754");
				TabelaInsert ins12 = new TabelaInsert();
				ins12.setTabela("T_PROFESSOR");
				ins12.setAtributos(atrib12);
				ins12.setPrimaryKey(primar12);
				ins12.setForeignKey(foren12);
				
				List<String> atrib13 = new ArrayList();
				atrib13.add(null);
				List<String> primar13 = new ArrayList();
				primar13.add("99958741111");
				List<String> foren13 = new ArrayList();
				foren13.add("99958741111");
				TabelaInsert ins13 = new TabelaInsert();
				ins13.setTabela("T_PROFESSOR");
				ins13.setAtributos(atrib13);
				ins13.setPrimaryKey(primar13);
				ins13.setForeignKey(foren13);
				
				
				//--------
				//T_ALUNO
				List<String> atrib14 = new ArrayList();
				atrib14.add("Aluno exemplar.");
				List<String> primar14 = new ArrayList();
				primar14.add("030099");
				List<String> foren14 = new ArrayList();
				foren14.add("12345678910");
				TabelaInsert ins14 = new TabelaInsert();
				ins14.setTabela("T_ALUNO");
				ins14.setAtributos(atrib14);
				ins14.setPrimaryKey(primar14);
				ins14.setForeignKey(foren14);
				
				List<String> atrib15 = new ArrayList();
				atrib15.add("Co-autor de 19 artigos.");
				List<String> primar15 = new ArrayList();
				primar15.add("790099");
				List<String> foren15 = new ArrayList();
				foren15.add("74852963214");
				TabelaInsert ins15 = new TabelaInsert();
				ins15.setTabela("T_ALUNO");
				ins15.setAtributos(atrib15);
				ins15.setPrimaryKey(primar15);
				ins15.setForeignKey(foren15);
				
				List<String> atrib16 = new ArrayList();
				atrib16.add(null);
				List<String> primar16 = new ArrayList();
				primar16.add("020099");
				List<String> foren16 = new ArrayList();
				foren16.add("98763214587");
				TabelaInsert ins16 = new TabelaInsert();
				ins16.setTabela("T_ALUNO");
				ins16.setAtributos(atrib16);
				ins16.setPrimaryKey(primar16);
				ins16.setForeignKey(foren16);
				
				List<String> atrib17 = new ArrayList();
				atrib17.add(null);
				List<String> primar17 = new ArrayList();
				primar17.add("030098");
				List<String> foren17 = new ArrayList();
				foren17.add("98765432185");
				TabelaInsert ins17 = new TabelaInsert();
				ins17.setTabela("T_ALUNO");
				ins17.setAtributos(atrib17);
				ins17.setPrimaryKey(primar17);
				ins17.setForeignKey(foren17);
				
				
				//-----------
				//TMESTRANDO
				List<String> atrib18 = new ArrayList();
				atrib18.add("1");
				atrib18.add("1981");
				atrib18.add("1981-03-19");
				List<String> primar18 = new ArrayList();
				primar18.add("790099");
				List<String> foren18 = new ArrayList();
				foren18.add("790099");
				TabelaInsert ins18 = new TabelaInsert();
				ins18.setTabela("TMESTRANDO");
				ins18.setAtributos(atrib18);
				ins18.setPrimaryKey(primar18);
				ins18.setForeignKey(foren18);
				
				List<String> atrib19 = new ArrayList();
				atrib19.add("2");
				atrib19.add("2005");
				atrib19.add(null);
				List<String> primar19 = new ArrayList();
				primar19.add("030099");
				List<String> foren19 = new ArrayList();
				foren19.add("030099");
				TabelaInsert ins19 = new TabelaInsert();
				ins19.setTabela("TMESTRANDO");
				ins19.setAtributos(atrib19);
				ins19.setPrimaryKey(primar19);
				ins19.setForeignKey(foren19);
				
				
				//------------
				//TDOUTORANDO
				List<String> atrib20 = new ArrayList();
				atrib20.add("1");
				atrib20.add("1900");
				atrib20.add("1900-03-02");
				List<String> primar20 = new ArrayList();
				primar20.add("020099");
				List<String> foren20 = new ArrayList();
				foren20.add("020099");
				TabelaInsert ins20 = new TabelaInsert();
				ins20.setTabela("TDOUTORANDO");
				ins20.setAtributos(atrib20);
				ins20.setPrimaryKey(primar20);
				ins20.setForeignKey(foren20);
				
				List<String> atrib21 = new ArrayList();
				atrib21.add("2");
				atrib21.add("2005");
				atrib21.add(null);
				List<String> primar21 = new ArrayList();
				primar21.add("030098");
				List<String> foren21 = new ArrayList();
				foren21.add("030098");
				TabelaInsert ins21 = new TabelaInsert();
				ins21.setTabela("TDOUTORANDO");
				ins21.setAtributos(atrib21);
				ins21.setPrimaryKey(primar21);
				ins21.setForeignKey(foren21);
				
				
				//-----------------
				//T_Professor_IC
				List<String> atrib22 = new ArrayList();
				atrib22.add("P");
				atrib22.add("IC-1 01");
				List<String> primar22 = new ArrayList();
				primar22.add("123456");
				List<String> foren22 = new ArrayList();
				foren22.add("98763214587");
				TabelaInsert ins22 = new TabelaInsert();
				ins22.setTabela("T_PROFESSOR_IC");
				ins22.setAtributos(atrib22);
				ins22.setPrimaryKey(primar22);
				ins22.setForeignKey(foren22);

				List<String> atrib23 = new ArrayList();
				atrib23.add("D");
				atrib23.add("IC-1 02");
				List<String> primar23 = new ArrayList();
				primar23.add("444444");
				List<String> foren23 = new ArrayList();
				foren23.add("98632541754");
				TabelaInsert ins23 = new TabelaInsert();
				ins23.setTabela("T_PROFESSOR_IC");
				ins23.setAtributos(atrib23);
				ins23.setPrimaryKey(primar23);
				ins23.setForeignKey(foren23);
				
				List<String> atrib24 = new ArrayList();
				atrib24.add("D");
				atrib24.add("IC-1 03");
				List<String> primar24 = new ArrayList();
				primar24.add("111111");
				List<String> foren24 = new ArrayList();
				foren24.add("99958741111");
				TabelaInsert ins24 = new TabelaInsert();
				ins24.setTabela("T_PROFESSOR_IC");
				ins24.setAtributos(atrib24);
				ins24.setPrimaryKey(primar24);
				ins24.setForeignKey(foren24);
				
				
				//---------------------
				//T_PROFESSOR_VISITANTE
				List<String> atrib25 = new ArrayList();
				atrib25.add("University of Beijim");
				atrib25.add("Institute of Computing");
				List<String> primar25 = new ArrayList();
				primar25.add("95175368429");
				List<String> foren25 = new ArrayList();
				foren25.add("95175368429");
				TabelaInsert ins25 = new TabelaInsert();
				ins25.setTabela("T_PROFESSOR_VISITANTE");
				ins25.setAtributos(atrib25);
				ins25.setPrimaryKey(primar25);
				ins25.setForeignKey(foren25);
				
				
				//---------------------
				//T_PESSOA_X_PUBLICACAO
				List<String> primar26 = new ArrayList();
				primar26.add("12345678910");
				primar13.add("001");
				List<String> foren26 = new ArrayList();
				foren26.add("12345678910");
				foren26.add("001");
				TabelaInsert ins26 = new TabelaInsert();
				ins26.setTabela("T_PESSOA_X_PUBLICACAO");
				ins26.setPrimaryKey(primar26);
				ins26.setForeignKey(foren26);

				List<String> primar27 = new ArrayList();
				primar27.add("12951753684");
				primar27.add("002");
				List<String> foren27 = new ArrayList();
				foren27.add("12951753684");
				foren27.add("002");
				TabelaInsert ins27 = new TabelaInsert();
				ins27.setTabela("T_PESSOA_X_PUBLICACAO");
				ins27.setPrimaryKey(primar27);
				ins27.setForeignKey(foren27);
				
				List<String> primar28 = new ArrayList();
				primar28.add("74852963214");
				primar28.add("003");
				List<String> foren28 = new ArrayList();
				foren28.add("74852963214");
				foren28.add("003");
				TabelaInsert ins28 = new TabelaInsert();
				ins28.setTabela("T_PESSOA_X_PUBLICACAO");
				ins28.setPrimaryKey(primar28);
				ins28.setForeignKey(foren28);

				List<String> primar29 = new ArrayList();
				primar29.add("98632541754");
				primar29.add("004");
				List<String> foren29 = new ArrayList();
				foren29.add("98632541754");
				foren29.add("004");
				TabelaInsert ins29 = new TabelaInsert();
				ins29.setTabela("T_PESSOA_X_PUBLICACAO");
				ins29.setPrimaryKey(primar29);
				ins29.setForeignKey(foren29);
				
				List<String> primar30 = new ArrayList();
				primar30.add("99958741111");
				primar30.add("004");
				List<String> foren30 = new ArrayList();
				foren30.add("99958741111");
				foren30.add("004");
				TabelaInsert ins30 = new TabelaInsert();
				ins30.setTabela("T_PESSOA_X_PUBLICACAO");
				ins30.setPrimaryKey(primar30);
				ins30.setForeignKey(foren30);

				List<String> primar31 = new ArrayList();
				primar31.add("98632541754");
				primar31.add("005");
				List<String> foren31 = new ArrayList();
				foren31.add("98632541754");
				foren31.add("005");
				TabelaInsert ins31 = new TabelaInsert();
				ins31.setTabela("T_PESSOA_X_PUBLICACAO");
				ins31.setPrimaryKey(primar31);
				ins31.setForeignKey(foren31);
				
				List<String> primar32 = new ArrayList();
				primar32.add("95175368429");
				primar32.add("005");
				List<String> foren32= new ArrayList();
				foren32.add("95175368429");
				foren32.add("005");
				TabelaInsert ins32 = new TabelaInsert();
				ins32.setTabela("T_PESSOA_X_PUBLICACAO");
				ins32.setPrimaryKey(primar32);
				ins32.setForeignKey(foren32);

				List<String> primar33 = new ArrayList();
				primar33.add("98765432185");
				primar33.add("005");
				List<String> foren33 = new ArrayList();
				foren33.add("98765432185");
				foren33.add("005");
				TabelaInsert ins33 = new TabelaInsert();
				ins33.setTabela("T_PESSOA_X_PUBLICACAO");
				ins33.setPrimaryKey(primar33);
				ins33.setForeignKey(foren33);
				
				
				//-------------------
				//T_PUBLICACAO
				List<String> atrib34 = new ArrayList();
				atrib34.add("Object Database systems: a survey");
				atrib34.add("02");
				atrib34.add("2002");
				atrib34.add(null);
				List<String> primar34 = new ArrayList();
				primar34.add("001");
				TabelaInsert ins34 = new TabelaInsert();
				ins34.setTabela("T_PUBLICACAO");
				ins34.setAtributos(atrib34);
				ins34.setPrimaryKey(primar34);

				List<String> atrib35 = new ArrayList();
				atrib35.add("Protocolos de roteamento para redes ad hoc");
				atrib35.add("05");
				atrib35.add("2000");
				atrib35.add(null);
				List<String> prima35 = new ArrayList();
				prima35.add("002");
				TabelaInsert ins35 = new TabelaInsert();
				ins35.setTabela("T_PUBLICACAO");
				ins35.setAtributos(atrib35);
				ins35.setPrimaryKey(prima35);
				
				List<String> atrib36 = new ArrayList();
				atrib36.add("Fundamentos de banco de dados");
				atrib36.add("09");
				atrib36.add("2003");
				atrib36.add(null);
				List<String> prima36 = new ArrayList();
				prima36.add("003");
				TabelaInsert ins36 = new TabelaInsert();
				ins36.setTabela("T_PUBLICACAO");
				ins36.setAtributos(atrib36);
				ins36.setPrimaryKey(prima36);

				List<String> atrib37 = new ArrayList();
				atrib37.add("Arquitetura de SGBD");
				atrib37.add("09");
				atrib37.add("2003");
				atrib37.add(null);
				List<String> prima37 = new ArrayList();
				prima37.add("004");
				TabelaInsert ins37 = new TabelaInsert();
				ins37.setTabela("T_PUBLICACAO");
				ins37.setAtributos(atrib37);
				ins37.setPrimaryKey(prima37);

				List<String> atrib38 = new ArrayList();
				atrib38.add("Algoritmo de ordenacao logn");
				atrib38.add("02");
				atrib38.add("2002");
				atrib38.add(null);
				List<String> prima38 = new ArrayList();
				prima38.add("005");
				TabelaInsert ins38 = new TabelaInsert();
				ins38.setTabela("T_PUBLICACAO");
				ins38.setAtributos(atrib38);
				ins38.setPrimaryKey(prima38);
				
				
				//----------------------------
				//T_RELATORIO_TECNICO
				List<String> atrib39 = new ArrayList();
				atrib39.add("30");
				List<String> prima39 = new ArrayList();
				prima39.add("TRIC09");
				List<String> foren39 = new ArrayList();
				foren39.add("002");
				TabelaInsert ins39 = new TabelaInsert();
				ins39.setTabela("T_RELATORIO_TECNICO");
				ins39.setAtributos(atrib39);
				ins39.setPrimaryKey(prima39);
				ins39.setForeignKey(foren39);
				
				
				//-----------------------
				//T_LIVRO
				List<String> atrib40 = new ArrayList();
				atrib40.add("30");
				List<String> prima40 = new ArrayList();
				prima40.add("TRIC09");
				List<String> foren40 = new ArrayList();
				foren40.add("002");
				TabelaInsert ins40 = new TabelaInsert();
				ins40.setTabela("T_RELATORIO_TECNICO");
				ins40.setAtributos(atrib40);
				ins40.setPrimaryKey(prima40);
				ins40.setForeignKey(foren40);
				
				
				//--------------------------
				//T_CAPITULO_LIVRO
				List<String> atrib41 = new ArrayList();
				atrib41.add("1234569870");
				atrib41.add("Fundamentos de banco de dados");
				atrib41.add("Springer");
				atrib41.add("2");
				List<String> prima41 = new ArrayList();
				prima41.add("004");
				List<String> foren41 = new ArrayList();
				foren41.add("004");
				TabelaInsert ins41 = new TabelaInsert();
				ins41.setTabela("T_CAPITULO_LIVRO");
				ins41.setAtributos(atrib41);
				ins41.setPrimaryKey(prima41);
				ins41.setForeignKey(foren41);
				
				
				//-----------
				//T_ARTIGO
				List<String> atrib42 = new ArrayList();
				atrib42.add("1");
				atrib42.add("30");
				atrib42.add("38");
				atrib42.add("I");
				atrib42.add("A");
				List<String> prima42 = new ArrayList();
				prima42.add("001");
				List<String> foren42 = new ArrayList();
				foren42.add("001");
				TabelaInsert ins42 = new TabelaInsert();
				ins42.setTabela("T_ARTIGO");
				ins42.setAtributos(atrib42);
				ins42.setPrimaryKey(prima42);
				ins42.setForeignKey(foren42);

				List<String> atrib43 = new ArrayList();
				atrib43.add("3");
				atrib43.add("50");
				atrib43.add("57");
				atrib43.add("N");
				atrib43.add("A");
				List<String> prima43 = new ArrayList();
				prima43.add("005");
				List<String> foren43 = new ArrayList();
				foren43.add("005");
				TabelaInsert ins43 = new TabelaInsert();
				ins43.setTabela("T_ARTIGO");
				ins43.setAtributos(atrib43);
				ins43.setPrimaryKey(prima43);
				ins43.setForeignKey(foren43);
				
				
				//-----------------------
				//T_ARTIGO_CONFERENCIA
				List<String> atrib44 = new ArrayList();
				atrib44.add("Internation Conference on Database Sysstems");
				atrib44.add("Berlim");
				atrib44.add("Alemanha");
				List<String> prima44 = new ArrayList();
				prima44.add("001");
				List<String> foren44 = new ArrayList();
				foren44.add("001");
				TabelaInsert ins44 = new TabelaInsert();
				ins44.setTabela("T_ARTIGO_CONFERENCIA");
				ins44.setAtributos(atrib44);
				ins44.setPrimaryKey(prima44);
				ins44.setForeignKey(foren44);
				
				List<String> atrib45 = new ArrayList();
				atrib45.add("Algoritmos");
				atrib45.add("5");
				List<String> prima45 = new ArrayList();
				prima45.add("005");
				List<String> foren45 = new ArrayList();
				foren45.add("005");
				TabelaInsert ins45 = new TabelaInsert();
				ins45.setTabela("T_ARTIGO_PERIODICO");
				ins45.setAtributos(atrib45);
				ins45.setPrimaryKey(prima45);
				ins45.setForeignKey(foren45);
				
				instancias.add(ins1);
				instancias.add(ins2);
				instancias.add(ins3);
				instancias.add(ins4);
				instancias.add(ins5);
				instancias.add(ins6);
				instancias.add(ins7);
				instancias.add(ins8);
				instancias.add(ins9);
				instancias.add(ins10);
				instancias.add(ins11);
				instancias.add(ins12);
				instancias.add(ins13);
				instancias.add(ins14);
				instancias.add(ins15);
				instancias.add(ins16);
				instancias.add(ins17);
				instancias.add(ins18);
				instancias.add(ins19);
				instancias.add(ins20);
				instancias.add(ins21);
				//instancias.add(ins22);
				instancias.add(ins23);
				instancias.add(ins24);
				instancias.add(ins25);
				instancias.add(ins26);
				instancias.add(ins27);
				instancias.add(ins28);
				instancias.add(ins29);
				instancias.add(ins30);
				instancias.add(ins31);
				instancias.add(ins32);
				instancias.add(ins33);
				instancias.add(ins34);
				instancias.add(ins35);
				instancias.add(ins36);
				instancias.add(ins37);
				instancias.add(ins38);
				instancias.add(ins39);
				instancias.add(ins40);
				instancias.add(ins41);
				instancias.add(ins42);
				instancias.add(ins43);
				instancias.add(ins44);
				instancias.add(ins45);
	}

	public List<TabelaInsert> getInstancias() {
		return instancias;
	}
	

}