package Conversao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import conexoes.MongoDB;

public class TabelasParaMongo {
	List<Tabela> DBr;
	List<TabelaInsert> instancias;
	List<String> campos = new ArrayList();
	List<String> atributos = new ArrayList();
	
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
	
	
	public void criarDocumentos(){
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
	}
	
	
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
					tab = acharTabela(tab.getReferencias().get(0));
					inst = acharInsert(tab, inst);
					if(tab.getPrimaryKey().toString() != chave){
						campos.add(chave.substring(1, chave.length()-1));
						atributos.add(inst.getPrimaryKey().get(0));
					}
				}
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
				System.out.println("tentou persistir");
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

}
