package me.lucasggmoreira.locadoraveiculos.exceptions;

import me.lucasggmoreira.locadoraveiculos.models.Cliente;

public class ClienteNaoEncontradoException extends RuntimeException{
    private final String message;
    public ClienteNaoEncontradoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
