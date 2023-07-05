package com.ruppyrup;

public class Main {
    public static void main(String[] args) {

        Translator translator = new EmojiTranslator();
        Message message = new Message("Hello World");
        String encode = message.encode(translator);
        System.out.println(encode);

        Message encodedMessage = new Message(encode);
        System.out.println(encodedMessage.decode(translator));

    }
}