package chris.api_agency.service;

import chris.api_agency.entitie.Destino;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final ArrayList<Destino> destinos = new ArrayList<>();

    public List<String> getAllDestinos() {
        return destinos.stream()
                .map(Destino::getNome)
                .collect(Collectors.toList());
    }

    public Destino getDestinoById(Long id_destino) {
        for (Destino destino : destinos) {
            if (destino.getId_destino().equals(id_destino)) {
                return destino;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado");
    }

    public Destino criarDestino(Destino destino) {
        destinos.add(destino);
        return destino;
    }

    public Destino avaliarDestino(Destino destino) {
        double avaliacao = destino.getAvaliacao();
        Long id_destino = destino.getId_destino();

        if (avaliacao > 10 || avaliacao < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Avaliação fora do intervalo permitido");
        }

        for (Destino procurarIdDestino : destinos) {
            if (procurarIdDestino.getId_destino().equals(id_destino)) {
                procurarIdDestino.getAvaliacoes().add(avaliacao);
                return procurarIdDestino;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado");
    }

    public void deleteDestinoById(Long id_destino) {
        Destino destino = destinos.stream()
                .filter(d -> d.getId_destino().equals(id_destino))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado"));
        
        destinos.remove(destino);
    }

    public List<Destino> pesquisarDestinos(String nome, String localizacao) {
        return destinos.stream()
                .filter(destino -> 
                    (nome == null || destino.getNome().toLowerCase().contains(nome.toLowerCase())) &&
                    (localizacao == null || 
                     destino.getLatitude().equalsIgnoreCase(localizacao) || 
                     destino.getLongitude().equalsIgnoreCase(localizacao)))
                .collect(Collectors.toList());
    }
    
    
}
