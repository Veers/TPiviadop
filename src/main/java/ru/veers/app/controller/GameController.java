package ru.veers.app.controller;


import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.veers.app.model.GameMessageDto;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class GameController {

    @MessageMapping("/msg")
    @SendTo("")
    public GameMessageDto csc(GameMessageDto gameMessageDto) {
        return gameMessageDto;
    }
}
