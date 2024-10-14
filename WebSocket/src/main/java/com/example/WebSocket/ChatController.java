package com.example.WebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chat") // "/chat" yolu için
    public String chat() {
        return "chat"; // chat.html dosyasını döndür
    }
    @MessageMapping("/send") // "/app/send" yolu ile gelen mesajlar için
    @SendTo("/topic/messages") // "/topic/messages" yoluna yönlendirilecek
    public String sendMessage(String message) {
        return message; // Gelen mesajı olduğu gibi döndür
    }
}