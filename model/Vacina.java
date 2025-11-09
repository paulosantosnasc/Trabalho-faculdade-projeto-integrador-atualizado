package model;

import jakarta.persistence.*;

/**
 * Classe de vacina, usada nos cadastros e efeitos.
 */
@Entity
@Table(name = "vacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacina;

    @Column(nullable = false)
    private String nome;

    private String fabricante;
    private String lote;
    private int doses;

    // toString polimórfico
    @Override
    public String toString() {
        return "Vacina: " + nome + " | Lote Nº " + lote;
    }

    // getters/setters
    public int getIdVacina() { return idVacina; }
    public void setIdVacina(int idVacina) { this.idVacina = idVacina; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }

    public int getDoses() { return doses; }
    public void setDoses(int doses) { this.doses = doses; }
}
