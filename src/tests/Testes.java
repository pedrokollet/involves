package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import app.Cidade;
import app.Tabela;
import app.UserReader;

public class Testes {

	@Test
	public void badFilterInput(){
		Tabela tabela = new Tabela();
		tabela.addInto(new Cidade("1100015","RO","Alta Floresta D'Oeste","","-61.9998238963","-11.9355403048","Alta Floresta D'Oeste","","Cacoal","Leste Rondoniense"));
		ArrayList<Cidade> teste = tabela.tabelaFiltrada("propriedadeInvalida", "valorInvalido");
		assertEquals(null,teste);
	}
	
	@Test
	public void badCountFilterInput(){
		Tabela tabela = new Tabela();
		tabela.addInto(new Cidade("1100015","RO","Alta Floresta D'Oeste","","-61.9998238963","-11.9355403048","Alta Floresta D'Oeste","","Cacoal","Leste Rondoniense"));
		int counter = tabela.countDistinct("FiltroInvalido");
		assertEquals(0,counter);
	}
	
	@Test
	public void goodCountFilterInput(){
		Tabela tabela = new Tabela();
		tabela.addInto(new Cidade("1100015","RO","Alta Floresta D'Oeste","","-61.9998238963","-11.9355403048","Alta Floresta D'Oeste","","Cacoal","Leste Rondoniense"));
		int counter = tabela.countDistinct("uf");
		assertEquals(1,counter);
	}
	
	@Test
	public void badCommandInput(){
		UserReader user = new UserReader();
		String resultadoEsperado = "Comando não reconhecido";
		String resultado = user.readInput("blaasf balsla aslfa", new Tabela());
		assertEquals(resultadoEsperado, resultado);
	}
}
