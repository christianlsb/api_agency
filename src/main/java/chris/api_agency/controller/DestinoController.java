package chris.api_agency.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import chris.api_agency.entitie.Destino;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/destino")

public class DestinoController {
    ArrayList<Destino> destinos = new ArrayList<>();

    @GetMapping()
    public List<String> getDestinos() {
        return destinos.stream()
                .map(Destino::getNome)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id_destino}")
    public Destino detalhesDoDestino(@PathVariable Long id_destino) {
        for (Destino destino : destinos) {
            if (destino.getId_destino().equals(id_destino)) {
                return destino;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado");
    }

    @PostMapping()
    public Destino criarDestino(@RequestBody Destino destino) {
        destinos.add(destino);
        return destino;
    }

    @PutMapping(value = "/avaliar")
    public Destino enviarAvaliacao(@RequestBody Destino destino) {

        double avaliacao = destino.getAvaliacao();
        Long id_destino = destino.getId_destino();

        if(avaliacao > 10 || avaliacao < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Avaliação fora do intervalo permitido");
        }

        for (Destino procurarIdDestino : destinos) {
            if (procurarIdDestino.getId_destino().equals(id_destino)) {
                procurarIdDestino.setAvaliacao(avaliacao);
                return procurarIdDestino;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Destino não encontrado");
    }
}
