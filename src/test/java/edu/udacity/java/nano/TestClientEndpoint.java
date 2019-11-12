package edu.udacity.java.nano;

import javax.websocket.*;
import java.util.ArrayList;
import java.util.List;

@ClientEndpoint
public class TestClientEndpoint {
    private Session session;
    private boolean closed;
    private List<String> received = new ArrayList<>();


    @OnOpen
    public void onOpen(Session session) {
      this.session = session;
    }

    @OnClose
    public void onClose(Session session) {
       this.closed = true;
    }

    @OnMessage
    public void onMessage(Session session, String jsonStr) {
     this.received.add(jsonStr);
    }



}
