package com.jb.couponsystemp2.exceptions;

public class CouponSystemException extends Exception {

    public CouponSystemException(ErrMsg errMsg) {
        super(errMsg.getMessage());
    }
}
