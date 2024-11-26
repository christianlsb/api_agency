package chris.api_agency.entitie;

public class Reserva {
    private Long id;
    private Long idDestino;
    private String cliente;
    private int quantidadePessoas;
    private String dataReserva;

    public Reserva(Long id, Long idDestino, String cliente, int quantidadePessoas, String dataReserva) {
        this.id = id;
        this.idDestino = idDestino;
        this.cliente = cliente;
        this.quantidadePessoas = quantidadePessoas;
        this.dataReserva = dataReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
}
