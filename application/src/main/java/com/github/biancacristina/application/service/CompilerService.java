package com.github.biancacristina.application.service;

public interface CompilerService {
    String read(String fileName);
    void compile(String code);
}
