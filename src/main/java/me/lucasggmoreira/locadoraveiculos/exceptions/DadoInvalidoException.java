package me.lucasggmoreira.locadoraveiculos.exceptions;

public class DadoInvalidoException extends RuntimeException{
    private final String message;

    public DadoInvalidoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
