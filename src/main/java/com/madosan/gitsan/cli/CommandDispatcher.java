package com.madosan.gitsan.cli;

import com.madosan.gitsan.cli.commands.AddCommand;
import com.madosan.gitsan.cli.commands.CommitCommand;
import com.madosan.gitsan.cli.commands.InitCommand;
import com.madosan.gitsan.cli.commands.enums.CommandType;
import com.madosan.gitsan.cli.commands.interfaces.Commandable;
import com.madosan.gitsan.exceptions.InvalidCommandArgumentException;
import com.madosan.gitsan.storage.RepositoryStorage;

import java.util.Map;

public class CommandDispatcher {

    private final Map<CommandType, Commandable> commands;

    public CommandDispatcher(Map<CommandType, Commandable> commands) {
        this.commands = Map.of(
                CommandType.INIT, new InitCommand(new RepositoryStorage()),
                CommandType.ADD, new AddCommand(),
                CommandType.COMMIT, new CommitCommand()
        );
    }

    public void dispatch(String[] args){
        if(args == null || args.length == 0){
            throw new InvalidCommandArgumentException("gitsan: no command provided. Run '--help' for usage.");
        }

        CommandType type = CommandType.fromString(args[0]);
        Commandable command = commands.get(type);

        if(command == null){
            throw new InvalidCommandArgumentException("gitsan: command '" + type+ "' not implemented yet.");
        }

        command.validate(args);
        command.execute(args);
    }
}
