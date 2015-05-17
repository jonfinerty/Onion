package com.jonathanfinerty.onion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class Onion {

    public <C extends Command<CC>, CC extends CommandCallbacks, Y extends CC> void executeCommand(Context context, C command, Y commandCallbacks) {
        Intent serviceIntent = new Intent(context, CommandProcessorService.class);
        OnionConnection<C, CC> connection = new OnionConnection<C, CC>(command, commandCallbacks);
        context.bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE);
    }

    public class OnionConnection<C extends Command<L>, L extends CommandCallbacks> implements ServiceConnection {

        private C command;
        private L commandCallbacks;

        public OnionConnection(C command, L commandListener) {
            this.command = command;
            this.commandCallbacks = commandListener;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            CommandProcessorService.CommandProcessorServiceBinder binder = (CommandProcessorService.CommandProcessorServiceBinder) iBinder;
            CommandProcessorService service = binder.getService();
            service.executeCommand(command, commandCallbacks);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

}
