package com.loopers.support.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {
    /** 범용 에러 */
    INTERNAL_ERROR(500, "Internal Server Error", "일시적인 오류가 발생했습니다."),
    BAD_REQUEST(400, "Bad Request", "잘못된 요청입니다."),
    NOT_FOUND(404, "Not Found", "존재하지 않는 요청입니다."),
    CONFLICT(409, "Conflict", "이미 존재하는 리소스입니다.");

    private final int status;
    private final String code;
    private final String message;
}
