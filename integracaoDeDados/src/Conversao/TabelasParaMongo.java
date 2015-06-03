package Conversao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import conexoes.MongoDB;

public class TabelasParaMongo {
	List<Tabela> DBr;
	List<TabelaInsert> instancias;
	List<Tabela> entidades = new ArrayList();
	List<String> campos = new ArrayList();
	List<String> atributos = new ArrayList();
	MongoDB mongo = new MongoDB();
	
	public TabelasParaMongo(List<Tabela> DBr, List<TabelaInsert> instancias){
		this.DBr = DBr;
		this.instancias = instancias;
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
	
	
	public void criarDocumento(TabelaInsert inst){
		List<Tabela> ultimas = tabelasFinais();
		String tipo = null;
		
		for(Tabela tab: ultimas){
			if(inst.getTabela() == tab.getNome()){
				tipo = tab.getNome();
				while(!tab.isPrincipal()){
					for(int i=0; i<inst.getAtributos().size(); i++){
						campos.add(tab.getCampos().get(i));
						atributos.add(inst.getAtributos().get(i));
					}
					String chave = tab.getPrimaryKey().toString();
					System.out.println(tab.getNome());
					tab = acharTabela(tab.getReferencias().get(0));
					inst = acharInsert(tab, inst);
					if(tab.getPrimaryKey().toString() != chave){
						System.out.println("entra na checagem da chave");
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
	
	public void estabelecerRelacionamentos(TabelaInsert instancia){
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
							/*documento de instancia <- id da instancia de ref;
							 * usando o DBRef -> https://jira.mongodb.org/browse/JAVA-607
							 * API do DBCollection -> http://api.mongodb.org/java/current/com/mongodb/DBCollection.html
							*/
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
		if(tab.isPrincipal() && tab.getReferencias() != null){
			for(String ref: tab.getReferencias()){
				if(!ref.equals(tab.getNome())){
					Tabela tab2 = acharTabela(ref);
					
					while(!tab2.isPrincipal()){
						
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
	}
	
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