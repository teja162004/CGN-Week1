package com.finance;

public class ForecastRecord {
    private String month;
    private double income;
    private double expenses;

    public ForecastRecord(String month, double income, double expenses) {
        this.month = month;
        this.income = income;
        this.expenses = expenses;
    }

    public String getMonth() {
        return month;
    }

    public double getIncome() {
        return income;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getSavings() {
        return income - expenses;
    }

    @Override
    public String toString() {
        return "Month: " + month +
                ", Income: " + income +
                ", Expenses: " + expenses +
                ", Savings: " + getSavings();
    }
}
