package by.com.vicitor.course.task.fifth;

import java.util.Map;

import by.com.vicitor.course.task.fifth.domain.Product;
import by.com.vicitor.course.task.fifth.domain.Save;
import by.com.vicitor.course.task.fifth.filler.ProductsFiller;
import by.com.vicitor.course.task.fifth.filler.SaveFillerImpl;
import by.com.vicitor.course.task.fifth.formatter.ProductFormatter;
import by.com.vicitor.course.task.fifth.formatter.ProductFormatterImpl;
import by.com.vicitor.course.task.fifth.reader.ConsoleReader;

public class Application {

    public static void main(String[] args) {
        Save save = new Save(ConsoleReader.readSafeVolume());
        Map<Product, Integer> products = ProductsFiller.fillProducts();
        SaveFillerImpl saveFiller = new SaveFillerImpl();
        ProductFormatter productFormatter = new ProductFormatterImpl();

        System.out.println(productFormatter.formatProducts(saveFiller.fillSaveWithMaximumCost(products, save)));        
        System.out.println(save.toString());
    }
}
