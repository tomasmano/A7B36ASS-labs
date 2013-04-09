package cz.cvut.eshopwizard.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public abstract class Bus implements Component {

    private String name;
    private int price;
    private int energyImport;
    private List<Component> leafs = new ArrayList<Component>();
    private List<Class> supported = new ArrayList<Class>();

    public Bus(String name, int price, int energyImport) {
        this.name = name;
        this.price = price;
        this.energyImport = energyImport;
    }

    public void add(Component c) {
        if (isSupported(c.getClass())) {
            leafs.add(c);
        } else {
            System.err.println(String.format("Component not supported by this bus [%s].", this.getClass().getSimpleName()));
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        int total = this.price;
        for (Component c : leafs) {
            total += c.getPrice();
        }
        return total;
    }

    public int getEnergyImport() {
        int total = this.energyImport;
        for (Component c : leafs) {
            total += c.getEnergyImport();
        }
        return total;
    }

    public List<Class> getSupported() {
        return supported;
    }

    private boolean isSupported(Class c){
        return supported.contains(c);
    }
    
}
