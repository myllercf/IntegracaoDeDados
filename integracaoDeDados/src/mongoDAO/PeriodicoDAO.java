package mongoDAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import conexoes.MongoDB;
import dominio.Periodico;

public class PeriodicoDAO {
	MongoDB mongo = new MongoDB();
	DBCollection coll = null;
	
	
	public PeriodicoDAO(){
		coll = mongo.publicacoes();
	}
	
	public void inserir(Periodico p){
		BasicDBObject doc = new BasicDBObject("_id", p.getCod_publicacao())
    	.append("titulo", p.getTitulo())
    	.append("mes", p.getMes())
    	.append("ano", p.getAno())
    	.append("url", p.getUrl())
    	.append("volume", p.getVolume())
    	.append("pagina_inicial", p.getPagina_inicial())
    	.append("pagina_final", p.getPagina_final())
    	.append("circulacao", p.getCirculacao())
    	.append("qualis", p.getQualis())
    	.append("nome_periodico", p.getNome_periodico())
    	.append("nro_edicao", p.getNro_edicao())
    	.append("tipo", p.getTipo());
    coll.insert(doc);
	}
	
	public Periodico buscarPorCodigo(String cod) {
		Periodico per = new Periodico();
		BasicDBObject query = new BasicDBObject("_id", cod);
	    DBCursor cursor = coll.find(query);
	    
	    while(cursor.hasNext()){
	    	DBObject obj2 = cursor.next();
	    	per.setCod_publicacao((String) obj2.get("_id"));
     		per.setTitulo((String) obj2.get("titulo"));
     		per.setMes((String) obj2.get("mes"));
     		per.setAno((String) obj2.get("ano"));
     		per.setUrl((String) obj2.get("url"));
     		per.setVolume((String) obj2.get("volume"));
    		per.setPagina_inicial((String) obj2.get("pagina_inicial"));
    		per.setPagina_final((String) obj2.get("pagina_final"));
    		per.setCirculacao((String) obj2.get("circulacao"));
    		per.setQualis((String) obj2.get("qualis"));
    		per.setNome_periodico((String) obj2.get("nome_periodico"));
    		per.setNro_edicao((String) obj2.get("nro_edicao"));	    	
	    }
		
		return per;
	}
	
	public List<Periodico> buscarPorCampo(String campo, String valor) {
	    List<Periodico> periodicos = new ArrayList<Periodico>();
		BasicDBObject query = new BasicDBObject(campo, valor);
		
	    DBCursor cursor = coll.find(query);
	    
	    while(cursor.hasNext()){
	    	Periodico per = new Periodico();
	    	
	    	DBObject obj2 = cursor.next();
	    	per.setCod_publicacao((String) obj2.get("_id"));
     		per.setTitulo((String) obj2.get("titulo"));
     		per.setMes((String) obj2.get("mes"));
     		per.setAno((String) obj2.get("ano"));
     		per.setUrl((String) obj2.get("url"));
     		per.setVolume((String) obj2.get("volume"));
    		per.setPagina_inicial((String) obj2.get("pagina_inicial"));
    		per.setPagina_final((String) obj2.get("pagina_final"));
    		per.setCirculacao((String) obj2.get("circulacao"));
    		per.setQualis((String) obj2.get("qualis"));
    		per.setNome_periodico((String) obj2.get("nome_periodico"));
    		per.setNro_edicao((String) obj2.get("nro_edicao"));
    		
    		periodicos.add(per);
	    }
	    return periodicos;	    
	}
	
	public void atualizarPeriodico(String cod, Periodico p){
		Periodico per = new Periodico();
		BasicDBObject query = new BasicDBObject("_id", cod);
		
		BasicDBObject doc = new BasicDBObject("_id", p.getCod_publicacao())
    	.append("titulo", p.getTitulo())
    	.append("mes", p.getMes())
    	.append("ano", p.getAno())
    	.append("url", p.getUrl())
    	.append("volume", p.getVolume())
    	.append("pagina_inicial", p.getPagina_inicial())
    	.append("pagina_final", p.getPagina_final())
    	.append("circulacao", p.getCirculacao())
    	.append("qualis", p.getQualis())
    	.append("nome_periodico", p.getNome_periodico())
    	.append("nro_edicao", p.getNro_edicao())
    	.append("tipo", p.getTipo());
		
	    //DBCursor cursor = coll.find(query);
		DBObject cursor = coll.findAndModify(query, doc);		
	}
	
	/*public Periodico buscarUmPorCampo(String campo, String valor) {
		Periodico per = new Periodico();
		BasicDBObject obj1 = new BasicDBObject();
		obj1.put(campo, valor);
	    DBCursor cursor = coll.find(obj1);
	    
	    while(cursor.hasNext()){
	    	DBObject obj2 = cursor.next();
	    	per.setCod_publicacao((String) obj2.get("_id"));
     		per.setTitulo((String) obj2.get("titulo"));
     		per.setMes((String) obj2.get("mes"));
     		per.setAno((String) obj2.get("ano"));
     		per.setUrl((String) obj2.get("url"));
     		per.setVolume((String) obj2.get("volume"));
    		per.setPagina_inicial((String) obj2.get("pagina_inicial"));
    		per.setPagina_final((String) obj2.get("pagina_final"));
    		per.setCirculacao((String) obj2.get("circulacao"));
    		per.setQualis((String) obj2.get("qualis"));
    		per.setNome_periodico((String) obj2.get("nome_periodico"));
    		per.setNro_edicao((String) obj2.get("nro_edicao"));	    	
	    }
		
		return per;
	}*/

}