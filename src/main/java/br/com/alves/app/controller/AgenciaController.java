package br.com.alves.app.controller;

import br.com.alves.app.http.service.AgenciaService;
import br.com.alves.domain.entity.Agencia;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/agencias")
public class AgenciaController {

    private AgenciaService agenciaService;

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    @POST
    public RestResponse<Void> cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
        this.agenciaService.cadastrar(agencia);

        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @GET
    @Path("/{id}")
    public RestResponse<Agencia> buscarPorId(Integer id) {
        Agencia agencia = this.agenciaService.buscarPorId(id);
        return RestResponse.ok(agencia);
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<Void> deletar(Integer id) {
        this.agenciaService.deletar(id);
        return RestResponse.ok();
    }

    @PUT
    public RestResponse<Void> alterar(Agencia agencia) {
        this.agenciaService.alterar(agencia);

        return RestResponse.noContent();
    }
}
