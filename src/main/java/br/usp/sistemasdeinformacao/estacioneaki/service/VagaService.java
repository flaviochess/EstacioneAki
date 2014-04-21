package br.usp.sistemasdeinformacao.estacioneaki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.usp.sistemasdeinformacao.estacioneaki.dao.VagaDAO;
import br.usp.sistemasdeinformacao.estacioneaki.entity.Vaga;

@Service
@Transactional(readOnly = true)
public class VagaService {

	@Autowired
	private VagaDAO vagaDao;

	public List<Vaga> list() {
		return vagaDao.list();
	}

	@Transactional
	public void persist(Vaga vaga) {
		vagaDao.persist(vaga);
	}

	public Vaga update(Vaga vaga) {
		return vaga = (Vaga) vagaDao.update(vaga);
	}

}
