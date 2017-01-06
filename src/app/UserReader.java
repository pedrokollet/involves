package app;

import java.util.ArrayList;

public class UserReader {
	
	public UserReader(){
		System.out.println("Digite help para lista de funcionalidades.");
	}
	
	public String readInput(String input, Tabela table){
		String[] comando = input.split(" ");
		
		if(comando[0].equalsIgnoreCase("help")){
			return "Digite Count * para a contagem total de registros importados \n"+
			"Count distinct [propriedade] para o total de valores distintos da propriedade (coluna) enviada\n"+
			"Filter [propriedade] [valor] para todas as linhas em que a propriedade enviada possua o valor enviado";
		}else if(comando[0].equalsIgnoreCase("count")){
			if(comando.length > 2 && comando[1].equalsIgnoreCase("distinct")){
				return "Foram retornados "+table.countDistinct(comando[2])+" registros de "+ comando[2]+" diferentes.";
			} else if(comando.length > 1 && comando[1].equalsIgnoreCase("*")){
				return "A tabela contém "+table.count()+" registros importados.";
			} else {
				return "Comando não reconhecido";
			}
		}else if(comando[0].equalsIgnoreCase("filter")){
			if(comando.length == 3){
				return printResultadoFiltrado(table, comando[1], comando[2]);
			}else{
				return "Comando não reconhecido";
			}
		} else {
			return "Comando não reconhecido";
		}
	}
	
	public String printResultadoFiltrado(Tabela tabela, String comando1, String comando2){
		ArrayList<Cidade>table = tabela.tabelaFiltrada(comando1,  comando2);
		if(table != null){
			if(table.size() == 0){
				return "Nenhum resultado encontrado.";
			} else {
				System.out.println(tabela.cabecalho);
				for(Cidade c : table){
					System.out.println(c.toString());
			};
			}
		} else {
			return "Filtros de pesquisa inválidos. As colunas existentes são: " + tabela.cabecalho+".";
		}
		return "Tabela gerada com sucesso";
	}
}
