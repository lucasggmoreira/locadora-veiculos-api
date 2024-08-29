package me.lucasggmoreira.locadoraveiculos.exceptions;

public class ClienteJaExistenteException extends RuntimeException{
    private final String message;

    public ClienteJaExistenteException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
