package chris.api_agency.entitie;

import jakarta.persistence.*;

@Entity
@Table(name = "pacotes_de_viagem")
public class PacoteDeViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pacote_de_viagem")
    private int idPacoteDeViagem;

    @ManyToOne
    @JoinColumn(name = "id_destino", nullable = false)
    private Destino destino;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private Boolean ativo;

    public int getIdPacoteDeViagem() {
        return idPacoteDeViagem;
    }

    public void setIdPacoteDeViagem(int idPacoteDeViagem) {
        this.idPacoteDeViagem = idPacoteDeViagem;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
