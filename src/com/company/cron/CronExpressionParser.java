package com.company.cron;

import com.company.cron.model.CronExpression;

import java.util.Arrays;
import java.util.List;

public class CronExpressionParser {

    public static void main(String[] args) {
        System.out.println("Given cron expression: " + args[0] );
        String expression = args[0];
//        String expression = "1/15 0 1,15 * 1-5 /usr/bin/find";

        CronExpression cronExpression = getCronExpression(expression);
        cronExpression.printExpression();
    }
    public static CronExpression getCronExpression(String expression){
        CronExpression cronExpression = new CronExpression();
        List<String> expressionList = Arrays.stream(expression.split(" ")).toList();
        if(expressionList.size() != 6) return cronExpression;
        cronExpression.decodeAndSetMinutes(expressionList.get(0));
        cronExpression.decodeAndSetHours(expressionList.get(1));
        cronExpression.decodeAndSetDays(expressionList.get(2));
        cronExpression.decodeAndSetMonths(expressionList.get(3));
        cronExpression.decodeAndSetWeekDay(expressionList.get(4));
        cronExpression.setCommand(expressionList.get(5));
        return cronExpression;
    }
}
