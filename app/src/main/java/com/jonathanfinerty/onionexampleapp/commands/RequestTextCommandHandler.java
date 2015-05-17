package com.jonathanfinerty.onionexampleapp.commands;

import com.jonathanfinerty.onion.Handler;

public class RequestTextCommandHandler implements Handler<RequestTextCommand, RequestTextCommand.Callbacks> {

    @Override
    public void handle(RequestTextCommand command, RequestTextCommand.Callbacks commandListener) {
        String text = command.getText();
        commandListener.returnText(text + " HELLO WORLD");
    }
}
