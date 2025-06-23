package br.ufma.ecp.jlox;

import java.util.List;

import static br.ufma.ecp.jlox.TokenType.*; 

class Parser {
    private static class ParseError extends RuntimeException {}

    private final List<Token> tokens;
    private int current = 0;

    Parser(List<Token> tokens) {
        this.tokens = tokens;
    }
}