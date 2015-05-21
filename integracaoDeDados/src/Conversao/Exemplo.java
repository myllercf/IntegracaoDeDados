package Conversao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exemplo {
	
	public static void main(String[] args) {
		//File file = new File("C:/Users/mcf/Documents/IntegracaoDeDados/IntegracaoDeDados/teste.txt");
		//File file = new File("teste.txt");
		//File file = new File("C:\Users\mcf\Documents\IntegracaoDeDados\IntegracaoDeDados\teste.txt");
		File file = new File("/home/myller/esquema.txt");
		
		try{
			FileReader reader = new FileReader(file);
			BufferedReader input = new BufferedReader(reader);
			String linha;
			
			/*while ((linha = input.readLine()) != null){
				System.out.println(linha);
			}*/
			String str;
			 StringBuffer buf = new StringBuffer();
			 while (input.ready()) {
			  str = input.readLine();
			  buf.append(str);
			 }
			 //teste
			 System.out.println(buf.substring( 13+buf.indexOf("create table "), buf.indexOf("(") ));
			 
			input.close();
		} catch (IOException e){
			System.out.println(e);
		}
		/*try {
			String arquivo = 
					  new Scanner(new File("C:/Users/mcf/Documents/IntegracaoDeDados/IntegracaoDeDados/teste.txt"))
					             .useDelimiter("\\Z").next();
			System.out.println(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}