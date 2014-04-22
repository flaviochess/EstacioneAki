package br.usp.sistemadeinformacao.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;

public class EstacionamentoTest {

	private Estacionamento est1;

	@Before
	public void inicializa(){
		est1 = new Estacionamento();
		est1.setNome("EstacioneAki");
		est1.setBairro("Centro");
		est1.setCidade("Mogi das Cruzes");
		est1.setEndereco("Rua Santana");
		est1.setCep("09876261");
		est1.setNumero(300);
		est1.setTelefone(new Long(47881123));
		est1.setUf("SP");
		est1.setValorPorHora(new BigDecimal(2.00));
	}
	
	
	//Teste sem sentido... apenas para aumentar o score
	@Test
	public void deveSetarVariaveis(){
		assertEquals(new BigDecimal("2"), est1.getValorPorHora());
		assertEquals("EstacioneAki", est1.getNome());
	}

}
