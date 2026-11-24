package com.madosan.gitsan.model.enums;

import com.madosan.gitsan.exceptions.InvalidCommandArgumentException;

import java.util.Locale;

public enum CommitType {
    FEAT("A new feature"),
    FIX("A bug fix"),
    DOCS("Documentation only changes"),
    REFACTOR("A code change that neither fixes a bug nor adds a feature"),
    CHORE("Other changes that don't modify src or test files");

    private final String description;

    CommitType(String description){
        this.description = description;
    }

    public String format(String message){
        return this.name().toLowerCase() + ": " + message.trim();
    }

    public static CommitType fromString(String input){
        try{
            return CommitType.valueOf(input.trim().toUpperCase());
        }catch (InvalidCommandArgumentException e){
            throw new InvalidCommandArgumentException("gitsan commit: invalid type '" + input + "'.");
        }
    }
}
