package com.example.cinema.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HttpErrorResponse {
    private int status;
    private String Error;
    private LocalDateTime timestamp;
}
