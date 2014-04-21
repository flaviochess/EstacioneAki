package br.usp.sistemasdeinformacao.estacioneaki.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Vaga;
import br.usp.sistemasdeinformacao.estacioneaki.sistema.GenericDAO;

/**
 * 
 * @author Willian
 *
 */
@Repository
public class VagaDAO  extends GenericDAO<Vaga, Integer>{

	 @Autowired
	 private SessionFactory sessionFactory;
	
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
