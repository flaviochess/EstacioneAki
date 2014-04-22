package br.usp.sistemasdeinformacao.estacioneaki.entity;

import java.math.BigDecimal;
import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Controla as funcionalidades do Estacionamento
 * 
 * @author Willian
 * 
 */
public class ControleEstacionamento {
	private Estacionamento estacionamento;

	/**
	 * Gera código de vagas de acordo com o sufixo enviado do cliente<br>
	 * mais a quantidade de vagas
	 * 
	 * @param codigo
	 * @param qtdVagas
	 * @param tipoVaga
	 */
	public void geraVagas(String codigo, int qtdVagas, TipoVaga tipoVaga) {
		for (int i = 0; i < qtdVagas; i++) {
			Vaga vaga = new Vaga();
			vaga.setCodigo(codigo + i);
			vaga.setTipoVaga(tipoVaga);
			this.estacionamento.addVaga(vaga);
		}

	}

	public BigDecimal calculaCobranca(Vaga vaga) {
		BigDecimal tempo = diferencaTempo(vaga.getHrEntrada(),
				vaga.getHrSaida());
		return estacionamento.getValorPorHora().multiply(tempo);
	}

	private BigDecimal diferencaTempo(DateTime hrEntrada, DateTime hrSaida) {
		Duration duration = new Duration(hrEntrada.getMillis(),
				hrSaida.getMillis());
		return new BigDecimal(duration.getStandardHours());
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

}
