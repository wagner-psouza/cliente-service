package br.com.psouza.exception;

/**
 * Representa uma entidade não encontrada no sistema.
 */
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
