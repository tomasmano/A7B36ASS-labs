package cz.cvut.ass.robotcommandpattern;

import cz.cvut.ass.robotcommandpattern.command.LaunchSetup;
import cz.cvut.ass.robotcommandpattern.command.PrepareMaterial;
import cz.cvut.ass.robotcommandpattern.command.TurnOffManufacturing;
import cz.cvut.ass.robotcommandpattern.command.TurnOnManufacturing;
import cz.cvut.ass.robotcommandpattern.invoker.RobotWorker;
import cz.cvut.ass.robotcommandpattern.reciever.Manufacturing;
import cz.cvut.ass.robotcommandpattern.reciever.Material;

/**
 * Represents a Client.
 *
 */
public class App {

    public static void main(String[] args) {
        RobotWorker robot = new RobotWorker();
        Manufacturing manufacturing = new Manufacturing();
        Material material = new Material();
        robot.add(new LaunchSetup(material));
        robot.add(new PrepareMaterial(material));
        robot.add(new TurnOnManufacturing(manufacturing));
        robot.add(new TurnOffManufacturing(manufacturing));
        robot.launchCommands();
    }
}
