package com.madosan.gitsan.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RepositoryStorage {
    private static final Path ROOT_DIR = Path.of(".gitsan");
    private static final Path OBJECTS_DIR = ROOT_DIR.resolve("objects");
    private static final Path REFS_DIR = ROOT_DIR.resolve("refs");
    private static final Path HEAD_FILE = ROOT_DIR.resolve("HEAD");

    public boolean isInitialized(){
        return Files.exists(ROOT_DIR) && Files.isDirectory(ROOT_DIR);
    }

    public void initStructure(){
        try{
            Files.createDirectories(OBJECTS_DIR);
            Files.createDirectories(REFS_DIR);
            Files.writeString(HEAD_FILE, "ref: refs/heads/main\n");
        }catch (IOException e) {
            throw new RuntimeException("gitsan: failed to initialize repository structure", e);
        }
    }
}
