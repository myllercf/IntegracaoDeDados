package mongoDAO;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import dominio.Periodico;

public class TesteDAO {

	public static void main(String[] args) {
		/*MongoClientURI uri  = new MongoClientURI("mongodb://usuariomongo:secreto@ds061228.mongolab.com:61228/nosql_database");
	    MongoClient c = null;
	    
	    try {
			c = new MongoClient(uri);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	    PeriodicoDAO dao = new PeriodicoDAO();
	    Periodico per = new Periodico("001", "Banco de Dados",	"Março", "2015", "www.cin.ufpe.br", "volume 2", "pag 31", "pag 78", 
        		"todo territorio nacional", "B1", "periodico", "edicao");
		//dao.inserir(per);
		//System.out.println("gravou");
		
		System.out.println("buscando:");
		System.out.println(dao.buscar2("001").getCod_publicacao());
		System.out.println(dao.buscar2("001").getCod_publicacao());
	    /*for(int i=0; i<3; i++){
	    	System.out.println(dao.buscar2("001").get(i));
	    }*/
		//Periodico p = new Periodico(dao.buscar("001"));

	}

}