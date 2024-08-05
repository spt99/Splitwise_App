package com.scalar.splitwise_app.commands;

public interface Command {
    public boolean matches(String input);
    public void execute(String input);

}
