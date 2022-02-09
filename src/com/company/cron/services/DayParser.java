package com.company.cron.services;

import java.util.ArrayList;
import java.util.List;

/**
 * author Arpita Saha
 */
public class DayParser extends ExpressionParser{
    private static DayParser dayParser;
    private DayParser(){
        minRange = 1;
        maxRange = 31;
        allowedCharacters = new ArrayList<Character>();
        allowedCharacters.add('*');
        allowedCharacters.add('-');
        allowedCharacters.add('/');
        allowedCharacters.add(',');
    }

    public static DayParser getInstance(){
        if(dayParser == null){
            dayParser = new DayParser();
        }
        return dayParser;
    }

    @Override
    List<Integer> performAdditionalParsing(String str) {
        return new ArrayList<>();
    }
}
