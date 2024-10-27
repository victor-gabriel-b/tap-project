package command;

import infra.DatabaseFacade;

public interface Command {
    public String getName();
    public boolean execute(DatabaseFacade df);
}