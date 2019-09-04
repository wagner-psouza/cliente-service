package br.com.psouza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Representa uma entidade não encontrada no sistema.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    /**
     * Serial Version ID.
     */
    private static final long serialVersionUID = -4201371240028135903L;

    /**
     * Construtor default.
     *
     * @param message mensagem do erro.
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
