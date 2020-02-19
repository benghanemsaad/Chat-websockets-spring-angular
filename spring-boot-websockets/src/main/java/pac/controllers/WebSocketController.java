package pac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pac.Model.MessageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Controller
@RestController
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }


    @Autowired private SimpUserRegistry simpUserRegistry;

    @GetMapping("/getAll")
    public Set<SimpUser> getUsers() {
        return simpUserRegistry.getUsers();
    }

    @MessageMapping("/send/message")
    public void onReceivedMesage(MessageObject obj){//setdate
        obj.setDate();
        this.template.convertAndSend("/chat",  obj);
    }


    @MessageMapping("/send/writing")
    public void whileSendingMesage(String message){
        this.template.convertAndSend("/write",  message);
    }

}
