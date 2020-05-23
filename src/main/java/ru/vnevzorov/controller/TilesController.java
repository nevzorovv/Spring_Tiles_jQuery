package ru.vnevzorov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.vnevzorov.service.ProductService;
import ru.vnevzorov.service.WrapperService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TilesController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    ProductService productService;

    @Autowired
    WrapperService wrapperService;

    @GetMapping("/tiles")
    public ModelAndView tiles(@RequestParam(value = "enableFilter", required = false) String enableFilter,
                              @RequestParam(value = "manufacturer", required = false) List<String> chosenManufacturers,
                              @RequestParam(value = "minPrice", required = false) String minPrice,
                              @RequestParam(value = "maxPrice", required = false) String maxPrice,
                              @RequestParam(value = "color", required = false) List<String> chosenColors, HttpServletRequest request) {
        log.info("GET: " + request.getRequestURI());
        ModelAndView modelAndView = new ModelAndView("WEB-INF/products");

        if (enableFilter != null) {
            try {
                modelAndView.addObject("filteredProducts", productService.getByChosenFilterOptions(chosenManufacturers, minPrice, maxPrice, chosenColors));
            } catch (NumberFormatException e) {
                log.error("Wrong price format - fail during parsing to Double");
                modelAndView.addObject("priceFormatError", true);
                modelAndView.addObject("filteredProducts", productService.getAllProducts());
                return modelAndView;
            } finally {
                modelAndView.addObject("manufacturers", wrapperService.getManufacturersForFilter(chosenManufacturers));
                modelAndView.addObject("colors", wrapperService.getColorsForFilter(chosenColors));
                modelAndView.addObject("minPrice", minPrice);
                modelAndView.addObject("maxPrice", maxPrice);
            }
        } else {
            modelAndView.addObject("filteredProducts", productService.getAllProducts());
            modelAndView.addObject("manufacturers", wrapperService.getManufacturersForFilter(null));
            modelAndView.addObject("colors", wrapperService.getColorsForFilter(null));
            modelAndView.addObject("minPrice", productService.getMinPrice());
            modelAndView.addObject("maxPrice", productService.getMaxPrice());
        }

        return modelAndView;
    }

}