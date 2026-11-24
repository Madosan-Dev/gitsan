package com.madosan.gitsan.exceptions;

public class RepositoryStateException extends RuntimeException{

    public RepositoryStateException(){
        super("gitsan: repository already initialized.");
    }

    public RepositoryStateException(String message){
        super(message);
    }
}
