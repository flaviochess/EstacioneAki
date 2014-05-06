/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.usp.sistemasdeinformacao.estacioneaki.dao;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;
import br.usp.sistemasdeinformacao.estacioneaki.sistema.GenericDAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author flavio
 */
@Repository
public class EstacionamentoDAO extends GenericDAO<Estacionamento, Integer> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Estacionamento buscaEstacionamentoPorEmailESenha(String email,
			String senha) {
		if (!email.isEmpty() && !senha.isEmpty()) {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(Estacionamento.class);
			criteria.add(Restrictions.ilike("email", email));
			criteria.add(Restrictions.ilike("senha", senha));
			return (Estacionamento) criteria.uniqueResult();
		}
		return null;
	}
}
