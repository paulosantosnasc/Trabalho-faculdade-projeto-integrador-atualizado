package model;

import jakarta.persistence.*;

/**
 * Classe de efeitos adversos relacionados à vacina aplicada.
 */
@Entity
@Table(name = "efeito_adverso")
public class EfeitoAdverso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEfeito;

    private String descricao;
    private String intensidade; 
    private String dataRelato;

    // polimorfismo
    @Override
    public String toString() {
        return "Efeito: " + descricao + " (" + intensidade + ")";
    }

    // getters/setters
    public int getIdEfeito() { return idEfeito; }
    public void setIdEfeito(int idEfeito) { this.idEfeito = idEfeito; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getIntensidade() { return intensidade; }
    public void setIntensidade(String intensidade) { this.intensidade = intensidade; }

    public String getDataRelato() { return dataRelato; }
    public void setDataRelato(String dataRelato) { this.dataRelato = dataRelato; }
}
