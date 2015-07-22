package Conversao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import conexoes.MongoDB;

public class TestesConsultas {

	public static void main(String[] args) {
		String colecaoMongo = "user";
		MongoDB mongo = new MongoDB();
		DBCollection coll1 = mongo.colecaoDocumentos("user");
		
		//usuario
		BasicDBObject doc1 = new BasicDBObject();
		
		doc1.append("_id", "01");
		doc1.append("nome", "sidartha");
		coll1.insert(doc1);
		
		//postagem
		DBCollection coll2 = mongo.colecaoDocumentos("post");
		BasicDBObject doc2 = new BasicDBObject();
		
		coll2.insert(doc2);
	}

}
