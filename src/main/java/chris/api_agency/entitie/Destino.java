package chris.api_agency.entitie;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "destinos")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_destino")
    private Long idDestino;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Boolean ativo;

    private String latitude;
    private String longitude;

    @Column(nullable = false)
    private double avaliacao;

    @ElementCollection
    @CollectionTable(name = "avaliacoes", joinColumns = @JoinColumn(name = "destino_id"))
    @Column(name = "avaliacao")
    private List<Double> avaliacoes = new ArrayList<>();

    public Destino() {}

    public Long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Double> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Double> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public double getMediaAvaliacao() {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        return avaliacoes.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
