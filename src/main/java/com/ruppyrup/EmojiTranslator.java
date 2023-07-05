package com.ruppyrup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmojiTranslator implements Translator {


    private static List<String> emojis = getStrings();
    private static final Map<String, String> encodedDict = fetchEncodeDictionary();
    private static final Map<String, String> decodeDict = fetchDecodeDictionary();

    @Override
    public String decode(String input) {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < input.length() / 2; i++) {
            String string = new StringBuilder().appendCodePoint(
                    input.codePointAt(input.offsetByCodePoints(0, i))).toString();

            sb.append(decodeDict.get(string));
        }
        return sb.toString();
    }

    @Override
    public String encode(String input) {
        StringBuilder sb = new StringBuilder();

        for (char c : input.toLowerCase().toCharArray()) {
            sb.append(encodedDict.getOrDefault(String.valueOf(c), "😇"));
        }
        return sb.toString();
    }


    private static Map<String, String> fetchEncodeDictionary() {

        return emojis.stream()
                .map(word -> word.split(":"))
                .collect(Collectors.toMap(tuple -> tuple[0], tuple -> tuple[1]));
    }

    private static Map<String, String> fetchDecodeDictionary() {
        return emojis.stream()
                .map(word -> word.split(":"))
                .collect(Collectors.toMap(tuple -> tuple[1], tuple -> tuple[0]));
    }

    private static List<String> getStrings() {
        try {
            emojis = Files.readAllLines(Paths.get("src/main/resources/emoji.dict"));
        } catch (IOException e) {
            System.out.println("Couldn't read emoji.dict :: " + e.getMessage());
        }
        return emojis;
    }
}
