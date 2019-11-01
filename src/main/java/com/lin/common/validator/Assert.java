package com.lin.common.validator;

import org.apache.commons.lang.StringUtils;

import com.lin.common.exception.CheckException;

/**
 * 数据校验
 * @author wanghonghui
 * @email 448697783@qq.com
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new CheckException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new CheckException(message);
        }
    }
}
