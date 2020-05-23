package ru.vnevzorov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vnevzorov.model.Product;
import ru.vnevzorov.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataBaseCreator {

    @Autowired
    ProductService productService;

    @PostConstruct
    public void init() {

        List<Product> products = new ArrayList<>();

        //В базу кладем условные продукты
        products.add(new Product("Samsung", "Galaxy s20", 73000.0, "white"));
        products.add(new Product("Samsung", "Galaxy s10", 60000.0, "white"));
        products.add(new Product("Samsung", "Galaxy A5", 15000.0, "black"));
        products.add(new Product("Apple", "iPhone X", 80000.0, "red"));
        products.add(new Product("Apple", "iPhone 8", 65000.0, "white"));
        products.add(new Product("Huawei", "P40 Lite", 10000.0, "green"));
        products.add(new Product("Xiaomi", "Redmi Note 8 Pro", 15000.0, "green"));
        products.add(new Product("Xiaomi", "MI 10", 35000.0, "blue"));
        products.add(new Product("Xiaomi", "MI 9", 27000.0, "white"));
        products.add(new Product("Xiaomi", "MI 8", 24000.0, "black"));
        products.add(new Product("Nokia", "3310", 2500.0, "black"));
        products.add(new Product("Nokia", "8110", 3000.0, "white"));

        products.forEach(product -> productService.save(product));

        //Записываем список производителей в bean ProductService
        Set<String> manufacturers = new HashSet<>();
        for (Product product : products) {
            String manufacturer = product.getManufacturer();
            manufacturers.add(manufacturer);
        }
        productService.setManufacturers(manufacturers);

        //Записываем мин и макс стоимость в bean ProductService
        Double minPrice = Double.MAX_VALUE;
        Double maxPrice = 0.0;

        for (Product product : products) {
            Double price = product.getPrice();
            if (price > maxPrice) {
                maxPrice = price;
            }
            if (price < minPrice) {
                minPrice = price;
            }
        }
        productService.setMaxPrice(maxPrice);
        productService.setMinPrice(minPrice);

        //Записываем список цветов в bean ProductService
        Set<String> colors = new HashSet<>();
        for (Product product : products) {
            String color = product.getColor();
            colors.add(color);
        }
        productService.setColors(colors);
    }
}
