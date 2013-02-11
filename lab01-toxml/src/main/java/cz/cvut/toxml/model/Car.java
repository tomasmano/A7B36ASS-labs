package cz.cvut.toxml.model;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Car {
    private String number;
    private String color;

    public Car() {
    }

    public Car(String number, String color) {
        this.number = number;
        this.color = color;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
