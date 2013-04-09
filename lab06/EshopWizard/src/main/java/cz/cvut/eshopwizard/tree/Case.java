package cz.cvut.eshopwizard.tree;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Case implements Component {
    
    private String name;
    private int price;
    private int energyImport;

    public Case(String name, int price, int energyImport) {
        this.name = name;
        this.price = price;
        this.energyImport = energyImport;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getEnergyImport() {
        return energyImport;
    }
    
}
