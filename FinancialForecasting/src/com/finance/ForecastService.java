package com.finance;

import java.util.ArrayList;
import java.util.List;

public class ForecastService {
    private List<ForecastRecord> records;

    public ForecastService() {
        records = new ArrayList<>();

        // Full year data
        records.add(new ForecastRecord("January", 50000, 35000));
        records.add(new ForecastRecord("February", 52000, 37000));
        records.add(new ForecastRecord("March", 48000, 36000));
        records.add(new ForecastRecord("April", 51000, 40000));
        records.add(new ForecastRecord("May", 53000, 38000));
        records.add(new ForecastRecord("June", 55000, 41000));
        records.add(new ForecastRecord("July", 56000, 42000));
        records.add(new ForecastRecord("August", 58000, 44000));
        records.add(new ForecastRecord("September", 59000, 43000));
        records.add(new ForecastRecord("October", 60000, 45000));
        records.add(new ForecastRecord("November", 62000, 46000));
        records.add(new ForecastRecord("December", 63000, 47000));
    }

    public List<ForecastRecord> getForecast() {
        return records;
    }

    public double getAverageSavings() {
        double total = 0;
        for (ForecastRecord record : records) {
            total += record.getSavings();
        }
        return total / records.size();
    }

    public double getTotalIncome() {
        return records.stream().mapToDouble(ForecastRecord::getIncome).sum();
    }

    public double getTotalExpenses() {
        return records.stream().mapToDouble(ForecastRecord::getExpenses).sum();
    }

    public double getTotalSavings() {
        return getTotalIncome() - getTotalExpenses();
    }

    public ForecastRecord searchByMonth(String month) {
        for (ForecastRecord r : records) {
            if (r.getMonth().equalsIgnoreCase(month)) {
                return r;
            }
        }
        return null;
    }

    public ForecastRecord predictNextMonth() {
        double avgIncome = getTotalIncome() / records.size();
        double avgExpenses = getTotalExpenses() / records.size();
        return new ForecastRecord("Next Month (Predicted)", avgIncome, avgExpenses);
    }
}
