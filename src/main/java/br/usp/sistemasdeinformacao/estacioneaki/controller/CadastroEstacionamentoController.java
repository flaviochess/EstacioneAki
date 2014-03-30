package br.usp.sistemasdeinformacao.estacioneaki.controller;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;
import br.usp.sistemasdeinformacao.estacioneaki.service.EstacionamentoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author flavio
 */
@ManagedBean
@RequestScoped
public class CadastroEstacionamentoController {

    @ManagedProperty(value="#{estacionamentoService}")
    private EstacionamentoService estacionamentoService;
    
    private Estacionamento estacionamento;
    
    public CadastroEstacionamentoController() {
        this.estacionamento = new Estacionamento();
    }

    public void teste(){
        List estacionamentos = estacionamentoService.list();
        this.estacionamento.setNome(estacionamentoService.testeInjecao());
        System.out.println(estacionamentos);
    }
    
    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public EstacionamentoService getEstacionamentoService() {
        return estacionamentoService;
    }

    public void setEstacionamentoService(EstacionamentoService estacionamentoService) {
        this.estacionamentoService = estacionamentoService;
    }
    
}