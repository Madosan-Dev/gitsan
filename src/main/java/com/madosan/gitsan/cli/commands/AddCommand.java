package com.madosan.gitsan.cli.commands;

import com.madosan.gitsan.cli.commands.interfaces.Commandable;
import com.madosan.gitsan.exceptions.InvalidCommandArgumentException;

public class AddCommand implements Commandable {

    @Override
    public void execute(String[] args) {

    }

    @Override
    public void validate(String[] args) {
        if(args.length > 2){
            throw new InvalidCommandArgumentException("gitsan add: too many arguments.");
        }
    }
}
