package com.github.biancacristina.compiler.syntax.grammar.request;

import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.impl.Production;
import com.github.biancacristina.compiler.syntax.grammar.impl.Terminal;

public class ItemRequest {
    private String label;

    public ItemRequest(String label) {
        this.label = label;
    }

    public ItemInterface toItem() {
        if (isProduction()) {
            return new Production(this.label);
        } else {
            return new Terminal(this.label, null); // TODO: Handle lexer
        }
    }

    public String getLabel() {
        return label;
    }

    private boolean isProduction() {
        return Character.isUpperCase(this.label.charAt(0));
    }
}
