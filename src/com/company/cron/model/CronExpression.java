package com.company.cron.model;

import com.company.cron.services.*;

import java.util.ArrayList;
import java.util.List;

public class CronExpression {
    List<Integer>minutes;
    List<Integer>hours;
    List<Integer>days;
    List<Integer>months;
    List<Integer> weekDays;
    String command;

    ExpressionParser minuteParser, hourParser, dayParser, monthParser, weekDayparser;

    public CronExpression() {
        this.minutes = new ArrayList<>();
        this.hours = new ArrayList<>();
        this.days = new ArrayList<>();
        this.months = new ArrayList<>();
        this.weekDays = new ArrayList<>();
        this.command = "";
        this.minuteParser = MinuteParser.getInstance();
        this.hourParser = HourParser.getInstance();
        this.dayParser = DayParser.getInstance();
        this.monthParser = MonthParser.getInstance();
        this.weekDayparser = WeekDayParser.getInstance();
    }

    public void decodeAndSetMinutes(String minuteExpression){
        if(minuteExpression.isEmpty() || !minuteParser.isValidExpression(minuteExpression))return;
        this.minutes = minuteParser.getParsedValue(minuteExpression);
    }

    public void decodeAndSetHours(String hourExpression){
        if(hourExpression.isEmpty() || !hourParser.isValidExpression(hourExpression))return;
        this.hours = hourParser.getParsedValue(hourExpression);
    }

    public void decodeAndSetDays(String dayExpression){
        if(dayExpression.isEmpty() || !dayParser.isValidExpression(dayExpression))return;
        this.days = dayParser.getParsedValue(dayExpression);
    }

    public void decodeAndSetMonths(String monthExpression){
        if(monthExpression.isEmpty() || !monthParser.isValidExpression(monthExpression))return;
        this.months = monthParser.getParsedValue(monthExpression);
    }

    public void decodeAndSetWeekDay(String weekDayExpression){
        if(weekDayExpression.isEmpty() || !dayParser.isValidExpression(weekDayExpression))return;
        this.weekDays = weekDayparser.getParsedValue(weekDayExpression);
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void printExpression(){
        if(!minutes.isEmpty()){
            System.out.print("minute       :");
            minutes.forEach((Integer minute) -> System.out.print(" " + minute));
        }
        System.out.println();
        if(!hours.isEmpty()){
            System.out.print("hour         :");
            hours.forEach((Integer hour) -> System.out.print(" " + hour));
            System.out.println();
        }

        if(!days.isEmpty()){
            System.out.print("day of month :");
            days.forEach((Integer day) -> System.out.print(" " + day));
            System.out.println();
        }

        if(!months.isEmpty()){
            System.out.print("month        :");
            months.forEach((Integer month) -> System.out.print(" " + month));
            System.out.println();
        }

        if(!weekDays.isEmpty()){
            System.out.print("day of week  :");
            weekDays.forEach((Integer week) -> System.out.print(" " + week));
            System.out.println();
        }

        if(!command.isEmpty()){
            System.out.print("command      :");
            System.out.println(command);
        }
    }
    public List<Integer> getMinutes() {
        return minutes;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public List<Integer> getDays() {
        return days;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public List<Integer> getWeekDays() {
        return weekDays;
    }

    public String getCommand() {
        return command;
    }
}
