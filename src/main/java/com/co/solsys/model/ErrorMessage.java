package com.co.solsys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus status;
    private String code;
    private String message;

}
