package com.skyapi.weatherforecast.location.exception;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ExceptionInResponse {

    private LocalDateTime timeStamp;
    private HttpStatusCode errorCode;
    private String errorMessage;

}
