package socket;

import express.Express;

public class Socket {

  private final Express app;

  public Socket(Express app){
    this.app = app;
    init();
  }

  private void init(){
    app.ws("/chat", ws -> {
      ws.onConnect(ctx -> System.out.println("Connected"));
      ws.onMessage(ctx -> {
        Message msg = ctx.message(Message.class);
        ctx.send(msg); // convert to json and send back
      });

    });
  }

}
