package chris.api_agency.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import chris.api_agency.entitie.Destino;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public Destino criarDestino(@RequestBody  Destino destino) {
        destinos.add(destino);
        return destino;
    }
}