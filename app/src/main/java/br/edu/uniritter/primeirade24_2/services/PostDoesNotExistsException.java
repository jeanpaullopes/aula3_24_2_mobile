package br.edu.uniritter.primeirade24_2.services;

public class PostDoesNotExistsException extends Exception{
    public PostDoesNotExistsException() {
        super("O post não existe!");
    }
}
