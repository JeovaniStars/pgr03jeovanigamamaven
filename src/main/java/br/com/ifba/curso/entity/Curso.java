package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso extends PersistenceEntity {

    // O serialVersionUID, id, getId, setId, equals e hashCode são herdados de PersistenceEntity

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "quantidade_vagas")
    private int quantidade;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "fornecedor", length = 100)
    private String fornecedor;

    public Curso() {
    }

    public Curso(String nome, int quantidade, String descricao, String fornecedor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }

    // GETTERS E SETTERS (apenas para os campos desta classe)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}