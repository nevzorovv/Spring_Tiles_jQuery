package ru.vnevzorov.model.wrapper;

public class ColorWrapperForFilter {

    String color;
    boolean checked;

    public ColorWrapperForFilter(String color, boolean checked) {
        this.color = color;
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "ColorWrapperForFilter{" +
                "color='" + color + '\'' +
                ", checked=" + checked +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
