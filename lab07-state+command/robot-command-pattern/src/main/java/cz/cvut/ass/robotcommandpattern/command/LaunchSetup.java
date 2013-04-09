package cz.cvut.ass.robotcommandpattern.command;

import cz.cvut.ass.robotcommandpattern.reciever.Material;


public class LaunchSetup implements Command {

    private Material material;

    public LaunchSetup(Material material) {
        this.material = material;
    }

    public void execute() {
        System.out.println("Executinig "+getClass().getSimpleName());
        material.launch();
    }
}
