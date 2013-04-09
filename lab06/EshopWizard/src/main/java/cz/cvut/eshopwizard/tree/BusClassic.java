package cz.cvut.eshopwizard.tree;


public class BusClassic extends Bus {
    
    private String type = "classic";

    public BusClassic(String name, int price, int energyImport) {
        super(name, price, energyImport);
        super.getSupported().add(ClassicProcessor.class);
    }

    public String getType() {
        return type;
    }

    
}
