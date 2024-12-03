package chris.api_agency.service;

import chris.api_agency.entitie.Reserva;
import chris.api_agency.entitie.Destino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {
    private final ArrayList<Reserva> reservas = new ArrayList<>();
    private final DestinoService destinoService;

    public ReservaService(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    public Reserva criarReserva(Long idDestino, Reserva reserva) {
        Destino destino = destinoService.getDestinoById(idDestino);
        if (!destino.getAtivo()) {
            throw new IllegalArgumentException("Não é possível reservar pacotes para um destino inativo.");
        }

        reserva.setId((long) (reservas.size() + 1));
        reserva.setIdDestino(idDestino);
        reservas.add(reserva);
        return reserva;
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    public Reserva getReservaById(Long id) {
        return reservas.stream()
            .filter(r -> r.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public List<Reserva> listarReservasPorDestino(Long idDestino) {
        return reservas.stream()
                .filter(r -> r.getIdDestino().equals(idDestino)) 
                .toList();
    }
}
