package br.com.alves.app.http.service.impl;

import br.com.alves.domain.entity.Agencia;

import br.com.alves.domain.enums.SituacaoCadastral;
import br.com.alves.domain.http.AgenciaHttp;
import br.com.alves.infra.exception.AgenciaNotFoundOrInactiveException;
import br.com.alves.app.http.service.AgenciaService;
import br.com.alves.app.http.service.SituacaoCadastralHttpService;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class AgenciaServiceImpl implements AgenciaService {

    @RestClient
    private SituacaoCadastralHttpService situacaoCadastralHttpService;

    private List<Agencia> agencias = new ArrayList<>();

    @Override
    public void cadastrar(Agencia agencia) {
        AgenciaHttp agenciaHttp = situacaoCadastralHttpService.buscarPorCnpj(agencia.getCnpj());

        if (agenciaHttp != null &&
                agenciaHttp.getSituacaoCadastral().equals(SituacaoCadastral.ATIVO)) {
            agencias.add(agencia);
        } else {
            throw new AgenciaNotFoundOrInactiveException("Agência não encontrada ou inativa!");
        }
    }

    @Override
    public Agencia buscarPorId(Integer id) {
        return agencias.stream()
                .filter(agencia -> agencia.getId().equals(id))
                .toList()
                .getFirst();
    }

    @Override
    public void deletar(Integer id) {
        agencias.removeIf(agencia -> agencia.getId().equals(id));
    }

    @Override
    public void alterar(Agencia agencia) {
        deletar(agencia.getId());
        cadastrar(agencia);
    }

}
