package ru.vnevzorov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vnevzorov.model.wrapper.ColorWrapperForFilter;
import ru.vnevzorov.model.wrapper.ManufacturerWrapperForFilter;

import java.util.ArrayList;
import java.util.List;

@Service
public class WrapperService {

    @Autowired
    private ProductService productService;

    public List<ManufacturerWrapperForFilter> getManufacturersForFilter(List<String> chosenManufacturers) {
        List<ManufacturerWrapperForFilter> manufacturersForFilter = new ArrayList<>();
        if (chosenManufacturers == null) {
            for (String manufacturer : productService.getManufacturers()) {
                manufacturersForFilter.add(new ManufacturerWrapperForFilter(manufacturer, false));
            }
            return manufacturersForFilter;
        }
        for (String manufacturer : productService.getManufacturers()) {
            if (chosenManufacturers.contains(manufacturer)) {
                manufacturersForFilter.add(new ManufacturerWrapperForFilter(manufacturer, true));
            } else {
                manufacturersForFilter.add(new ManufacturerWrapperForFilter(manufacturer, false));
            }
        }
        return manufacturersForFilter;
    }

    public List<ColorWrapperForFilter> getColorsForFilter(List<String> chosenColors) {
        List<ColorWrapperForFilter> colorsForFilter = new ArrayList<>();
        if (chosenColors == null) {
            for (String color : productService.getColors()) {
                colorsForFilter.add(new ColorWrapperForFilter(color, false));
            }
            return colorsForFilter;
        }
        for (String color : productService.getColors()) {
            if (chosenColors.contains(color)) {
                colorsForFilter.add(new ColorWrapperForFilter(color, true));
            } else {
                colorsForFilter.add(new ColorWrapperForFilter(color, false));
            }
        }
        return colorsForFilter;
    }
}
