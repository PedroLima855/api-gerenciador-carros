package br.com.gerenciador.gerenciador.repository;

import br.com.gerenciador.gerenciador.entity.Carro;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarroRepositoryImpl {

    private final EntityManager manager;

    public CarroRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    public List<Carro> buscar(String marca, String modelo) {

        String query = "select C from Carro as C ";
        String condicao = "where";

        if (marca != null) {
            query += condicao + " UPPER(C.marca) LIKE CONCAT('%',UPPER(:marca),'%')";
            condicao = " and ";
        }

        if (modelo != null) {
            query += condicao + " UPPER(C.modelo) LIKE CONCAT('%',UPPER(:modelo),'%')";
        }

        TypedQuery<Carro> q = manager.createQuery(query, Carro.class);

        if (marca != null) {
            q.setParameter("marca", marca);
        }

        if (modelo != null) {
            q.setParameter("modelo", modelo);
        }

        return q.getResultList();
    }
}
