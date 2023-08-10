package com.test.chatbot.dto;

import lombok.*;

import java.util.Map;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    String version;
    Map<String, Object> template;
}
