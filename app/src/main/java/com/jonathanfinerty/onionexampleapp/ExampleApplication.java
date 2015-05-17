package com.jonathanfinerty.onionexampleapp;

import android.app.Application;

import com.jonathanfinerty.onion.Registry;
import com.jonathanfinerty.onionexampleapp.commands.RequestTextCommand;
import com.jonathanfinerty.onionexampleapp.commands.RequestTextCommandHandler;
import com.jonathanfinerty.onionexampleapp.commands.UpdateDatabaseCommand;
import com.jonathanfinerty.onionexampleapp.commands.UpdateDatabaseCommandHandler;

public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Registry registry = new Registry();

        RequestTextCommandHandler requestTextCommandHandler = new RequestTextCommandHandler();
        registry.registerHandler(RequestTextCommand.class, requestTextCommandHandler);

        UpdateDatabaseCommandHandler updateDatabaseCommandHandler = new UpdateDatabaseCommandHandler();
        registry.registerHandler(UpdateDatabaseCommand.class, updateDatabaseCommandHandler);
    }
}
