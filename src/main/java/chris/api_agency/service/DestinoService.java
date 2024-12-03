package chris.api_agency.service;

import chris.api_agency.entitie.Destino;
import chris.api_agency.repository.DestinoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;

    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public List<String> getAllDestinos() {
        return destinoRepository.findAll().stream()
                .map(Destino::getNome)
                .toList();
    }

    public Destino getDestinoById(Long idDestino) {
        return destinoRepository.findById(idDestino)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado"));
    }

    public Destino criarDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    public Destino avaliarDestino(Destino destino) {
        Destino destinoExistente = destinoRepository.findById(destino.getIdDestino())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado"));

        double avaliacao = destino.getAvaliacao();

        if (avaliacao < 0 || avaliacao > 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Avaliação fora do intervalo permitido");
        }

        destinoExistente.getAvaliacoes().add(avaliacao);
        return destinoRepository.save(destinoExistente);
    }

    public void deleteDestinoById(Long idDestino) {
        if (!destinoRepository.existsById(idDestino)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado");
        }
        destinoRepository.deleteById(idDestino);
    }

    public List<Destino> pesquisarDestinos(String nome, String localizacao) {
        return destinoRepository.findAll().stream()
                .filter(destino -> 
                    (nome == null || destino.getNome().toLowerCase().contains(nome.toLowerCase())) &&
                    (localizacao == null || 
                     destino.getLatitude().equalsIgnoreCase(localizacao) || 
                     destino.getLongitude().equalsIgnoreCase(localizacao)))
                .toList();
    }
}
