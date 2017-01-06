package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		UserReader user = new UserReader();
		Tabela table = new Tabela();
		String[] info = {"",""};
		URL url = Main.class.getResource("cidades.csv");
		try(BufferedReader br = new BufferedReader(new FileReader(new File(url.getPath())))) {
			//pular o header
			table.cabecalho = br.readLine();
		    for(String linha; (linha = br.readLine()) != null;) {
		    	info = linha.split(",");
				table.addInto(new Cidade(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9]));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(table.countDistinct("lat"));
			
		Scanner userInput = new Scanner(System.in);
		while(userInput.hasNext()){
			String comando = userInput.nextLine();
			if(comando.equalsIgnoreCase("exit") || comando.equalsIgnoreCase("sair")){
				break;
			}
			System.out.println(user.readInput(comando, table));
		}
	}
}
