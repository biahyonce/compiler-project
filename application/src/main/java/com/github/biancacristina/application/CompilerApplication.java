package com.github.biancacristina.application;

import com.github.biancacristina.application.service.CompilerService;
import com.github.biancacristina.application.service.impl.CompilerServiceImpl;

public class CompilerApplication {

    public static void main(String[] args) {
        CompilerService compilerService = new CompilerServiceImpl();
        String code = compilerService.read("/input.txt");
        compilerService.compile(code);
    }
}
