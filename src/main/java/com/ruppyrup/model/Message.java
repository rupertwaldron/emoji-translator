package com.ruppyrup.model;


import com.ruppyrup.translator.Translator;

public class Message {

    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String decode(Translator translator) {
        return translator.decode(message);
    }

    public String encode(Translator translator) {
        return translator.encode(message);
    }
}
