package Conversao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;

import conexoes.MongoDB;

public class TabelasParaMongo {
	List<Tabela> DBr;
	List<TabelaInsert> instancias, relacionamento1, relacionamento2;
	List<Tabela> entidades = new ArrayList();
	List<String> campos = new ArrayList();
	List<String> atributos = new ArrayList();
	MongoDB mongo = new MongoDB();
	String colecaoMongo;
	TabelaInsert instanciaConversao;
	
	public TabelasParaMongo(List<Tabela> DBr, List<TabelaInsert> instancias){
		this.DBr = DBr;
		this.instancias = instancias;
	}
	
	public void conversao(TabelaInsert inst){
		if(EhPrincipal(inst.getTabela()) && !inst.isPersistido()){
			Tabela tabela = acharTabela(inst.getTabela());
			for(int i=0; i<tabela.getPrimaryKey().size(); i++){
				if(inst.getPrimaryKey().get(i) != null){
					campos.add(tabela.getPrimaryKey().get(i));
					atributos.add(inst.getPrimaryKey().get(i));
				}
			}
			for(int i=0; i<tabela.getCampos().size(); i++){
				if(inst.getAtributos().get(i) != null){
					campos.add(tabela.getCampos().get(i));
					atributos.add(inst.getAtributos().get(i));
				}
			}
			colecaoMongo = inst.getTabela();
			instanciaConversao = inst;
			navegarProfundidade(inst);
		}
	}
	
	
	public void navegarProfundidade(TabelaInsert inst) {
		TabelaInsert in = acharInstanciaAbaixo(inst);
		Tabela tab = acharTabela(in.getTabela());
		if (in != null && !in.isPersistido()) {
			switch (tab.getClassificacao()) {
			case "comum":
				for (int j = 0; j < tab.getPrimaryKey().size(); j++) {
					if (inst.getPrimaryKey().get(j) != null) {
						if (!campos.contains(tab.getPrimaryKey().get(j))) {
							campos.add(tab.getPrimaryKey().get(j));
							atributos.add(inst.getPrimaryKey().get(j));
						}
					}
				}
				for (int i = 0; i < tab.getCampos().size(); i++) {
					if (in.getAtributos().get(i) != null) {
						campos.add(tab.getCampos().get(i));
						atributos.add(in.getAtributos().get(i));
					}
				}
				in.setPersistido(true);
				break;
			case "subclasse":
				for (int j = 0; j < tab.getPrimaryKey().size(); j++) {
					if (inst.getPrimaryKey().get(j) != null) {
						if (!campos.contains(tab.getPrimaryKey().get(j))) {
							campos.add(tab.getPrimaryKey().get(j));
							atributos.add(in.getPrimaryKey().get(j));
						}
					}
				}
				for (int i = 0; i < tab.getCampos().size(); i++) {
					if (in.getAtributos().get(i) != null) {
						campos.add(tab.getCampos().get(i));
						atributos.add(in.getAtributos().get(i));
					}
				}
				in.setPersistido(true);
				break;
			default:
				break;
			}
			List<Tabela> lista = mensionaEstaTabela(tab);
			if (lista != null && !lista.isEmpty()) {
				navegarProfundidade(in);
			} else {
				campos.add("tipo");
				atributos.add(tab.getNome());
				navegarAcima(instanciaConversao);
			}
		}
	}
	
