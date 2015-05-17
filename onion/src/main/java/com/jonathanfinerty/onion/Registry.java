package com.jonathanfinerty.onion;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private final static Map<Class, Object> handlerMap = new HashMap<>();

    public <C extends Command<L>, L extends CommandCallbacks> void registerHandler(Class<C> commandType, Handler<C, L> handler){
        handlerMap.put(commandType, handler);
    }

    @SuppressWarnings("unchecked")
    public <C extends Command<L>, L extends CommandCallbacks> Handler<C, L> getHandler(Class<C> commandType) {
        return (Handler<C,L>)handlerMap.get(commandType);
    }


}
