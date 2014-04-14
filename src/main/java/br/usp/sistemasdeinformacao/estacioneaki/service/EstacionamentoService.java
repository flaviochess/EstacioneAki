package br.usp.sistemasdeinformacao.estacioneaki.service;

import br.usp.sistemasdeinformacao.estacioneaki.dao.EstacionamentoDAO;
import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author flavio
 */
@Service
@Transactional(readOnly = true)
public class EstacionamentoService {
    
    @Autowired
    private EstacionamentoDAO estacionamentoDAO;
    
    public String testeInjecao(){
        return "Injeção funcionando";
    }
    
    public List<Estacionamento> list(){
        return estacionamentoDAO.list();
    }

    @Transactional
    public void persist(Estacionamento estacionamento){
        estacionamentoDAO.persist(estacionamento);
    }
    
    public Estacionamento update(Estacionamento estacionamento){
        return estacionamento = (Estacionamento) estacionamentoDAO.update(estacionamento);
    }
    
}