	//fazer mais testes
	public void navegarAcima(TabelaInsert instancia) {
		Tabela tabela = acharTabela(instancia.getTabela());
		if (tabela.getReferencias() != null && !tabela.getReferencias().isEmpty()) {
			for (String ref : tabela.getReferencias()) {
				Tabela tab = acharTabela(ref);
				TabelaInsert inst = acharInsert(tab, instancia);// testar aqui
				if (inst != null && !inst.isPersistido()) {
					switch (tab.getClassificacao()) {
					case "comum":
						for (int j = 0; j < inst.getPrimaryKey().size(); j++) {
							if (inst.getPrimaryKey().get(j) != null) {
								if (!campos.contains(tab.getPrimaryKey().get(j))) {
									campos.add(tab.getPrimaryKey().get(j));
									atributos.add(inst.getPrimaryKey().get(j));
								}
							}
						}
						for (int i = 0; i < inst.getAtributos().size(); i++) {
							if (inst.getAtributos().get(i) != null) {
								campos.add(tab.getCampos().get(i));
								atributos.add(inst.getAtributos().get(i));
							}
						}
						inst.setPersistido(true);
						break;
					case "subclasse":
						// navegar ate o topo e pegar o dbref
						inst.setPersistido(true);
						break;
					case "principal":
						relacionamento1.add(instanciaConversao);
						relacionamento2.add(inst);//continuaaa
						// inst.setPersistido(true);
						break;
					default:
						break;
					}
					if (tab.getReferencias() != null
							&& !tab.getReferencias().isEmpty()) {
						navegarAcima(inst);
					} else {
						for (int i = 0; i < atributos.size(); i++) {
							MongoDB mongo = new MongoDB();
							DBCollection coll = mongo
									.colecaoDocumentos(colecaoMongo);
							String concat = inst.getPrimaryKey().toString();
							BasicDBObject doc = new BasicDBObject();

							for (int j = 0; j < atributos.size(); j++) {
								if (atributos.get(j) != null) {
									doc.append(campos.get(j), atributos.get(j));
									System.out.println(campos.get(j));
									System.out.println(atributos.get(j));
									System.out.println("----------------");
								}
							}
							coll.insert(doc);
							campos.clear();
							atributos.clear();
						}
					}
				}
			}
		} else {
			for (int i = 0; i < atributos.size(); i++) {
				MongoDB mongo = new MongoDB();
				DBCollection coll = mongo
						.colecaoDocumentos(colecaoMongo);
				String concat = instancia.getPrimaryKey().toString();
				BasicDBObject doc = new BasicDBObject();

				for (int j = 0; j < atributos.size(); j++) {
					if (atributos.get(j) != null) {
						doc.append(campos.get(j), atributos.get(j));
						System.out.println(campos.get(j));
						System.out.println(atributos.get(j));
						System.out.println("----------------");
					}
				}
				coll.insert(doc);
				campos.clear();
				atributos.clear();
			}
		}
	}
	
	
	public void relacionamentoUmPara(){
		List<String> tabelas = obterPrincipais();
		for(TabelaInsert insert: instancias){
			if(tabelas.contains(insert.getTabela())){
				
			}
		}
	}
	
	
	/*public List<Tabela> obterPrincipais(){
		List<Tabela> listagem = new ArrayList();
		for(Tabela t: DBr){
			if(t.getClassificacao().equals("principal")){
				listagem.add(t);
			}
		}
		return listagem;
	}*/
	
	//outra abordagem. olhar o switch "principal" de navegarAcima
	public List<String> obterPrincipais(){
		List<String> listagem = new ArrayList();
		for(Tabela t: DBr){
			if(t.getClassificacao().equals("principal")){
				listagem.add(t.getNome());
			}
		}
		return listagem;
	}
	
	public List<Tabela> mensionaEstaTabela(Tabela t){
		List<Tabela> tabelas = new ArrayList();
		for(Tabela tab: DBr){
			if(tab.getReferencias().contains(t.getNome())){
				tabelas.add(tab);
			}
		}
		return tabelas;
	}
	
	public boolean EhPrincipal(String nome){
		for(Tabela t: DBr){
			if(t.getNome().equals(nome) && t.getClassificacao().equals("principal")){
				return true;
			}
		}
		return false;
	}
	
	public TabelaInsert acharInstanciaAbaixo(TabelaInsert inst){
		for(Tabela t: DBr){
			if(t.getReferencias().contains(inst.getTabela())){
				for(TabelaInsert i: instancias){
					if(i.getForeignKey() != null && i.getTabela().equals(t.getNome()) && i.getForeignKey().equals(inst.getPrimaryKey())){
						return i;
					}
				}
			}
		}
		return null;
	}
	
	//--------------------------------------------------------------------------------------------------
	
