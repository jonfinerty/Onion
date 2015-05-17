package com.jonathanfinerty.onionexampleapp.commands;

import com.jonathanfinerty.onion.Command;
import com.jonathanfinerty.onion.CommandCallbacks;

public class UpdateDatabaseCommand implements Command<UpdateDatabaseCommand.Callbacks> {


    public interface Callbacks extends CommandCallbacks {

        void databaseUpdated();

    }
}
