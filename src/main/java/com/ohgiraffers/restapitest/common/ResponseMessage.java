package com.ohgiraffers.restapitest.common;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {

    private int httpStatusCode;
    private String message;
    private Map<String, Object> results;

    public ResponseMessage(HttpStatus httpStatus, String message, Map<String, Object> results) {
        this.httpStatusCode = httpStatus.value();
        this.message = message;
        this.results = results;
    }
}
