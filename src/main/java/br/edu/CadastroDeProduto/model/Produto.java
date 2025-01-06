package br.edu.CadastroDeProduto.model;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;
    private String disponibilidade;

    public Produto(long id, Float valor, String nome, String descricao, String disponibilidade) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.descricao = descricao;
        this.disponibilidade = disponibilidade;
    }

    public Produto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
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

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
