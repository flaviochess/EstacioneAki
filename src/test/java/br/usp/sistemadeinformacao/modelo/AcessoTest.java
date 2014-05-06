package br.usp.sistemadeinformacao.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Acesso;

public class AcessoTest {
	
	
	@Test(expected = NullPointerException.class)
	public void estacionamentoNaoEncontrado(){
		Acesso acesso = new Acesso();
		String emailEsperado = acesso.autentica("joaocarlos@gmail.com", "123").getEmail();
		assertEquals("joaocarlos@gmail.com",emailEsperado);
	}

}
