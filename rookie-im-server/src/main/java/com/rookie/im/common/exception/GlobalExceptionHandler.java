package com.rookie.im.common.exception;

import com.rookie.im.common.domain.resp.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.rookie.im.common.exception.CommonErrorEnum.PARAM_INVALID;

/**
 * RestControllerAdvice 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResult<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder errMsg = new StringBuilder();
        e.getBindingResult().getFieldErrors()
                .forEach(x -> errMsg.append(x.getField()).append(x.getDefaultMessage()).append(","));

        String msg = errMsg.toString();
        return ApiResult.fail(PARAM_INVALID.getErrorCode(), msg.substring(0, msg.length() -1));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BusinessException.class)
    public ApiResult<?> businessExceptionHandler(BusinessException e) {
        log.info("business exception! reason is {}", e.getErrMsg(), e);
        return ApiResult.fail(e.getErrorCode(), e.getErrMsg());
    }
}
