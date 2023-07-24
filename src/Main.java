import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Product {
    private String type;
    private double price;
    private boolean discount;

    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Book", 200, false),
                new Product("Book", 300, true),
                new Product("Book", 150, true),
                new Product("Toy", 100, false)
        );

        Product cheapestBook = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Продукт [категорія: Book] не знайдено"));

        System.out.println("Type: " + cheapestBook.getType() + ", Price: " + cheapestBook.getPrice());
    }
}
