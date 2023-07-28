package com.ruppyrup.controller;

import com.ruppyrup.model.Message;
import com.ruppyrup.translator.Translator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emoji")
public class EmojiController {

    private final Translator emojiTranslator;

    public EmojiController(Translator emojiTranslator) {
        this.emojiTranslator = emojiTranslator;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/encode/{text}")
    public String encode(@PathVariable String text) {
        Message message = new Message(text);
        return message.encode(emojiTranslator);
    }

    @GetMapping("/decode/{emojis}")
    public String decode(@PathVariable String emojis) {
        Message message = new Message(emojis);
        return message.decode(emojiTranslator);
    }

}
