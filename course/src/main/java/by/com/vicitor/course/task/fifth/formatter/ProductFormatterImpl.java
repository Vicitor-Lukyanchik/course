package by.com.vicitor.course.task.fifth.formatter;

import java.util.List;

import by.com.vicitor.course.task.fifth.domain.Product;

public class ProductFormatterImpl implements ProductFormatter {

    private static final String VOLUME = "volume";
    private static final String COST = "cost";
    private static final char SPACE = ' ';
    private static final char COLON = ':';
    private static final char NEXT_LINE = '\n';
    private static final char TABULATION = '\t';

    public String formatProducts(List<Product> products) {
        StringBuilder result = new StringBuilder();
        for (Product product : products) {
            result.append(buildProduct(product));
        }
        return result.toString();
    }

    private String buildProduct(Product product) {
        return product.getName() + TABULATION + SPACE + VOLUME + COLON + SPACE + product.getVolume() + SPACE + COST
                + COLON + SPACE + product.getCost() + NEXT_LINE;
    }
}
