package com.ev;

import com.ev.model.User;
import ratpack.registry.Registry;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

import java.net.URI;

public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(ServerConfig.embedded().publicAddress(new URI("http://company.org")))
                .handlers(chain -> chain
                        .prefix("user/:id", (userChain) -> userChain
                                .all(ctx -> {
                                    String id = ctx.getPathTokens().get("id");
                                    User user = new User(id);
                                    ctx.next(Registry.single(User.class, user));
                                })
                                .get("status", ctx -> {
                                    User user = ctx.get(User.class);
                                    ctx.render("User " + user.getId());
                                })
                        )
                )
        );
    }
}
