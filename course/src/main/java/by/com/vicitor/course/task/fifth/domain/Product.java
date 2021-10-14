package by.com.vicitor.course.task.fifth.domain;

import java.util.Objects;

public class Product {

    private String name;
    private double volume;
    private int cost;

    public Product(String name, double volume, int cost) {
        this.name = name;
        this.volume = volume;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, volume, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(volume, product.volume) &&
                Objects.equals(cost, product.cost);
    }
}
