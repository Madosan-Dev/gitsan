package com.madosan.gitsan.cli.commands;

import com.madosan.gitsan.cli.commands.interfaces.Commandable;
import com.madosan.gitsan.exceptions.InvalidCommandArgumentException;
import com.madosan.gitsan.exceptions.RepositoryStateException;
import com.madosan.gitsan.storage.RepositoryStorage;

public class InitCommand implements Commandable {

    private RepositoryStorage repoStorage;

    public InitCommand(RepositoryStorage repoStorage) {
        this.repoStorage = repoStorage;
    }

    @Override
    public void execute(String[] args) {
        if(repoStorage.isInitialized()){
            throw new RepositoryStateException();
        }

        repoStorage.initStructure();
        System.out.println("Initialized empty gitsan repository in .gitsan/");
    }

    @Override
    public void validate(String[] args) {
        if(args.length > 1){
            throw new InvalidCommandArgumentException("gitsan init: too many arguments.");
        }
    }
}
