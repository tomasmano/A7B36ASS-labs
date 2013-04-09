package cz.cvut.ass.robotcommandpattern.invoker;

import cz.cvut.ass.robotcommandpattern.command.Command;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an invoker.
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotWorker {

    private List<Command> commands = new ArrayList<Command>();
    
    public void add(Command command){
        commands.add(command);
    }
    
    public void launchCommands(){
        for (Command command : commands) {
            command.execute();
        }
    }
}
