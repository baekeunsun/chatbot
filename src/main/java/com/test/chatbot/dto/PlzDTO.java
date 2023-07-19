package com.test.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class PlzDTO {

    public void setVersion(String version) {
        this.version = version;
    }

    public String version;

    public void setTemplate(Map template) {
        this.template = template;
    }

    public Map template;

}
