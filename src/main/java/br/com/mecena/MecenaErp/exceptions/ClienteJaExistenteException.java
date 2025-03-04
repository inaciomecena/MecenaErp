package br.com.mecena.MecenaErp.exceptions;


public class ClienteJaExistenteException extends RuntimeException {

    public ClienteJaExistenteException(String message) {
        super(message);
    }
}
