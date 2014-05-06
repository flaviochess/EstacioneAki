package br.usp.sistemasdeinformacao.estacioneaki.entity;

import java.io.Serializable;

import br.usp.sistemasdeinformacao.estacioneaki.dao.EstacionamentoDAO;

/**
 * Procura Estacionamento para login.
 * @author Willian
 *
 */

public class Acesso implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Estacionamento autentica(String email, String senha) {
		try {
			Estacionamento estacionamento = existeEstacionamento(email, senha);
			if (validaEstacionamento(senha, estacionamento)) {
				System.out.println("Estacionamento pode acessar!");
				return estacionamento;
			}
		} catch (NullPointerException ex) {
			throw new NullPointerException("Estacionamento não encontrado");
		}
		return null;
	}

	private boolean validaEstacionamento(String senha, Estacionamento estacionamento) {
		return estacionamento.getSenha().toUpperCase().equals(senha.toUpperCase());
	}

	private Estacionamento existeEstacionamento(String email, String senha) {
		EstacionamentoDAO existeEstacionamento  = new EstacionamentoDAO();
		return existeEstacionamento.buscaEstacionamentoPorEmailESenha(email,senha);	
	}
	


	
}
