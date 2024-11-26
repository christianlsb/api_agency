package chris.api_agency.controller;

import chris.api_agency.entitie.Destino;
import chris.api_agency.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destino")
public class DestinoController {
    private final DestinoService destinoService;

    @Autowired
    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @GetMapping()
    public List<String> getDestinos() {
        return destinoService.getAllDestinos();
    }

    @GetMapping(value = "/{id_destino}")
    public Destino detalhesDoDestino(@PathVariable Long id_destino) {
        return destinoService.getDestinoById(id_destino);
    }

    @PostMapping()
    public Destino criarDestino(@RequestBody Destino destino) {
        return destinoService.criarDestino(destino);
    }

    @PutMapping(value = "/avaliar")
    public Destino enviarAvaliacao(@RequestBody Destino destino) {
        return destinoService.avaliarDestino(destino);
    }

    @DeleteMapping(value = "/{id_destino}")
    public void deleteDestino(@PathVariable Long id_destino) {
        destinoService.deleteDestinoById(id_destino);
    }
    @GetMapping("/pesquisar")
        public List<Destino> pesquisarDestinos(
        @RequestParam(required = false) String nome,
        @RequestParam(required = false) String localizacao) {
    return destinoService.pesquisarDestinos(nome, localizacao);
}

}
