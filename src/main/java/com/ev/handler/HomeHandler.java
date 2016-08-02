package com.ev.handler;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class HomeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        context.getResponse().send("Home Page.");
    }
}
