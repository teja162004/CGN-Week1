package com.finance;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ForecastService service = new ForecastService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("📊 Monthly Financial Forecast:");
        List<ForecastRecord> forecasts = service.getForecast();
        for (ForecastRecord record : forecasts) {
            System.out.println(record);
        }

        System.out.printf("\nTotal Income: ₹%.2f\n", service.getTotalIncome());
        System.out.printf("Total Expenses: ₹%.2f\n", service.getTotalExpenses());
        System.out.printf("Total Savings: ₹%.2f\n", service.getTotalSavings());
        System.out.printf("Average Monthly Savings: ₹%.2f\n", service.getAverageSavings());

        // Predict next month
        System.out.println("\n🔮 Predicted Forecast for Next Month:");
        System.out.println(service.predictNextMonth());

        // Search month
        System.out.print("\nEnter a month to search: ");
        String month = scanner.nextLine();
        ForecastRecord found = service.searchByMonth(month);
        if (found != null) {
            System.out.println("🔍 Result: " + found);
        } else {
            System.out.println("❌ No data for " + month);
        }

        // Export report
        try {
            FileWriter writer = new FileWriter("forecast_report.txt");
            writer.write("📊 Financial Forecast Report\n");
            for (ForecastRecord record : forecasts) {
                writer.write(record.toString() + "\n");
            }
            writer.write(String.format("\nTotal Income: ₹%.2f", service.getTotalIncome()));
            writer.write(String.format("\nTotal Expenses: ₹%.2f", service.getTotalExpenses()));
            writer.write(String.format("\nTotal Savings: ₹%.2f", service.getTotalSavings()));
            writer.write(String.format("\nAverage Savings: ₹%.2f", service.getAverageSavings()));
            writer.write("\nPrediction: " + service.predictNextMonth());
            writer.close();
            System.out.println("\n✅ Report exported to forecast_report.txt");
        } catch (IOException e) {
            System.out.println("❌ Error writing report: " + e.getMessage());
        }

        scanner.close();
    }
}
