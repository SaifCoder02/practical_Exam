package hospital;

import java.time.LocalDate;

public class Medicine {
    private String name;
    private Double price;
    private Integer quantity;
    private String expirationDate;

    public Medicine(String name, Double price, Integer quantity, String expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
