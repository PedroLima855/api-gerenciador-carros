package br.com.gerenciador.gerenciador.repository;

import br.com.gerenciador.gerenciador.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
