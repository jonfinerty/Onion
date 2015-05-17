package com.jonathanfinerty.onionexampleapp.commands;

import com.jonathanfinerty.onion.Handler;

public class UpdateDatabaseCommandHandler implements Handler<UpdateDatabaseCommand, UpdateDatabaseCommand.Callbacks> {

    @Override
    public void handle(UpdateDatabaseCommand command, UpdateDatabaseCommand.Callbacks commandListener) {
        // do some work
        commandListener.databaseUpdated();
    }
}
