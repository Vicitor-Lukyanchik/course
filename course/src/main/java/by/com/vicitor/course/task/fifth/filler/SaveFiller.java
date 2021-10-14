package by.com.vicitor.course.task.fifth.filler;

import java.util.List;
import java.util.Map;

import by.com.vicitor.course.task.fifth.domain.Product;
import by.com.vicitor.course.task.fifth.domain.Save;

public interface SaveFiller {
    List<Product> fillSaveWithMaximumCost(Map<Product, Integer> products, Save safe);
}
