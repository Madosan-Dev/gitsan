package com.madosan.gitsan.exceptions;

public class InvalidCommandArgumentException extends IllegalArgumentException{

    public InvalidCommandArgumentException(){
        super("gitsan: invalid command or arguments. Run '--help' for usage.");
    }

    public InvalidCommandArgumentException(String message){
        super(message);
    }
}
