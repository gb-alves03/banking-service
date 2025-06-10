package br.com.alves.app.http.service;

import br.com.alves.domain.entity.Agencia;

public interface AgenciaService {

    void cadastrar(Agencia agencia);
    Agencia buscarPorId(Integer id);
    void deletar(Integer id);
    void alterar(Agencia agencia);
}
