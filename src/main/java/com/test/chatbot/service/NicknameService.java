package com.test.chatbot.service;

import com.test.chatbot.dto.Member;
import com.test.chatbot.dto.NicknameDto;
import com.test.chatbot.dto.ResponseDto;
import com.test.chatbot.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Transactional
public class NicknameService {

    private final MemberRepository memberRepository;

    /**
     * 닉네임 등록
     * */
    public ResponseDto register(NicknameDto nicknameDto) throws Exception {
        ResponseDto output = new ResponseDto();
        output.setVersion("2.0");

        if(memberRepository.findById(nicknameDto.id()).isPresent()){
            Map<String, Object> template = new HashMap<>();

            List<Map<String, Object>> outputsList = new ArrayList<>();
            Map<String, Object> outputMap = new HashMap<>();
            Map<String, Object> simpleTextMap = new HashMap<>();
            simpleTextMap.put("text", "중복닉네임");
            outputMap.put("simpleText", simpleTextMap);
            outputsList.add(outputMap);

            template.put("outputs", outputsList);

            output.setTemplate(template);

            return output;
        }
        Member member = Member.builder()
                .id(nicknameDto.id())
                .nickname(nicknameDto.nickname())
                .build();

        memberRepository.save(member);

        Map<String, Object> template = new HashMap<>();

        List<Map<String, Object>> outputsList = new ArrayList<>();
        Map<String, Object> outputMap = new HashMap<>();
        Map<String, Object> simpleTextMap = new HashMap<>();
        simpleTextMap.put("text", "닉네임등록성공");
        outputMap.put("simpleText", simpleTextMap);
        outputsList.add(outputMap);

        template.put("outputs", outputsList);

        output.setTemplate(template);
        return output;
    }
}
