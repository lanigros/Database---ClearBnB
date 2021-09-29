package socket;

import express.Express;
import io.javalin.websocket.WsContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import model.Message;
import service.SocketService;

public class Socket {

  private final List<WsContext> userUsernameMap = new ArrayList<>();
  private int nextUserNumber = 1;
  private final SocketService socketService;

  private final Express app;

  public Socket(Express app) {
    this.app = app;
    this.socketService = new SocketService();
    init();
  }

  private void broadcastMessage(Message msg) {
    userUsernameMap.stream().filter(ctx -> ctx.session.isOpen()).forEach(socket -> {
      socket.send(msg);
    });
  }

  private void init() {
    app.ws("/chat", ws -> {
      ws.onConnect(ctx -> {
        userUsernameMap.add(ctx);
        Message msg = new Message("Server", "A user joined the chat");
        broadcastMessage(msg);
        List<Message> list = socketService.getAll();
        ctx.send(list);
      });

      ws.onMessage(ctx -> {
        Message msg = ctx.message(Message.class);
        Optional<Message> savedMsg = socketService.saveMessage(msg);

        if(savedMsg.isPresent()){
          broadcastMessage(savedMsg.get());
        } else {
          ctx.send(socketService.returnErrorMsg());
        }

      });

    });
  }

}