	public void criarDocumento(TabelaInsert inst){
		List<Tabela> ultimas = tabelasFinais();
		String tipo = null;
		
		for(Tabela tab: ultimas){
			if( (inst.getTabela() == tab.getNome()) && !(tab.getReferencias().size() >=2) ){
				tipo = tab.getNome();
				if(!tab.getCampos().equals(null) && !tab.getCampos().isEmpty()){
					for(int i=0; i<inst.getAtributos().size(); i++){
						campos.add(tab.getCampos().get(i));
						atributos.add(inst.getAtributos().get(i));
					}
				}
				while(!tab.getClassificacao().equals("principal")){
					/*for(int i=0; i<inst.getAtributos().size(); i++){
						campos.add(tab.getCampos().get(i));
						atributos.add(inst.getAtributos().get(i));
					}*/
					String chave = tab.getPrimaryKey().toString();
					//System.out.println(tab.getNome());
					tab = acharTabela(tab.getReferencias().get(0));
					inst = acharInsert(tab, inst);
					if(tab.getPrimaryKey().toString() != chave){
						//System.out.println("entra na checagem da chave");
						campos.add(chave.substring(1, chave.length()-1));
						atributos.add(inst.getPrimaryKey().get(0));
					}
				}
				entidades.add(tab);
				MongoDB mongo = new MongoDB();
				DBCollection coll = mongo.colecaoDocumentos(tab.getNome());
				String concat = inst.getPrimaryKey().toString();
				//BasicDBObject doc = new BasicDBObject("_id", concat.substring(1, concat.length()-1));
				BasicDBObject doc = new BasicDBObject();
				
				for(int i=0; i<inst.getPrimaryKey().size(); i++){
					doc.append(tab.getPrimaryKey().get(i), inst.getPrimaryKey().get(i));
				}
				
				for(int i=0; i<inst.getAtributos().size(); i++){
					if(inst.getAtributos().get(i) != null){
						doc.append(tab.getCampos().get(i), inst.getAtributos().get(i));
					}
				}				
				if(atributos != null && atributos.isEmpty() == false){
					for(int i=0; i<atributos.size(); i++){
						if(atributos.get(i) != null){
							doc.append(campos.get(i), atributos.get(i));
						}
					}
					doc.append("tipo", tipo);
					campos.clear();
					atributos.clear();
				}
				//coll.insert(doc);
				//System.out.println("tentou persistir");
			}
		}
	}
	
	
	public Tabela acharTabela(String ref){
		Tabela tab = null;
		for(Tabela tb: DBr){
			if(tb.getNome().equals(ref)){
				return tb;
			}
		}		
		return tab;
	}
	
	public TabelaInsert acharInsert(Tabela tab, TabelaInsert inst){
		TabelaInsert insert = null;
		for(TabelaInsert s: instancias){
			if(s.getTabela().equals(tab.getNome()) && s.getPrimaryKey().get(0).toString() == inst.getForeignKey().get(0).toString()){
				return s;
			}
		}
		return insert;
	}
	
	public void estabelecerRelacionamentos3(){
		for(TabelaInsert instancia: instancias){
			Tabela tabela = acharTabela(instancia.getTabela());
			
			if(tabela.getClassificacao().equals("principal") && !tabela.getReferencias().isEmpty()){
				for(String ref: tabela.getReferencias()){
					Tabela tab = acharTabela(ref);
					if(tab.getClassificacao().equals("principal") && tab.getNome() != tabela.getNome()){
						//passar DBRef para o documento
						System.out.println("referencia direta entre tabelas");
					}
				}
			}
			else if(!tabela.getClassificacao().equals("principal") && tabela.getReferencias().size() >=2){
				for(int i=0; i<instancia.getForeignKey().size(); i++){
					Tabela tab1 = acharTabela(tabela.getReferencias().get(i));
					if(tab1.getClassificacao().equals("principal")){
						for(int j=0; j<instancia.getForeignKey().size(); j++){
							Tabela tab2 = acharTabela(tabela.getReferencias().get(j));
							if( tab2.getClassificacao().equals("principal") && !tabela.getForeignKey().get(i).equals(tabela.getForeignKey().get(j)) ){
								
								/*System.out.println("i: " + i + ", j: " + j);
								System.out.println(tabela.getForeignKey().get(i));
								System.out.println(instancia.getForeignKey().get(i));
								System.out.println("---");
								System.out.println(tabela.getForeignKey().get(j));
								System.out.println(instancia.getForeignKey().get(j));
								*/
								
								BasicDBObject query1 = new BasicDBObject(tabela.getForeignKey().get(i), instancia.getForeignKey().get(i));
								BasicDBObject query2 = new BasicDBObject(tabela.getForeignKey().get(j), instancia.getForeignKey().get(j));
								
								DBCollection colecao1 = mongo.colecaoDocumentos(tab1.getNome());
								DBCollection colecao2 = mongo.colecaoDocumentos(tab2.getNome());
								
								//System.out.println(query2);
								DBCursor cursor1 = colecao1.find(query1);
								DBCursor cursor2 = colecao2.find(query2);
								
								//System.out.println(cursor2);
								
								DBObject obj1 = cursor1.one();
								DBObject obj2 = cursor2.one();
								
								DBRef ref = new DBRef(instancia.getForeignKey().get(j), obj2.get("_id"));
								
								BasicDBList lista = new BasicDBList();
								
								/*if(!obj1.get("relacionamentos").equals(null)){
									lista = (BasicDBList) obj1.get("relacionamentos");
								}*/
								/*try{
									lista = (BasicDBList) obj1.get("relacionamentos");
								}catch(NullPointerException e){
									
								}
								
								//System.out.println("ref-> "+ref);
								//System.out.println(obj1.get("relacionamentos"));
								//System.out.println("lista-> "+lista);
								//lista.add(ref);
								lista.put(0, ref);
								//lista(tab2.getNome(), ref);
								//System.out.println("lista-> "+lista);
								
								DBObject atualizacao = obj1;
								atualizacao.put("relacionamentos", lista);
								
								//collEdicao.update(new BasicDBObject("_id", obj.get("002")), new BasicDBObject("$set", new BasicDBObject("autores", ref)));
								colecao1.findAndModify(query1, atualizacao);
								*/
								//roteiro: http://stackoverflow.com/questions/10054301/update-an-array-using-mongodb 
								//http://stackoverflow.com/questions/13679265/update-a-list-field-in-mongodb-using-java
								BasicDBObject up = new BasicDBObject();
								up.put(tab2.getNome(), ref);
								BasicDBObject inserir = new BasicDBObject("$push", new BasicDBObject("relacionamentos", up));
								//colecao1.update(query1, inserir);
								
								System.out.println(ref);
							}
						}
					}
				}
			}
		}
	}
	
