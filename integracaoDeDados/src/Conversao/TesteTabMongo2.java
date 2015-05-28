package Conversao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TesteTabMongo2 {

	public static void main(String[] args) {
		
		//exemplo
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
		
		//Pessoa
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
		//tab1.setPrincipal(true);
		
		//Aluno
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
		
		//Mestrando
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
		
		//Doutorando
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
		
		//Professor
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
		
		//Professor IC
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
		
		//Professor Visitante
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
		
		
		List<Tabela> DBr = new ArrayList();
		DBr.add(tab1);
		DBr.add(tab2);
		DBr.add(tab3);
		DBr.add(tab4);
		DBr.add(tab5);
		DBr.add(tab6);
		DBr.add(tab7);
		
		//-------------------------------------------------------------
		
		//Exemplo
		List<String> atrib = new ArrayList();
		atrib.add("");
		List<String> primar = new ArrayList();
		primar.add("");
		TabelaInsert ins = new TabelaInsert();
		ins.setTabela("");
		ins.setAtributos(atrib);
		ins.setPrimaryKey(primar);
		
		//Pessoa
		List<String> atrib1 = new ArrayList();
		atrib1.add("12456789");
		atrib1.add("Chuck Norris");
		atrib1.add("1000−01−01");
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
		
		//Pessoa
		List<String> atrib2 = new ArrayList();
		atrib2.add("84759632");
		atrib2.add("Torvalds");
		atrib2.add("1991−06−06");
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
		
		//Pessoa
		List<String> atrib8 = new ArrayList();
		atrib8.add("95874123");
		atrib8.add("Knuth");
		atrib8.add("1910−06−06");
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
		
		//Pessoa
		List<String> atrib10 = new ArrayList();
		atrib10.add("10987312");
		atrib10.add("Bill Gates");
		atrib10.add("1960−01−05");
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
		
		//Professor
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
		
		//Professor
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
		
		//Professor
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
		
		//Professor IC
		List<String> atrib5 = new ArrayList();
		atrib5.add("P");
		atrib5.add("IC−1 01");
		List<String> primar5 = new ArrayList();
		primar5.add("020099");
		List<String> foren5 = new ArrayList();
		foren5.add("98763214587");
		TabelaInsert ins5 = new TabelaInsert();
		ins5.setTabela("T_PROFESSOR_IC");
		ins5.setAtributos(atrib5);
		ins5.setPrimaryKey(primar5);
		ins5.setForeignKey(foren5);
		
		//Professor IC
		List<String> atrib6 = new ArrayList();
		atrib6.add("D");
		atrib6.add("IC−1 02");
		List<String> primar6 = new ArrayList();
		primar6.add("444444");
		List<String> foren6 = new ArrayList();
		foren6.add("98632541754");
		TabelaInsert ins6 = new TabelaInsert();
		ins6.setTabela("T_PROFESSOR_IC");
		ins6.setAtributos(atrib6);
		ins6.setPrimaryKey(primar6);
		ins6.setForeignKey(foren6);
		
		//Visitante
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
		
		//Mestrando
		List<String> atrib11 = new ArrayList();
		atrib11.add("1");
		atrib11.add("1981");
		atrib11.add("1981−03−19");
		List<String> primar11 = new ArrayList();
		primar11.add("790099");
		List<String> foren11 = new ArrayList();
		foren11.add("790099");
		TabelaInsert ins11 = new TabelaInsert();
		ins11.setTabela("T_MESTRANDO");
		ins11.setAtributos(atrib11);
		ins11.setPrimaryKey(primar11);
		ins11.setForeignKey(foren11);
		
		//Aluno
		List<String> atrib12 = new ArrayList();
		atrib12.add("Co−autor de 19 artigos.");
		List<String> primar12 = new ArrayList();
		primar12.add("790099");
		List<String> foren12 = new ArrayList();
		foren12.add("74852963214");
		TabelaInsert ins12 = new TabelaInsert();
		ins12.setTabela("T_ALUNO");
		ins12.setAtributos(atrib12);
		ins12.setPrimaryKey(primar12);
		ins12.setForeignKey(foren12);
		
		
		List<TabelaInsert> inserts = new ArrayList();
		inserts.add(ins1);
		inserts.add(ins2);
		inserts.add(ins3);
		inserts.add(ins4);
		inserts.add(ins5);
		inserts.add(ins6);
		//inserts.add(ins7);
		inserts.add(ins10);
		inserts.add(ins12);
		inserts.add(ins11);
		
		
		List<String> respostas = new ArrayList(); 
		respostas.add("inicio");
		for(Tabela t: DBr){
			String opcao = JOptionPane.showInputDialog(null,"Se a tabela: " + t.getNome() + "\n" + "for principal digite (s). Senão, digite (n).");
			if(opcao.equals("s") || opcao.equals("S")){
				t.setPrincipal(true);
			}
		}
		
		TabelasParaMongo tabMong = new TabelasParaMongo(DBr, inserts);
		for(TabelaInsert t: inserts){
			tabMong.criarDocumento(t);
		}
		//System.out.println(tabMong.acharInsert(tab5, ins7));
		
		/*
		System.out.println("entrando no metodo...");
		for(Tabela t: DBr){
			if(t.isPrincipal()){
				System.out.println(t.getNome());
			}
		}
		for(int i=0; i<respostas.size(); i++){
			System.out.println(respostas.get(i));
		}
		*/

	}

}
