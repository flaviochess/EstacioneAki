package br.usp.sistemadeinformacao.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import br.usp.sistemasdeinformacao.estacioneaki.entity.ControleEstacionamento;
import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;
import br.usp.sistemasdeinformacao.estacioneaki.entity.StatusVaga;
import br.usp.sistemasdeinformacao.estacioneaki.entity.TipoVaga;
import br.usp.sistemasdeinformacao.estacioneaki.entity.Vaga;

public class ControleEstacionamentoTest {
	private Estacionamento est1;
	private Estacionamento est2;
	private ControleEstacionamento controle;
	private Vaga vaga;

	@Before
	public void inicializa(){
		controle = new ControleEstacionamento();
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
		
		
		est2 = new Estacionamento();
		est2.setNome("EstacioneAki");
		est2.setBairro("Centro");
		est2.setCidade("Mogi das Cruzes");
		est2.setEndereco("Rua Santana");
		est2.setCep("09876261");
		est2.setNumero(300);
		est2.setTelefone(new Long(47881123));
		est2.setUf("SP");
		est2.setValorPorHora(new BigDecimal(2.00));
		
		vaga = new Vaga();
		DateTime hrEntrada = new DateTime(2014, 04, 19, 10, 11);
		vaga.setCodigo("AC00");
		vaga.setHrEntrada(hrEntrada);
		vaga.setTipoVaga(TipoVaga.NORMAL);
		vaga.setStatus(StatusVaga.OCUPADO);
	}

	@Test
	public void geraVagas(){
		controle.setEstacionamento(est1);
		controle.geraVagas("ACD",30,TipoVaga.NORMAL);
		assertEquals(new Integer(30), new Integer(est1.getVagas().size()));
		assertEquals("ACD0", est1.getVagas().get(0).getCodigo());
	}
	

	@Test
	public void calculaValorDaHora(){
		DateTime hrSaida = new DateTime(2014, 04, 19, 13, 11);
		vaga.setHrSaida(hrSaida);
		est2.addVaga(vaga);
		controle.setEstacionamento(est2);
		BigDecimal cobrança = controle.calculaCobranca(vaga);
		assertEquals(new BigDecimal("6"), cobrança);
	}
	
	@Test
	public void liberaVaga(){
		DateTime hrSaida = new DateTime(2014, 04, 19, 13, 11);
		vaga.setHrSaida(hrSaida);
		vaga.alteraStatus();
		est2.addVaga(vaga);
		controle.setEstacionamento(est2);
		BigDecimal cobrança = controle.calculaCobranca(vaga);
		assertEquals(new BigDecimal("6"), cobrança);
		assertEquals(StatusVaga.VAGO,controle.getEstacionamento().getVagas().get(0).getStatus());
		
	}
	
}