	//buscar as ultimas tabelas
		public List<Tabela> tabelasFinais(){
			List<Tabela> ultimas = new ArrayList();
			List<String> referencias = new ArrayList();
			
			for(Tabela tab: DBr){
				if(tab.getReferencias() != null){
					for(int i=0; i< tab.getReferencias().size(); i++){
						referencias.add(tab.getReferencias().get(i));
					}
				}
			}
			for(Tabela tab2: DBr){
				boolean temIgual = false;
				for(String ref: referencias){
					if(tab2.getNome().equals(ref)){
						temIgual = true;
					}
				}
				if(temIgual == false){
					ultimas.add(tab2);
				}
			}
			
			return ultimas;
		}
	
	/*public void estabelecerRelacionamentos(TabelaInsert instancia){
		for(Tabela tab: DBr){
			if(tab.isPrincipal() && tab.getReferencias() != null){
				for(String ref: tab.getReferencias()){
					if(!ref.equals(tab.getNome())){
						if(acharTabela(ref).isPrincipal()){
							TabelaInsert instanc = acharInsert(tab, instancia);
							MongoDB mongo = new MongoDB();
							BasicDBObject objEdicao = new BasicDBObject(tab.getPrimaryKey().toString(), instancia.getPrimaryKey().toString());
							BasicDBObject objBuscado = new BasicDBObject(tab.getPrimaryKey().toString(), instancia.getPrimaryKey().toString());
							DBCollection collEdicao = mongo.colecaoDocumentos(tab.getNome());
							DBCollection collBuscado = mongo.colecaoDocumentos(tab.getNome());
							//coll.
							//DBCursor cursor = coll.find(objEdicao);
							//while(cursor.hasNext()){
								
							//}
							//documento de instancia <- id da instancia de ref;
							//usando o DBRef -> https://jira.mongodb.org/browse/JAVA-607
							//API do DBCollection -> http://api.mongodb.org/java/current/com/mongodb/DBCollection.html
							
						}else{
							for(String ref2: acharTabela(ref).getReferencias()){
								if(ref2.equals(tab.getNome())){
									//documento de instancia <- id da instancia de ref;
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void estabelecerRelacionamentos2(TabelaInsert instancia){
		Tabela tab = acharTabela(instancia.getTabela());
		if(tab.isPrincipal() && !tab.getReferencias().equals(null) && !tab.getReferencias().isEmpty()){
			for(String ref: tab.getReferencias()){
				if(!ref.equals(tab.getNome())){
					Tabela tab2 = acharTabela(ref);
					
					while(!tab2.isPrincipal()){
						tab2 = acharTabela(tab2.getReferencias().get(0));
						//inst = acharInsert(tab, inst);
						TabelaInsert inst = acharInsert(tab2, instancia);
					}
					if(tab2.isPrincipal()){
						
						String campo1 = tab.getPrimaryKey().toString().substring(1, tab.getPrimaryKey().toString().length()-1);
						BasicDBObject objEdicao = new BasicDBObject(campo1, instancia.getPrimaryKey().get(0));
						
						String campo2 = tab2.getPrimaryKey().toString().substring(1, tab2.getPrimaryKey().toString().length()-1);
						TabelaInsert inst = acharInsert(tab2, instancia);
						BasicDBObject objReferenciado = new BasicDBObject(campo2, inst.getPrimaryKey().get(0));
						
						//MongoDB mongo = new MongoDB();
						DBCollection collEdicao = mongo.colecaoDocumentos(tab.getNome());
						DBCollection collReferenciadoo = mongo.colecaoDocumentos(tab.getNome());
						
						DBCursor cursor = collEdicao.find(objEdicao);
						DBObject obj = cursor.next();
						System.out.println(obj.get("_id"));
					}
				}
			}
		}
	}*/
	
