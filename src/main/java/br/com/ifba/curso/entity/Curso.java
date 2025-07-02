package br.com.ifba.curso.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa a entidade Curso para o banco de dados.
 *
 * @author Bruno
 */
@Entity
@Table(name = "cursos") // Define o nome da tabela no banco de dados
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    // GETTERS E SETTERS

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

    // --- MÉTODOS EQUALS E HASHCODE ---

    /**
     * Compara este Curso com outro objeto. A comparação é baseada apenas no ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    /**
     * Gera um código hash para o objeto, baseado apenas no ID.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}