package br.edu.uniritter.primeirade24_2.services;

public class ModelDoesNotExistsException extends Exception{
    public ModelDoesNotExistsException(String model) {
        super("O dado de/a "+model+" não existe!");
    }
}
