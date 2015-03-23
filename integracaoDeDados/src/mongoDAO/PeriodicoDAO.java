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
    	.append("qualis", p.getCirculacao())
    	.append("nome_periodico", p.getNome_periodico())
    	.append("nro_edicao", p.getNro_edicao())
    	.append("tipo", p.getTipo());
    coll.insert(doc);
	}
	
	/*public void atualizar(Periodico p){
		BasicDBObject query = new BasicDBObject("_id", p.getCod_publicacao());
		DBCursor cursor = coll.find(query);
	}*/
	
	public List<Periodico> buscar(String cod) {
	    /*BasicDBObject persistent = (BasicDBObject)coll.findOne(new ObjectId(cod));
	    Periodico per = new Periodico();
	    Set<String> keySet = persistent.keySet();
	    for(String key: keySet) {
	        Object value = persistent.get(key);
	        buildPeriodico(key, value, per);
	    }
	    Periodico per = new Periodico();
	    Set<String> keySet = cursor.curr()
	    for(String key: keySet) {
	        Object value = persistent.get(key);
	        buildPeriodico(key, value, per);
	    }
	    return per;*/
		
		List<Periodico> periodicos = new ArrayList<Periodico>();
		BasicDBObject obj1 = new BasicDBObject();
		obj1.put("_id", cod);
		//falta buscar pelo TIPO de periodico
		//?
	    DBCursor cursor = coll.find(obj1);
	    
	    while(cursor.hasNext()){
	    	DBObject obj2 = cursor.next();
	    	System.out.println(obj2.get("_id"));
	    	BasicDBList periodicoList = (BasicDBList) obj2.get("Publicacoes");
	    	System.out.println(periodicoList);
	    	for(int i=0; i<periodicoList.size(); i++){
	    		BasicDBObject obj3 = (BasicDBObject) periodicoList.get(i);
	    		
	    		Periodico per = new Periodico();
	    		per.setCod_publicacao((String) periodicoList.get("cod_publicacao"));
	     		per.setTitulo((String) periodicoList.get("titulo"));
	     		per.setMes((String) periodicoList.get("mes"));
	     		per.setAno((String) periodicoList.get("ano"));
	     		per.setUrl((String) periodicoList.get("url"));
	     		per.setVolume((String) periodicoList.get("volume"));
	    		per.setPagina_inicial((String) periodicoList.get("pagina_inicial"));
	    		per.setPagina_final((String) periodicoList.get("pagina_final"));
	    		per.setCirculacao((String) periodicoList.get("circulacao"));
	    		per.setQualis((String) periodicoList.get("qualis"));
	    		per.setNome_periodico((String) periodicoList.get("nome_periodico"));
	    		per.setNro_edicao((String) periodicoList.get("nro_edicao"));
	    		
	    		periodicos.add(per);
	    	}
	    }
	    return periodicos;	    
	}
	
	public Periodico buscar2(String cod) {
		Periodico per = new Periodico();
		BasicDBObject obj1 = new BasicDBObject();
		obj1.put("_id", cod);
	    DBCursor cursor = coll.find(obj1);
	    
	    while(cursor.hasNext()){
	    	DBObject obj2 = cursor.next();
	    	per.setCod_publicacao((String) obj2.get("cod_publicacao"));
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

}