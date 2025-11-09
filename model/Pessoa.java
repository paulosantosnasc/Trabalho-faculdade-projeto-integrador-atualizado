package model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * Classe base para pessoas.
 * Usuario herda daqui → demonstra herança.
 */
@MappedSuperclass
public class Pessoa {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "dataNascimento")
    private String dataNascimento;

    public Pessoa() {}

    public Pessoa(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // toString polimórfico
    @Override
    public String toString() {
        return "Pessoa: " + nome + " | CPF: " + cpf;
    }

    // getters/setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
}
