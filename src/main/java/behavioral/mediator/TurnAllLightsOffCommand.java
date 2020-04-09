package behavioral.mediator;

import behavioral.command.Command;
import behavioral.command.ToggleAllCommand;

public class TurnAllLightsOffCommand implements Command {

    private LightMediator mediator;

    public TurnAllLightsOffCommand(LightMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        new ToggleAllCommand(mediator.getLights()).execute(); ;
    }
}
