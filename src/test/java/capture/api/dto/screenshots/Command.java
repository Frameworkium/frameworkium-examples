package capture.api.dto.screenshots;

import com.frameworkium.core.api.dto.AbstractDTO;

public class Command extends AbstractDTO<Command> {

    public String action;
    public String using;
    public String value;

    public static Command newInstance() {
        var command = new Command();
        command.action = "click";
        command.using = "id";
        command.value = "my-id";
        return command;
    }

}
