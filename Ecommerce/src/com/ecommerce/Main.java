package com.ecommerce;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();

        List<Product> results = service.search(keyword);

        if (results.isEmpty()) {
            System.out.println("No products found for: " + keyword);
        } else {
            System.out.println("Search results:");
            for (Product p : results) {
                System.out.println(p);
            }
        }

        scanner.close();
    }
}
