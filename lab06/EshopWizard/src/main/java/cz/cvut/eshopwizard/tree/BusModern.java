package cz.cvut.eshopwizard.tree;


public class BusModern extends Bus {
    
    private String type = "modern";

    public BusModern(String name, int price, int energyImport) {
        super(name, price, energyImport);
        getSupported().add(ModernProcessor.class);
    }

    public String getType() {
        return type;
    }
    
}
