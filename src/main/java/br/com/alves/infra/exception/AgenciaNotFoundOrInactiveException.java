package br.com.alves.infra.exception;

public class AgenciaNotFoundOrInactiveException extends RuntimeException {

    public AgenciaNotFoundOrInactiveException(String message) {
        super(message);
    }
}
