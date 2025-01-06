package br.edu.CadastroDeProduto.dto;

import br.edu.CadastroDeProduto.model.Produto;

public class ProdutoOutputDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Float valor;
    private String disponibilidade;

    public ProdutoOutputDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.disponibilidade = produto.getDisponibilidade();
    }

    public ProdutoOutputDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
