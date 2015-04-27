package mongoDAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import conexoes.MongoDB;
import dominio.Mestrando;
import dominio.Periodico;

public class MestrandoDAO {
	MongoDB mongo = new MongoDB();
	DBCollection coll = null;
	
	public MestrandoDAO(){
		coll = mongo.alunos();
	}
	
	public void inserir(Mestrando m){
		BasicDBObject doc = new BasicDBObject("_id", m.getCPF())
    	.append("rg", m.getRG())
    	.append("data_nascimento", m.getData_nascimento())
    	.append("naturalidade", m.getNaturalidade())
    	.append("nacionalidade", m.getNacionalidade())
    	.append("usuario", m.getUsuario())
    	.append("senha", m.getSenha())
    	.append("perfil", m.getPerfil())
    	.append("email", m.getEmail())
    	.append("url", m.getUrl())
    	.append("ra", m.getRA())
    	.append("cod_situacao", m.getCod_situacao())
    	.append("info_complementares", m.getInfo_complementares())
    	.append("semestre_ingresso", m.getSemestre_ingresso())
    	.append("ano_ingresso", m.getAno_ingresso())
    	.append("data_ingresso", m.getData_ingresso())
    	.append("tipo", m.getTipo());
    coll.insert(doc);
	}
	
	public Mestrando buscarPorCPF(String cpf){
		Mestrando msc = new Mestrando();
		BasicDBObject query = new BasicDBObject("_id", cpf);
	    DBCursor cursor = coll.find(query);
	    
	    DBObject obj2 = cursor.next();
	    msc.setCPF((String) obj2.get("_id"));
	    msc.setRG((String) obj2.get("rg"));
 		msc.setData_nascimento((String) obj2.get("data_nascimento"));
 		msc.setNaturalidade((String) obj2.get("naturalidade"));
 		msc.setNacionalidade((String) obj2.get("nacionalidade"));
 		msc.setUsuario((String) obj2.get("usuario"));
 		msc.setSenha((String) obj2.get("senha"));
 		msc.setPerfil((String) obj2.get("perfil"));
		msc.setEmail((String) obj2.get("email"));
		msc.setUrl((String) obj2.get("url"));
		msc.setRA((String) obj2.get("ra"));
		msc.setCod_situacao((String) obj2.get("cod_situacao"));
		msc.setInfo_complementares((String) obj2.get("info_complementares"));
		msc.setSemestre_ingresso((String) obj2.get("semestre_ingresso"));
		msc.setAno_ingresso((String) obj2.get("ano_ingresso"));
		msc.setData_ingresso((String) obj2.get("data_ingresso"));
		
		return msc;
	}
	
	public List<Mestrando> buscarPorCampo(String campo, String valor) {
	    List<Mestrando> periodicos = new ArrayList<Mestrando>();
		BasicDBObject query = new BasicDBObject(campo, valor);
		
	    DBCursor cursor = coll.find(query);
	    
	    while(cursor.hasNext()){
	    	Mestrando msc = new Mestrando();
	    	
	    	DBObject obj2 = cursor.next();
	    	msc.setCPF((String) obj2.get("_id"));
		    msc.setRG((String) obj2.get("rg"));
	 		msc.setData_nascimento((String) obj2.get("data_nascimento"));
	 		msc.setNaturalidade((String) obj2.get("naturalidade"));
	 		msc.setNacionalidade((String) obj2.get("nacionalidade"));
	 		msc.setUsuario((String) obj2.get("usuario"));
	 		msc.setSenha((String) obj2.get("senha"));
	 		msc.setPerfil((String) obj2.get("perfil"));
			msc.setEmail((String) obj2.get("email"));
			msc.setUrl((String) obj2.get("url"));
			msc.setRA((String) obj2.get("ra"));
			msc.setCod_situacao((String) obj2.get("cod_situacao"));
			msc.setInfo_complementares((String) obj2.get("info_complementares"));
			msc.setSemestre_ingresso((String) obj2.get("semestre_ingresso"));
			msc.setAno_ingresso((String) obj2.get("ano_ingresso"));
			msc.setData_ingresso((String) obj2.get("data_ingresso"));
    		
    		periodicos.add(msc);
	    }
	    return periodicos;	    
	}

}
