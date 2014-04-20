package br.usp.sistemadeinformacao.modelo;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.usp.sistemasdeinformacao.estacioneaki.entity.StatusVaga;
import br.usp.sistemasdeinformacao.estacioneaki.entity.TipoVaga;
import br.usp.sistemasdeinformacao.estacioneaki.entity.Vaga;

/**
 * Testa todas as ações da classe Vaga
 * @author Willian
 *
 */
public class VagaTest {
	private Vaga ocupado;

	@Before
	public void inicia(){
		ocupado = new Vaga();
		DateTime hrEntrada = new DateTime(2014, 04, 19, 10, 11);
		ocupado.setCodigo("AC00");
		ocupado.setHrEntrada(hrEntrada);
		ocupado.setTipoVaga(TipoVaga.NORMAL);
		ocupado.setStatus(StatusVaga.OCUPADO);
	}
	
	@Test
	public void alteraStatusParaVago(){
		ocupado.alteraStatus();
		assertEquals(StatusVaga.VAGO, ocupado.getStatus());
	}
	
	@Test 
	public void alteraStatusParaOcupado(){
		ocupado.setStatus(StatusVaga.VAGO);
		ocupado.alteraStatus();
		assertEquals(StatusVaga.OCUPADO, ocupado.getStatus());
	}
	
	

}
