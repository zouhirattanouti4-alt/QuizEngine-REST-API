package com.zouhir.quizapp.dtos;

import java.time.LocalDateTime;

public record ApiErrorResponse(
        LocalDateTime dateTime,
        int status,
        String error
) {
}
