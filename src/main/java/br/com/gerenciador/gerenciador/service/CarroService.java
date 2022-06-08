package br.com.gerenciador.gerenciador.service;

import br.com.gerenciador.gerenciador.entity.Carro;
import br.com.gerenciador.gerenciador.exception.CarroNotFoundException;
import br.com.gerenciador.gerenciador.repository.CarroRepository;
import br.com.gerenciador.gerenciador.repository.CarroRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void excluirCarro(Long idCarro) {
        carroRepository.findById(idCarro).orElseThrow(() -> new CarroNotFoundException(idCarro));
        carroRepository.deleteById(idCarro);
    }

}
