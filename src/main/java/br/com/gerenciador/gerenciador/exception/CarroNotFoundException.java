package br.com.gerenciador.gerenciador.exception;

import javax.persistence.EntityNotFoundException;

public class CarroNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public CarroNotFoundException(String message) {
        super(message);
    }

    public CarroNotFoundException(Long idCarro) {
        this(String.format("não existe aluno com id %d", idCarro));
    }
}
