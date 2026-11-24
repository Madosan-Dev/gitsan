package com.madosan.gitsan.cli.commands.enums;

public enum CommandType {
    INIT("Inicia o repositorio local"),
    ADD("Adiciona os arquivos "),
    COMMIT("Resgistra uma alteração"),
    LOG("Mostra o histórico de commits"),
    DIFF("Mostra a diferença dos commits");

    private final String description;

    CommandType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
