package ru.vnevzorov.model.wrapper;

public class ManufacturerWrapperForFilter {

    String manufacturer;
    boolean checked;

    public ManufacturerWrapperForFilter(String manufacturer, boolean checked) {
        this.manufacturer = manufacturer;
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "ManufacturerWrapperForFilter{" +
                "manufacturer='" + manufacturer + '\'' +
                ", checked=" + checked +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
