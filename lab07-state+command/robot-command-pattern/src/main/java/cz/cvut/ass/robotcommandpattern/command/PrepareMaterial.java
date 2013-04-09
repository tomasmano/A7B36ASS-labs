package cz.cvut.ass.robotcommandpattern.command;

import cz.cvut.ass.robotcommandpattern.reciever.Material;


public class PrepareMaterial implements Command {
    
    private Material material;

    public PrepareMaterial(Material material) {
        this.material = material;
    }

    public void execute() {
        System.out.println("Executinig "+getClass().getSimpleName());
        material.prepare();
    }
    
}
