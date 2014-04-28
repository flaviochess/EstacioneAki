package br.usp.sistemasdeinformacao.estacioneaki.webservice;

import br.usp.sistemasdeinformacao.estacioneaki.entity.Estacionamento;
import br.usp.sistemasdeinformacao.estacioneaki.service.EstacionamentoService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author flavio
 */
@Component
@Path("/estacionamentos")
public class EstacionamentosProximosService {

    @Autowired
    private EstacionamentoService estacionamentoService;
    
    @GET
    @Path("/proximos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estacionamento> getEstacionamentos(@QueryParam("latitude") String latitude, @QueryParam("longitude") String logitude){
        List<Estacionamento> estacionamentos;
        try {
            estacionamentos = estacionamentoService.list();
        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            estacionamentos = new ArrayList<Estacionamento>();
        }
        return estacionamentos;
    }
    
    @GET
    @Path("/proximos2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estacionamento> getEstacionamentosTeste(@QueryParam("latitude") String latitude, @QueryParam("longitude") String logitude){
        Estacionamento estacionamento1 = new Estacionamento();
        estacionamento1.setNome("Estacionamento 1");
        
        Estacionamento estacionamento2 = new Estacionamento();
        estacionamento2.setNome("Estacionamento 2");
        
        List<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
        estacionamentos.add(estacionamento1);
        estacionamentos.add(estacionamento2);
        return estacionamentos;
    }
}
