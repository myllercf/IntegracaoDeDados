package Conversao;

import java.util.ArrayList;
import java.util.List;

public class TabelasParaMongo {
	List<Tabela> DBrX, finais;
	List<String> campos;
	
	public TabelasParaMongo(){
		
	}
	
	public List<Tabela> tabelasFinais(List<Tabela> DBr){
		List<Tabela> ultimas = DBr;
		List<Tabela> remover = new ArrayList();
		List<String> estrangeiras = new ArrayList();
		
		for(Tabela tab: DBr){
			if(tab.getReferencias() != null){
				for(int i=0; i< tab.getReferencias().size(); i++){
					estrangeiras.add(tab.getReferencias().get(i));
				}
			}
		}
		
		for(Tabela tab2: ultimas){
			for(int i=0; i<estrangeiras.size(); i++){
				if(tab2.getNome().equals(estrangeiras.get(i))){
					remover.add(tab2);
				}
			}
		}
		return ultimas;
	}

}
