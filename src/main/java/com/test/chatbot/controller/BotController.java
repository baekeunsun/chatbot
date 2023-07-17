package com.test.chatbot.controller;

import com.test.chatbot.vo.KeyboardVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class BotController {
    @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
    public KeyboardVO keyboard() {

        KeyboardVO keyboard = new KeyboardVO
                (new String[] {"챗봇이랑 대화하기", "공지사항 보기", "FAQ 보기", "1:1 문의하기"});

        return keyboard;
    }

    @GetMapping("/ex/test")
    @ResponseBody
    public String getExamplePath() {
        return "Get some example";
    }
}
