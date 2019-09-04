package br.com.psouza.exception;

/**
 * Representa um erro de parametros inválidos.
 */
public class ParameterInvalidException extends RuntimeException {

    /**
     * Serial Version ID.
     */
    private static final long serialVersionUID = 6066799985530739905L;

    /**
     * Construtor default.
     *
     * @param message mensagem do erro.
     */
    public ParameterInvalidException(String message) {
        super(message);
    }
}
