package com.jonathanfinerty.onionexampleapp.commands;

import com.jonathanfinerty.onion.Command;
import com.jonathanfinerty.onion.CommandCallbacks;

public class RequestTextCommand implements Command<RequestTextCommand.Callbacks> {

    private String text;

    public RequestTextCommand(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public interface Callbacks extends CommandCallbacks {
        void returnText(String text);
    }
}
