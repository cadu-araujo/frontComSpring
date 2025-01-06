package br.edu.CadastroDeProduto.dto;

import br.edu.CadastroDeProduto.model.Produto;

public class ProdutoInputDTO {

    private String nome;
    private String descricao;
    private Float valor;
    private String disponibilidade;

    public ProdutoInputDTO() {}

    public ProdutoInputDTO(String nome, String descricao, Float valor, String disponibilidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponibilidade = disponibilidade;
    }

    public Produto build(){
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setDisponibilidade(this.disponibilidade);
        produto.setValor(this.valor);
        return produto;
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
