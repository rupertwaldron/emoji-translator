package com.ruppyrup;

import com.vdurmont.emoji.EmojiParser;

public class Main {
    public static void main(String[] args) {

        Translator translator = new EmojiTranslator();

        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String result = EmojiParser.parseToUnicode(str);
        System.out.println(result);

        for (int i = 0; i < args.length; i++) {
            Message message = new Message(args[i]);
            String encode = message.encode(translator);
            System.out.println(encode);

            Message encodedMessage = new Message(encode);
            System.out.println(encodedMessage.decode(translator));
        }

    }
}