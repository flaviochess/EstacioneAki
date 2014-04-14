package br.usp.sistemasdeinformacao.estacioneaki.controller;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;
import br.usp.sistemasdeinformacao.estacioneaki.service.EstacionamentoService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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

    public void gravar(ActionEvent actionEvent){
        FacesContext context = FacesContext.getCurrentInstance();
        estacionamentoService.persist(estacionamento);
        context.addMessage(null, new FacesMessage("Sucesso", "Cadastro realizado com sucesso."));
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