package com.madosan.gitsan.cli.commands.interfaces;

public interface Commandable {
    void execute(String[] args);
    void validate(String[] args);
}
