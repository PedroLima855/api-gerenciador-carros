package br.com.gerenciador.gerenciador.resource;

import br.com.gerenciador.gerenciador.entity.Carro;
import br.com.gerenciador.gerenciador.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @PostMapping()
    public ResponseEntity<Carro> salvarCarro(@RequestBody Carro carro) {
        Carro carroSalvo = carroService.salvarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroSalvo);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Carro> listarCarros(@RequestParam(value = "titulo", required = false) String marca,
                                    @RequestParam(value = "descricao", required = false) String modelo) {

        return carroService.pesquisarCarroPorMarcaOuModelo(marca, modelo);
    }
}
