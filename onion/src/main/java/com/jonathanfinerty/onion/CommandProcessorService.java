package com.jonathanfinerty.onion;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CommandProcessorService extends Service {

    private final IBinder binder = new CommandProcessorServiceBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class CommandProcessorServiceBinder extends Binder {
        public CommandProcessorService getService() {
            return CommandProcessorService.this;
        }
    }

    public <C extends Command<L>, L extends CommandCallbacks> void executeCommand(C command, L commandCallbacks) {
        Registry registry = new Registry();
        @SuppressWarnings("unchecked")
        Handler<C, L> handler = (Handler<C, L>) registry.getHandler(command.getClass());
        handler.handle(command, commandCallbacks);
    }

}
