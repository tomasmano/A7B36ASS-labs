package cz.cvut.eshopwizard.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class PcCart implements Component {

    private String name;
    private int price;
    private int energyImport;
    private List<Component> leafs = new ArrayList<Component>();
    private Bus bus = new NullBus("null bus", 0, 0);

    public PcCart(String name, int price, int energyImport) {
        this.name = name;
        this.price = price;
        this.energyImport = energyImport;
    }

    public void add(Component c) {
        if (isNotAdded(c)) {
            if (c instanceof Bus) {
                if (!(bus instanceof NullBus)) {
                    System.err.println("You have already added this item.");
                    return;
                }
                this.bus = (Bus) c;
                leafs.add(c);
                return;
            }
            leafs.add(c);
        } else {
            System.err.println("You have already added this item.");
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

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getEnergyImport() {
        int total = this.energyImport;
        for (Component c : leafs) {
            total += c.getEnergyImport();
        }
        return total;
    }

    private boolean isNotAdded(Component c) {
        for (Component co : leafs) {
            if (co.getClass() == c.getClass()) {
                return false;
            }
        }
        return true;
    }
    
    private class NullBus extends Bus{

        public NullBus(String name, int price, int energyImport) {
            super(name, price, energyImport);
        }

        @Override
        public void add(Component c) {
            System.out.println("You must select a bus first.");
        }
        
    }
}
