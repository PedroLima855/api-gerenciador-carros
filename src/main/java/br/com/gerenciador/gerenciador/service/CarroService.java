package br.com.gerenciador.gerenciador.service;

import br.com.gerenciador.gerenciador.entity.Carro;
import br.com.gerenciador.gerenciador.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarroService {

    private CarroRepository carroRepository;

    public Carro salvarCarro(Carro carro){
        return carroRepository.save(carro);
    }

}
