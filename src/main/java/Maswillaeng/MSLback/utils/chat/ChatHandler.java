package Maswillaeng.MSLback.utils.chat;


import Maswillaeng.MSLback.domain.enums.MessageEnum;
import Maswillaeng.MSLback.dto.chat.request.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;

@Component
@Slf4j
@AllArgsConstructor
public class ChatHandler extends TextWebSocketHandler {
    private final Map<Long, WebSocketSession> userSocketList;

    private final ObjectMapper objectMapper;
    private final ChatTypeUtils chatTypeUtils;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : {} ", payload);

        MessageEnum type = objectMapper.readValue(payload, MessageType.class).getType();

        switch (type) {
            case ENTER:
                chatTypeUtils.EnterTypeProcess(payload, session, userSocketList);
                break;
            case MESSAGE:
                chatTypeUtils.MessageTypeProcess(payload, userSocketList);
                break;
            case ACK:
                chatTypeUtils.ACKTypeProcess(payload, userSocketList);
                break;
        }

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info(" 클라이언트 접속");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        for (Long key : userSocketList.keySet()) {
            if (userSocketList.get(key).equals(session)) {
                userSocketList.remove(key);
            }
        }
    }
}
