package chris.api_agency.entitie;

import java.util.ArrayList;

public class Destino {
    private Long id_destino;
    private String nome;
    private Boolean ativo;
    private String latitude;
    private String longitude;
    private double avaliacao;
    private ArrayList<Double> avaliacoes = new ArrayList<>();

    public Long getId_destino() {
        return id_destino;
    }

    public void setId_destino(Long id_destino) {
        this.id_destino = id_destino;
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


    public ArrayList<Double> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Double> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public double getMediaAvaliacao() {
        if (avaliacoes.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Double avaliacao : avaliacoes) {
            soma += avaliacao;
        }
        return soma / avaliacoes.size();
    }

}


