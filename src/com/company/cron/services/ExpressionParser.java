package com.company.cron.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * author Arpita Saha
 */
public abstract class ExpressionParser {
    List<Character> allowedCharacters;
    int maxRange;
    int minRange;

    public Boolean isValidExpression(String str) {
        for(Character c : str.toCharArray()){
            if(!allowedCharacters.contains(c) && !((c - '0') >= 0 || (c - '0') <= 9)  )
                return false;
        }
        return true;
    }
    public List<Integer> getParsedValue(String str) {
        List<Integer> values = new ArrayList<>();
        if(Pattern.matches("\\d+(,\\d+)*",  str)){
            values = Arrays.stream(str.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        }
        else if(Pattern.matches("\\d+-\\d+",  str)){
            List<Integer> valueRange  = Arrays.stream(str.split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            if(valueRange.get(0) >=minRange && valueRange.get(1) <=maxRange ){
                IntStream.rangeClosed(valueRange.get(0), valueRange.get(1)).forEach(values::add);
            }
        }
        else if(Pattern.matches("\\*",  str) ){
            IntStream.rangeClosed(minRange, maxRange).forEach(values::add);
        }
        else if(Pattern.matches("\\*/\\d+",  str) ) {
            List<String> valueRange = Arrays.stream(str.split("/")).toList();
            int incrementBy = Integer.parseInt(valueRange.get(1));
            for(int i = minRange; i>= minRange && i<=maxRange; i+=incrementBy)values.add(i);
        }
        else if(Pattern.matches("\\d+/\\d+",  str) ) {
            List<String> valueRange = Arrays.stream(str.split("/")).toList();
            int startFrom = Integer.parseInt(valueRange.get(0));
            int incrementBy = Integer.parseInt(valueRange.get(1));
            for(int i = startFrom; i>= minRange && i<=maxRange; i+=incrementBy)values.add(i);
        }
        else {
            values = performAdditionalParsing(str);
        }
        return values;
    }

    abstract List<Integer> performAdditionalParsing(String str);

}
