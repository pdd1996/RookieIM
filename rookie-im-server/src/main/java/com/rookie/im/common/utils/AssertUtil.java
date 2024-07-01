package com.rookie.im.common.utils;

import cn.hutool.core.util.ObjectUtil;
import com.rookie.im.common.exception.BusinessErrorEnum;
import com.rookie.im.common.exception.BusinessException;
import com.rookie.im.common.exception.ErrorEnum;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * 断言工具类
 */
public class AssertUtil {

    public static void isNotEmpty (Object object, String msg) {
        if (isEmpty(object)) {
            throwException(msg);
        }
    }

    public static void isEmpty (Object object, ErrorEnum errorEnum, Object... args) {

        if (isEmpty(object)) {
            throwException(errorEnum, args);
        }
    }

    private static void throwException(String msg) {
        throwException(null, msg);
    }

    private static void throwException(ErrorEnum errorEnum, Object... args) {
        if(Objects.isNull(errorEnum)) {
            errorEnum = BusinessErrorEnum.BUSINESS_ERROR;
        }

        throw new BusinessException(errorEnum.getErrorCode(), MessageFormat.format(errorEnum.getErrMsg(), args));
    }

    public static boolean isEmpty (Object object) {
        return ObjectUtil.isEmpty(object);
    }

}
