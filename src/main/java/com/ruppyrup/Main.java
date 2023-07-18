package com.ruppyrup;


import net.fellbaum.jemoji.Emoji;
import net.fellbaum.jemoji.EmojiGroup;
import net.fellbaum.jemoji.EmojiManager;

public class Main {
    public static void main(String[] args) {

        Translator translator = new EmojiTranslator();

//        EmojiManager.getAllEmojisByGroup(EmojiGroup.SMILEYS_AND_EMOTION)
//                .stream()
//                .map(Emoji::getEmoji)
//                .map(String::strip)
//                .forEach(System.out::println);

        System.out.printf("Unicode: \u2764️\u200D\uD83D\uDD25");

        for (String arg : args) {
            Message message = new Message(arg);
            String encode = message.encode(translator);
            System.out.println(encode);

            Message encodedMessage = new Message(encode);
            System.out.println(encodedMessage.decode(translator));
        }



    }
}