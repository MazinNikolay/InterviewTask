package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

public class Main {
    public static void main(String[] args) {
        String[] stringsArray = {
                "война и мир, Лев николаевич Толстой",
                "незнаЙка на луне, николай николаевич НоСов",
                "вий, Николай васильевич Гоголь"
        };
        Map<String, String> resMap = new HashMap<>();

        Arrays.stream(stringsArray).forEach(e ->
                resMap.put(upperCase(e.substring(0, e.indexOf(','))),
                        upperCaseFio(e.substring(e.indexOf(',') + 2))));

        for (String key : resMap.keySet()) {
            System.out.println("\"" + key + "\", " + resMap.get(key));
        }

    }

    public static String upperCase(String string) {
        return capitalize(string.toLowerCase());
    }

    public static String upperCaseFio(String string) {
        String[] arrString = string.split(" ");
        String resString = "";
        for (String s : arrString) {
            resString = resString.concat(upperCase(s)).concat(" ");
        }
        return resString.trim();
    }
}