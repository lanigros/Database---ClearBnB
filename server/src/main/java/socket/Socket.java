package socket;

import express.Express;
import io.javalin.websocket.WsContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Socket {

  private static Map<WsContext, String> userUsernameMap = new ConcurrentHashMap<>();
  private static int nextUserNumber = 1;

  private final Express app;

  public Socket(Express app) {
    this.app = app;
    init();
  }

  private static void broadcastMessage(String sender, Message msg) {
    userUsernameMap.keySet().stream().filter(ctx -> ctx.session.isOpen()).forEach(session -> {
      session.send(msg);
    });
  }

  private void init() {
    app.ws("/chat", ws -> {
      ws.onConnect(ctx -> {
        String username = "User" + nextUserNumber++;
        userUsernameMap.put(ctx, username);
        Message msg = new Message();
        msg.setMsg(username + " joined the chat");
        msg.setId(username);
        broadcastMessage("Server", msg);
      });

      ws.onMessage(ctx -> {
        Message msg = ctx.message(Message.class);
        System.out.println(msg.getMsg());
        broadcastMessage(userUsernameMap.get(ctx), msg);
      });

    });
  }

}
