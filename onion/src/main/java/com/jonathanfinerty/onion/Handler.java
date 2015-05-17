package com.jonathanfinerty.onion;

public interface Handler<C extends Command<L>, L extends CommandCallbacks> {

    void handle(C command, L commandListener);

}