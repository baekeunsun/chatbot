package com.test.chatbot.controller;

import com.test.chatbot.dto.NicknameDto;
import com.test.chatbot.dto.PlzDTO;
import com.test.chatbot.dto.ResponseDto;
import com.test.chatbot.service.NicknameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BotController {

    private final NicknameService nicknameService;

    @RequestMapping(value = "/plz", method = RequestMethod.POST, headers = "Accept=application/json")
    public PlzDTO icandoit(@RequestBody String plz) {
        Map<String, String> first = new HashMap<>();
        Map<String, Map> second = new HashMap<>();
        Map<String, List<Map>> third = new HashMap<>();

        first.put("text","간단한 텍스트 요소입니다.");
        second.put("simpleText",first);
        List<Map> tmp = new ArrayList<>();
        tmp.add(second);

        third.put("outputs",tmp);

        PlzDTO plzDTO = new PlzDTO();
        plzDTO.setVersion("2.0");
        plzDTO.setTemplate(third);
        System.out.println("plzDTO = " + plzDTO);

        return plzDTO;
    }

    /**
     * 닉네임 등록
     * */
    @PostMapping("/nickname/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto nickname(@RequestBody NicknameDto nicknameDto) throws Exception {
        return nicknameService.register(nicknameDto);
    }
}
