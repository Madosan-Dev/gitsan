package com.madosan.gitsan.model;

import java.time.Instant;
import java.util.Map;

public record Commit (
    String hash,
    String parentHash,
    Map<String, String> files, // caminho do arquivo -> hash do blob
    String author,
    Instant timestamp,
    String message
){
    public boolean isInitial() {
        return parentHash == null || parentHash.isBlank();
    }
}
