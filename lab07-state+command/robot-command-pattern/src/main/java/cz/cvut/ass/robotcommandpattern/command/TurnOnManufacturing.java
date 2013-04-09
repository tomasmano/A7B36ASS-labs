package cz.cvut.ass.robotcommandpattern.command;

import cz.cvut.ass.robotcommandpattern.reciever.Manufacturing;


public class TurnOnManufacturing implements Command {
    
    private Manufacturing manufacturing;

    public TurnOnManufacturing(Manufacturing manufacturing) {
        this.manufacturing = manufacturing;
    }

    public void execute() {
        System.out.println("Executinig "+getClass().getSimpleName());
        manufacturing.switchOn();
    }
    
}
