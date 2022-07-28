package test.chat.chatroom.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

import test.chat.chatroom.jedis.JedisHandleMessage;
import test.chat.chatroom.model.ChatMessage;
import test.chat.chatroom.model.State;

@ServerEndpoint("/FriendWS1/{userName}")
public class FriendWS2 {
	private static Map<String, Session> sessionsMap = new ConcurrentHashMap<>();
	Gson gson = new Gson();

	@OnOpen
	public void onOpen(@PathParam("userName") String userName, Session userSession) throws IOException {
		/* save the new user in the map */
		sessionsMap.put(userName, userSession);
		/* Sends all the connected users to the new user */
		Set<String> userNames = sessionsMap.keySet();
//		System.out.println(sessionsMap);
		State stateMessage = new State("open", userName, userNames);
		
		String stateMessageJson = gson.toJson(stateMessage);

		
		Collection<Session> sessions = sessionsMap.values();
		
		for (Session session : sessions) {
		
			synchronized (session) {
				if (session.isOpen()) {
					session.getAsyncRemote().sendText(stateMessageJson);
				}
			}
		}

	
		String text = String.format("Session ID = %s, connected; userName = %s%nusers: %s", userSession.getId(),
				userName, userNames);
//		System.out.println(text);
	}

	@OnMessage
	public void onMessage(Session userSession, String message) {
		ChatMessage chatMessage = gson.fromJson(message, ChatMessage.class); // message來自前台取得的json字串
		String sender = chatMessage.getSender();
		String receiver = chatMessage.getReceiver();
	
		
		// 取得歷史訊息
		if ("history".equals(chatMessage.getType())) {
			
				
			List<String> historyData = JedisHandleMessage.getHistoryMsg(sender, receiver);
			String historyMsg = gson.toJson(historyData);
			ChatMessage cmHistory = new ChatMessage("history", sender, receiver, historyMsg );
//			System.out.println(cmHistory);
			
			if (userSession != null && userSession.isOpen() ) {
				userSession.getAsyncRemote().sendText(gson.toJson(cmHistory));
				System.out.println("history = " + gson.toJson(cmHistory));
				return;
			}
			
		}
		Session receiverSession = sessionsMap.get(receiver);
		if (receiverSession != null && receiverSession.isOpen()) {
			receiverSession.getAsyncRemote().sendText(message);
			userSession.getAsyncRemote().sendText(message);
//			JedisHandleMessage.saveChatMessage(sender, receiver, message);
			// 從if裡拉出來，當使用者不再線上時，存在redis即可
		}
		JedisHandleMessage.saveChatMessage(sender, receiver , message );
		// 變為客服系統
//		System.out.println("Message received: " + message);
		
	}

	@OnError
	public void onError(Session userSession, Throwable e) {
//		System.out.println("Error: " + e.toString());
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		String userNameClose = null;
		Set<String> userNames = sessionsMap.keySet();
		for (String userName : userNames) {
			if (sessionsMap.get(userName).equals(userSession)) {
				userNameClose = userName;
				sessionsMap.remove(userName);
				break;
			}
		}

		if (userNameClose != null) {
			State stateMessage = new State("close", userNameClose, userNames);
			String stateMessageJson = gson.toJson(stateMessage);
			Collection<Session> sessions = sessionsMap.values();
			for (Session session : sessions) {
				session.getAsyncRemote().sendText(stateMessageJson);
			}
		}

		String text = String.format("session ID = %s, disconnected; close code = %d%nusers: %s", userSession.getId(),
				reason.getCloseCode().getCode(), userNames);
		System.out.println(text);
	}
}
