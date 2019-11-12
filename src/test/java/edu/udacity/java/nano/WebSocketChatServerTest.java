package edu.udacity.java.nano;



import edu.udacity.java.nano.controller.WebSocketChatServer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.websocket.ContainerProvider;

import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.*;
import java.util.concurrent.ExecutionException;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebSocketChatServerTest {

   @LocalServerPort
   private int serverPort;


   @Autowired
   private WebSocketChatServer sinkServer;

   private WebSocketContainer container;
   private TestClientEndpoint client;


   @Before
   public void setup() {
      container = ContainerProvider.getWebSocketContainer();
      client = new TestClientEndpoint();

   }

   @Test
   public void testOnOpen() throws Exception {
      Session wsSession  = container.connectToServer(client , URI.create("ws://localhost:"+serverPort+"/chat"));
     // assertTrue(restTemplate.getForObject("http://127.0.0.1:" + serverPort, String.class).contains("Wolff"));
   }

}