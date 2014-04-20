/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.usp.sistemasdeinformacao.estacioneaki.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.joda.time.DateTime;

import br.usp.sistemasdeinformacao.estacioneaki.sistema.Entityable;

/**
 * Vagas do estacionamento.
 * @author Willian
 */
@Entity
public class Vaga implements Serializable, Entityable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String codigo;
	@Temporal(TemporalType.TIMESTAMP)
	private DateTime hrEntrada;
	@Temporal(TemporalType.TIMESTAMP)
	private DateTime hrSaida;
	@Enumerated(EnumType.STRING)
	private StatusVaga status;
	@Enumerated(EnumType.STRING)
	private TipoVaga tipoVaga;

	public Vaga(String codigo, DateTime hrEntrada, TipoVaga tipoVaga) {
		this.codigo = codigo;
		this.hrEntrada = hrEntrada;
		this.tipoVaga = tipoVaga;
		this.status = StatusVaga.VAGO;
	}

	public Vaga() {}

	
	/**
	 * Altera status da Vaga
	 * @author Willian
	 */
	public void alteraStatus() {
		if (status.equals(StatusVaga.OCUPADO)){
			status= StatusVaga.VAGO;
		}else{
			status = StatusVaga.OCUPADO;
		}
	}

	@Override
	public Integer getId() {
		return id;
	}

	public TipoVaga getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(TipoVaga tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public DateTime getHrEntrada() {
		return hrEntrada;
	}

	public void setHrEntrada(DateTime hrEntrada) {
		this.hrEntrada = hrEntrada;
	}

	public DateTime getHrSaida() {
		return hrSaida;
	}

	public void setHrSaida(DateTime hrSaida) {
		this.hrSaida = hrSaida;
	}

	public StatusVaga getStatus() {
		return status;
	}

	public void setStatus(StatusVaga status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
