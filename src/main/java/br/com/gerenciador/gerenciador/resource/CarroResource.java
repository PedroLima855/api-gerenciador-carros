package br.com.gerenciador.gerenciador.resource;

import br.com.gerenciador.gerenciador.entity.Carro;
import br.com.gerenciador.gerenciador.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Carro> salvarCarro(@RequestBody Carro carro) {
        Carro carroSalvo = carroService.salvarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroSalvo);
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.OK)
    public List<Carro> listarCarros(@RequestParam(value = "titulo", required = false) String marca,
                                    @RequestParam(value = "descricao", required = false) String modelo) {

        return carroService.pesquisarCarroPorMarcaOuModelo(marca, modelo);
    }

    @DeleteMapping("/{idCarro}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagarAluno(@PathVariable Long idCarro) {
        carroService.excluirCarro(idCarro);
    }

    @PutMapping("/{idCarro}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Carro> atualizarTarefa(@RequestBody Carro carro, @PathVariable Long idCarro) {

        Optional<Carro> retorno = carroService.findById(idCarro);

        if (!retorno.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Carro carroEditado = carroService.editarCarro(idCarro, carro);
        return ResponseEntity.ok(carroEditado);
    }
}
