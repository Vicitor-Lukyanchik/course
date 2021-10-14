package by.com.vicitor.course.task.fifth.filler;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import by.com.vicitor.course.task.fifth.domain.Product;
import by.com.vicitor.course.task.fifth.domain.Save;

import java.util.Set;
import java.util.TreeSet;

public class SaveFillerImpl implements SaveFiller {

    @Override
    public List<Product> fillSaveWithMaximumCost(Map<Product, Integer> products, Save save) {
        List<Product> ratingValuableProducts = sortProductsByValuaCost(calculateMostValuableProducts(products));
        return fillSave(products, ratingValuableProducts, save);
    }

    private Map<Double, Product> calculateMostValuableProducts(Map<Product, Integer> products) {
        Map<Double, Product> result = new LinkedHashMap<>();
        for (Entry<Product, Integer> product : products.entrySet()) {
            double valuaCost = product.getKey().getCost() / product.getKey().getVolume();
            result.put(valuaCost, product.getKey());
        }
        return result;
    }

    private List<Product> sortProductsByValuaCost(Map<Double, Product> valuaCostProducts) {
        Set<Double> valuaCosts = new TreeSet<>(valuaCostProducts.keySet());
        List<Product> result = new LinkedList<>();
        for (Double valuaCost : valuaCosts) {
            result.add(valuaCostProducts.get(valuaCost));
        }
        return reverseList(result);
    }

    private List<Product> reverseList(List<Product> products) {
        List<Product> result = new LinkedList<>();
        for (int i = products.size() - 1; i >= 0; i--) {
            result.add(products.get(i));
        }
        return result;
    }

    private List<Product> fillSave(Map<Product, Integer> products, List<Product> ratingValuableProducts, Save save) {
        List<Product> result = new LinkedList<>();
        for (Product product : ratingValuableProducts) {
            for (int i = 0; i < products.get(product); i++) {
                if (save.addProduct(product)) {
                    result.add(product);
                }
            }
        }
        return result;
    }
}
