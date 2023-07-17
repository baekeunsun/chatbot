package com.test.chatbot.controller;

import com.test.chatbot.vo.KeyboardVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {
    @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
    public KeyboardVO keyboard() {

        KeyboardVO keyboard = new KeyboardVO
                (new String[] {"챗봇이랑 대화하기", "공지사항 보기", "FAQ 보기", "1:1 문의하기"});

        return keyboard;
    }
}