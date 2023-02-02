package com.qinweizhao.basic.exception;

import java.text.MessageFormat;

/**
 * @author qinweizhao
 * @since 2022-04-13
 */
public interface BusinessExceptionAssert extends IResponse, Assert {
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }
}
