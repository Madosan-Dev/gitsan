package com.madosan.gitsan.cli.commands.enums;

import com.madosan.gitsan.exceptions.InvalidCommandArgumentException;

public enum CommandType {
    INIT("Start local repository"),
    ADD("Add local files to staging"),
    COMMIT("Register local changes"),
    LOG("Show history of commits"),
    DIFF("Show differences of commits");

    private final String description;

    CommandType(String description){
        this.description = description;
    }

    public static CommandType fromString(String input){
        if(input == null || input.isBlank()){
            throw new InvalidCommandArgumentException();
        }

        try {
            return CommandType.valueOf(input.trim().toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidCommandArgumentException("gitsan: '" + input + "' is not a gitsan command. See '--help'.");
        }
    }

    public String getDescription() {
        return description;
    }
}
