package br.usp.sistemasdeinformacao.estacioneaki.controller;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;
import br.usp.sistemasdeinformacao.estacioneaki.service.EstacionamentoService;
import br.usp.sistemasdeinformacao.estacioneaki.sistema.enums.DiaSemana;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author flavio
 */
@ManagedBean
@ViewScoped
public class CadastroEstacionamentoController {

    @ManagedProperty(value="#{estacionamentoService}")
    private EstacionamentoService estacionamentoService;
    
    private Estacionamento estacionamento;
    private Date domHoraInicio;
    private Date domHoraFim;
    private Date segHoraInicio;
    private Date segHoraFim;
    private Date terHoraInicio;
    private Date terHoraFim;
    private Date quaHoraInicio;
    private Date quaHoraFim;
    private Date quiHoraInicio;
    private Date quiHoraFim;
    private Date sexHoraInicio;
    private Date sexHoraFim;
    private Date sabHoraInicio;
    private Date sabHoraFim;
    
    private List<Boolean> horasVisivel;
    private List<String> dias;
    
    public CadastroEstacionamentoController() {
        this.estacionamento = new Estacionamento();
        horasVisivel = new ArrayList();
        for (int i = 0; i < 7; i++) {
            horasVisivel.add(Boolean.FALSE);
        }
        dias = new ArrayList();
    }
    
    public String gravar(){
        FacesContext context = FacesContext.getCurrentInstance();
        estacionamentoService.persist(estacionamento);
        context.addMessage(null, new FacesMessage("Estacionamento: "+estacionamento.getNome()+" cadastrado com sucesso", "Cadastro realizado com sucesso."));
        return "/pages/index";
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

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        for (int i = 0; i < 7; i++) {
            getHorasVisivel().set(i, Boolean.FALSE);
        }
        this.dias = dias;
        for (String dia : dias) {
            getHorasVisivel().set(DiaSemana.valueOf(dia.toUpperCase()).ordinal(), Boolean.TRUE);
        }
    }

    public List<Boolean> getHorasVisivel() {
        return horasVisivel;
    }

    public void setHorasVisivel(List<Boolean> horasVisivel) {
        this.horasVisivel = horasVisivel;
    }

    public Date getDomHoraInicio() {
        return domHoraInicio;
    }

    public void setDomHoraInicio(Date domHoraInicio) {
        this.domHoraInicio = domHoraInicio;
    }

    public Date getDomHoraFim() {
        return domHoraFim;
    }

    public void setDomHoraFim(Date domHoraFim) {
        this.domHoraFim = domHoraFim;
    }

    public Date getSegHoraInicio() {
        return segHoraInicio;
    }

    public void setSegHoraInicio(Date segHoraInicio) {
        this.segHoraInicio = segHoraInicio;
    }

    public Date getSegHoraFim() {
        return segHoraFim;
    }

    public void setSegHoraFim(Date segHoraFim) {
        this.segHoraFim = segHoraFim;
    }

    public Date getTerHoraInicio() {
        return terHoraInicio;
    }

    public void setTerHoraInicio(Date terHoraInicio) {
        this.terHoraInicio = terHoraInicio;
    }

    public Date getTerHoraFim() {
        return terHoraFim;
    }

    public void setTerHoraFim(Date terHoraFim) {
        this.terHoraFim = terHoraFim;
    }

    public Date getQuaHoraInicio() {
        return quaHoraInicio;
    }

    public void setQuaHoraInicio(Date quaHoraInicio) {
        this.quaHoraInicio = quaHoraInicio;
    }

    public Date getQuaHoraFim() {
        return quaHoraFim;
    }

    public void setQuaHoraFim(Date quaHoraFim) {
        this.quaHoraFim = quaHoraFim;
    }

    public Date getQuiHoraInicio() {
        return quiHoraInicio;
    }

    public void setQuiHoraInicio(Date quiHoraInicio) {
        this.quiHoraInicio = quiHoraInicio;
    }

    public Date getQuiHoraFim() {
        return quiHoraFim;
    }

    public void setQuiHoraFim(Date quiHoraFim) {
        this.quiHoraFim = quiHoraFim;
    }

    public Date getSexHoraInicio() {
        return sexHoraInicio;
    }

    public void setSexHoraInicio(Date sexHoraInicio) {
        this.sexHoraInicio = sexHoraInicio;
    }

    public Date getSexHoraFim() {
        return sexHoraFim;
    }

    public void setSexHoraFim(Date sexHoraFim) {
        this.sexHoraFim = sexHoraFim;
    }

    public Date getSabHoraInicio() {
        return sabHoraInicio;
    }

    public void setSabHoraInicio(Date sabHoraInicio) {
        this.sabHoraInicio = sabHoraInicio;
    }

    public Date getSabHoraFim() {
        return sabHoraFim;
    }

    public void setSabHoraFim(Date sabHoraFim) {
        this.sabHoraFim = sabHoraFim;
    }
    
}