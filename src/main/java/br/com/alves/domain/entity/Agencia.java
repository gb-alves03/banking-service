package br.com.alves.domain.entity;

public class Agencia {

    private Integer id;
    private String nome;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
