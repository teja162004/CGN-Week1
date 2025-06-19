package com.ecommerce;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();

        // Electronics
        productList.add(new Product(1, "iPhone 14", "Electronics", 89999));
        productList.add(new Product(2, "Samsung TV", "Electronics", 54999));
        productList.add(new Product(3, "Dell Laptop", "Electronics", 69999));
        productList.add(new Product(4, "Sony Headphones", "Electronics", 7999));
        productList.add(new Product(5, "HP Monitor", "Electronics", 9999));

        // Clothing
        productList.add(new Product(6, "Men's T-Shirt", "Clothing", 499));
        productList.add(new Product(7, "Women's Dress", "Clothing", 1499));
        productList.add(new Product(8, "Kids Jacket", "Clothing", 1199));
        productList.add(new Product(9, "Jeans", "Clothing", 1999));
        productList.add(new Product(10, "Hoodie", "Clothing", 1599));

        // Footwear
        productList.add(new Product(11, "Running Shoes", "Footwear", 4999));
        productList.add(new Product(12, "Formal Shoes", "Footwear", 2999));
        productList.add(new Product(13, "Sandals", "Footwear", 999));
        productList.add(new Product(14, "Sneakers", "Footwear", 3499));

        // Home Appliances
        productList.add(new Product(15, "Microwave Oven", "Home Appliances", 6999));
        productList.add(new Product(16, "Refrigerator", "Home Appliances", 23999));
        productList.add(new Product(17, "Washing Machine", "Home Appliances", 18999));

        // Books
        productList.add(new Product(18, "Java Programming", "Books", 499));
        productList.add(new Product(19, "Data Structures", "Books", 599));
        productList.add(new Product(20, "Python for Beginners", "Books", 699));
    }

    public List<Product> search(String keyword) {
        keyword = keyword.toLowerCase();
        List<Product> result = new ArrayList<>();

        for (Product product : productList) {
            if (product.getName().contains(keyword) || product.getCategory().contains(keyword)) {
                result.add(product);
            }
        }

        return result;
    }
}
