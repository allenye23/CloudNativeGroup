package com.locke.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {

    private String code = ResponseCode.SUCCESS;
    private String message = ResponseCode.SUCCESS;
    private Object response;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(Object response) {
        this.response = response;
    }
}
