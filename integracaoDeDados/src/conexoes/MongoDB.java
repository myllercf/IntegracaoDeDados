package conexoes;

import java.net.UnknownHostException;


//import java.net.UnknownHostException;
import com.mongodb.*;


public class MongoDB {
	private MongoClientURI uri;
	MongoClient cliente;
	DB db;
	
	public DBCollection colecaoDocumentos(String colecao){
		uri  = new MongoClientURI("mongodb://usuariomongo:secreto@ds061228.mongolab.com:61228/nosql_database");
	    cliente = null;
	    
	    try {
			cliente = new MongoClient(uri);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    
	    db = cliente.getDB(uri.getDatabase());
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

	public MongoClientURI getUri() {
		return uri;
	}

	public void setUri(MongoClientURI uri) {
		this.uri = uri;
	}

	public MongoClient getCliente() {
		return cliente;
	}

	public void setCliente(MongoClient cliente) {
		this.cliente = cliente;
	}

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}
	
}