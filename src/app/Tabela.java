package app;

import java.util.ArrayList;
import java.util.HashMap;

public class Tabela {
	ArrayList<Cidade> tabela;
	String cabecalho;
	
	public Tabela(){
		tabela = new ArrayList();
	}
	
	public void addInto(Cidade cidade){
		tabela.add(cidade);
	}
	
	public Integer count(){
		return tabela.size();
	}
	
	public Integer countDistinct(String filtro){
		HashMap<String, Integer> distinct = new HashMap<String, Integer>();
		
 		for(Cidade c : tabela){
			if(distinct.containsKey(c.retornaVar(filtro))){
				
				distinct.put(c.retornaVar(filtro),  distinct.get(c.retornaVar(filtro))+1);
			}else{
				if(c.retornaVar(filtro) == null){
					System.out.println("Filtro inválido.");
					return 0;
				}
				distinct.put(c.retornaVar(filtro), 1);
			}
		}
		return distinct.size();
	}
	
	public ArrayList<Cidade> tabelaFiltrada(String propriedade, String valor){
		ArrayList<Cidade> filtrado = new ArrayList<Cidade>();
		
		for(Cidade c : tabela){
			if(c.retornaVar(propriedade) == null){
				return null;
			}
				if(c.retornaVar(propriedade).equalsIgnoreCase(valor)){
					filtrado.add(c);
				}
			}
		return filtrado;
	}
}
