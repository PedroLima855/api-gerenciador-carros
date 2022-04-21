package br.com.gerenciador.gerenciador.repository;

import br.com.gerenciador.gerenciador.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
