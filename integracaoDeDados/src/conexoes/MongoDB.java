package conexoes;

import java.net.UnknownHostException;


//import java.net.UnknownHostException;
import com.mongodb.*;


public class MongoDB {
	
	public DBCollection colecaoDocumentos(String colecao){
		MongoClientURI uri  = new MongoClientURI("mongodb://usuariomongo:secreto@ds061228.mongolab.com:61228/nosql_database");
	    MongoClient cliente = null;
	    
	    try {
			cliente = new MongoClient(uri);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    
	    DB db = cliente.getDB(uri.getDatabase());
	    DBCollection coll = db.getCollection(colecao);
	    
		return coll;
	}
	
	public DBCollection publicacoes(){
		MongoClientURI uri  = new MongoClientURI("mongodb://usuariomongo:secreto@ds061228.mongolab.com:61228/nosql_database");
	    MongoClient cliente = null;
	    
	    try {
			cliente = new MongoClient(uri);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    
	    DB db = cliente.getDB(uri.getDatabase());
	    DBCollection coll = db.getCollection("Publicacoes");
	    
		return coll;
	}
	
	public DBCollection alunos(){
		MongoClientURI uri  = new MongoClientURI("mongodb://usuariomongo:secreto@ds061228.mongolab.com:61228/nosql_database");
	    MongoClient cliente = null;
	    
	    try {
			cliente = new MongoClient(uri);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    
	    DB db = cliente.getDB(uri.getDatabase());
	    DBCollection coll = db.getCollection("Alunos");
	    
		return coll;
	}
	
	public DBCollection professores(){
		MongoClientURI uri  = new MongoClientURI("mongodb://usuariomongo:secreto@ds061228.mongolab.com:61228/nosql_database");
	    MongoClient cliente = null;
	    
	    try {
			cliente = new MongoClient(uri);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    
	    DB db = cliente.getDB(uri.getDatabase());
	    DBCollection coll = db.getCollection("Professores");
	    
		return coll;
	}
	
}