	public void adicionarNovoCampo(String dbName, String collName, String docID, String key, String value) {
		mongo.getCliente().getDB(dbName).getCollection(collName).update(new BasicDBObject("_id", docID),
	                                                             new BasicDBObject("$set", new BasicDBObject(key, value)));
	}
	
	
	/*public void criarDocumentos(){
	List<Tabela> ultimas = tabelasFinais();
	
	for(Tabela tab: ultimas){
		novaTabela:
		if(tab.getForeignKey() == null){
			for(TabelaInsert inst: instancias){
				if(inst.getTabela() == tab.getNome()){
					MongoDB mongo = new MongoDB();
					DBCollection coll = mongo.colecaoDocumentos(tab.getNome());
					String concat = inst.getPrimaryKey().toString();
					BasicDBObject doc = new BasicDBObject("_id", concat.substring(1, concat.length()-1));
					for(int i=0; i<inst.getAtributos().size(); i++){
						if(inst.getAtributos().get(i) != null){
							doc.append(tab.getCampos().get(i), inst.getAtributos().get(i));
						}
					}
					if(atributos != null && atributos.isEmpty() != false){
						for(int i=0; i<atributos.size(); i++){
							if(atributos.get(i) != null){
								doc.append(campos.get(i), atributos.get(i));
							}
						}
						campos.clear();
						atributos.clear();
					}
					coll.insert(doc);
				}
			}
		} else{
			for(TabelaInsert inst2: instancias){
				if(inst2.getTabela() == tab.getNome()){
					for(int i=0; i<inst2.getAtributos().size(); i++){
						campos.add(tab.getCampos().get(i));
						atributos.add(inst2.getAtributos().get(i));
					}
					tab = acharTabela(tab.getReferencias().get(0));
					break novaTabela;
				}
			}
		}
	}
}*/
	
	
	/*public void transformarTabelas(TabelaInsert inst){
	List<Tabela> ultimas = tabelasFinais();
	String tipo = null;
	
	for(Tabela tab: ultimas){
		if(inst.getTabela() == tab.getNome()){
			novaTabela:
			if(tab.getForeignKey() == null){
				MongoDB mongo = new MongoDB();
				DBCollection coll = mongo.colecaoDocumentos(tab.getNome());
				String concat = inst.getPrimaryKey().toString();
				BasicDBObject doc = new BasicDBObject("_id", concat.substring(1, concat.length()-1));
				for(int i=0; i<inst.getAtributos().size(); i++){
					if(inst.getAtributos().get(i) != null){
						doc.append(tab.getCampos().get(i), inst.getAtributos().get(i));
					}
				}
				if(atributos != null && atributos.isEmpty() != false){
					for(int i=0; i<atributos.size(); i++){
						if(atributos.get(i) != null){
							doc.append(campos.get(i), atributos.get(i));
						}
					}
					doc.append("tipo", tipo);
					campos.clear();
					atributos.clear();
				}
				coll.insert(doc);
				break;//encerrar metodo
			} else{
				for(int i=0; i<inst.getAtributos().size(); i++){
					campos.add(tab.getCampos().get(i));
					atributos.add(inst.getAtributos().get(i));
				}
				tipo = tab.getNome();
				tab = acharTabela(tab.getReferencias().get(0));
				inst = acharInsert(tab, inst);
				break novaTabela;
			}
		}
	}
	
}*/

}