package ru.vnevzorov.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vnevzorov.model.Product;
import ru.vnevzorov.repository.ProductRepo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    ProductRepo productRepo;

    @Autowired
    PullConnection pullConnection;

    Set<String> manufacturers;
    Double minPrice;
    Double maxPrice;
    Set<String> colors;

    public void save(Product product) {
        productRepo.save(product);
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Iterable<Product> getAllByManufacturer(String manufacturer) {
        return productRepo.findAllByManufacturer(manufacturer);
    }

    public Iterable<Product> getAllByModel(String model) {
        return productRepo.findAllByModel(model);
    }

    public Iterable<Product> getAllByPriceBetween(String from, String to) {
        return productRepo.findAllByPriceBetween(Double.parseDouble(from), Double.parseDouble(to));
    }

    public void setManufacturers(Set<String> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Set<String> getManufacturers() {
        return manufacturers;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Set<String> getColors() {
        return colors;
    }

    public void setColors(Set<String> colors) {
        this.colors = colors;
    }

    public List<Product> getByManufacturer(String manufacturer) {
        return productRepo.findAllByManufacturer(manufacturer);
    }

    public List<Product> getByChosenFilterOptions(List<String> manufacturers,
                                         String minPrice,
                                         String maxPrice,
                                         List<String> colors) throws NumberFormatException{

        if (minPrice == null) {
            minPrice = "";
        }
        if (maxPrice == null) {
            maxPrice = "";
        }
        //if (!minPrice.equals("") && !maxPrice.equals("")) {
            if (Double.parseDouble(minPrice) < 0 || Double.parseDouble(maxPrice) < 0) {
                log.error("Wrong price format - price can not be negative");
                throw new NumberFormatException();
            }
        //}

        try (Connection connection = pullConnection.getPullConnection().getConnection()) {
            Statement stmt = connection.createStatement();

            //Составление адаптивного запроса
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM product WHERE ");
            boolean atLeastOneParameterExists = false;

            if (manufacturers != null) {
                if (manufacturers.size() > 1) {
                    query.append("(");
                }
                for (int i = 0; i < manufacturers.size(); i++) {
                    String manufacturer = manufacturers.get(i);
                    if (i == manufacturers.size() - 1) {
                        query.append("MANUFACTURER = '" + manufacturer + "'");
                        atLeastOneParameterExists = true;
                    } else {
                        query.append("MANUFACTURER = '" + manufacturer + "' OR ");
                    }
                }
                if (manufacturers.size() > 1) {
                    query.append(")");
                }
            }
            if (minPrice != null && minPrice.length() > 0) {
                if (atLeastOneParameterExists) {
                    query.append(" AND price >= " + minPrice);
                } else {
                    query.append("price >= " + minPrice);
                    atLeastOneParameterExists = true;
                }
            }
            if (maxPrice != null && maxPrice.length() > 0) {
                if (atLeastOneParameterExists) {
                    query.append(" AND price <= " + maxPrice);
                } else {
                    query.append("price <= " + maxPrice);
                    atLeastOneParameterExists = true;
                }
            }
            if (colors != null) {
                if (atLeastOneParameterExists) {
                    query.append(" AND ");
                }
                if (colors.size() > 1) {
                    query.append("(");
                }
                for (int i = 0; i < colors.size(); i++) {
                    String color = colors.get(i);
                    if (i == colors.size() - 1) {
                        query.append("color = '" + color + "'");
                        atLeastOneParameterExists = true;
                    } else {
                        query.append("color = '" + color + "' OR ");
                    }
                }
                if (colors.size() > 1) {
                    query.append(")");
                }
            }
            log.info("Execute query: " + query.toString());
            ResultSet resultSet = stmt.executeQuery(query.toString());

            return convertResultSetToProducts(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Product> convertResultSetToProducts(ResultSet resultSet) {
        List<Product> products = new ArrayList<>();
        try{
            while (resultSet.next()) {
                Product filteredProduct = new Product();
                filteredProduct.setId(Long.parseLong(resultSet.getString("ID")));
                filteredProduct.setManufacturer(resultSet.getString("MANUFACTURER"));
                filteredProduct.setModel(resultSet.getString("MODEL"));
                filteredProduct.setPrice(Double.parseDouble(resultSet.getString("PRICE")));
                filteredProduct.setColor(resultSet.getString("COLOR"));
                products.add(filteredProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return products;
    }
}
