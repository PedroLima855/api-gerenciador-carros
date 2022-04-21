package br.com.gerenciador.gerenciador.resource;

import br.com.gerenciador.gerenciador.entity.Carro;
import br.com.gerenciador.gerenciador.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
