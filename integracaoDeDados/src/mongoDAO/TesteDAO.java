package mongoDAO;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
	    Periodico per = new Periodico("002", "Engenharia de Software",	"Março", "2015", "www.cin.ufpe.br", "volume 2", "pag 31", "pag 78", 
        		"todo territorio nacional", "B1", "periodico", "edicao");
		//dao.inserir(per);
		//System.out.println("gravou");
		
	    Periodico per2 = new Periodico();
		System.out.println("buscando:");
		//per2 = dao.buscarPorCodigo("001");
		//per2 = dao.buscarPorCampo("qualis", "B1");
		/*System.out.println(per2.getCod_publicacao());
		System.out.println(per2.getTitulo());
		System.out.println(per2.getMes());
		System.out.println(per2.getAno());
		System.out.println(per2.getUrl());
		System.out.println(per2.getVolume());
		System.out.println(per2.getPagina_inicial());
		System.out.println(per2.getPagina_final());
		System.out.println(per2.getCirculacao());
		System.out.println(per2.getQualis());
		System.out.println(per2.getNome_periodico());
		System.out.println(per2.getNro_edicao());
		System.out.println(per2.getTipo());*/
		
		List<Periodico> periodicos = new ArrayList<Periodico>();
		periodicos = dao.buscarPorCampo("qualis", "B1");
		for(int i=0; i<periodicos.size(); i++){
			System.out.println(periodicos.get(i).getTitulo());
		}
	    System.out.println("atualizando..");
		dao.atualizarPeriodico("002", new Periodico("002", "Interação Homem Maquina",	"Março", "2015", "www.cin.ufpe.br", "volume 2", "pag 31", "pag 78", 
        		"todo territorio nacional", "B1", "periodico", "edicao"));
		
		periodicos = dao.buscarPorCampo("qualis", "B1");
		for(int i=0; i<periodicos.size(); i++){
			System.out.println(periodicos.get(i).getTitulo());
		}
		
	}

}