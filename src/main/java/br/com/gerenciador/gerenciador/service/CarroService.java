package br.com.gerenciador.gerenciador.service;

import br.com.gerenciador.gerenciador.entity.Carro;
import br.com.gerenciador.gerenciador.repository.CarroRepository;
import br.com.gerenciador.gerenciador.repository.CarroRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarroService {

    private CarroRepository carroRepository;

    private CarroRepositoryImpl carroRepositoryImpl;

    public Carro salvarCarro(Carro carro){
        return carroRepository.save(carro);
    }

    public List<Carro> pesquisarCarroPorMarcaOuModelo(String marca, String modelo){
        return carroRepositoryImpl.buscar(marca, modelo);
    }

}
