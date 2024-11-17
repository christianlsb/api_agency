package chris.api_agency.controller;
import java.util.ArrayList;

import chris.api_agency.entitie.Destino;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destino")

public class DestinoController {
    ArrayList<Destino> destinos = new ArrayList<Destino>();

    @GetMapping()
    public ArrayList<Destino> getUsers() {
        return destinos;
    }

    @PostMapping()
    public Destino criarDestino(@RequestBody  Destino destino) {
        destinos.add(destino);
        return destino;
    }
}
