package com.jb.couponsystemp2.exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {

    LOGIN_TO_SYSTEM("Login was denied, email or password incorrect...plz try again"),
    COMPANY_NAME_OR_EMAIL_EXIST("Company name or email is already exist"),
    UPDATE_COMPANY("An update company failed , you cont change id or name"),
    COMPANY_NOT_EXIST_BY_ID("There is no company with this id"),
    ADD_CUSTOMER("An attempt to add the customer to the system failed, the email is already exist"),
    UPDATE_CUSTOMER("An update customer failed , you cont change the id"),
    CUSTOMER_NOT_EXIST_BY_ID("There is no customer by this id"),
    ADD_COUPON("An attempt to add the coupon to the system failed, the name is already exist"),
    UPDATE_COUPON("An update coupon failed , you cont change coupon id or company id"),
    COUPON_NOT_EXIST_BY_ID("There is no coupon with this id"),
    REPURCHASE_COUPON("Opsss...You already buy this coupon"),
    RUN_OUT_COUPON_AMOUNT("Sorry...The coupon has run out"),
    EXPIRED_COUPON("Sorry...The coupon has expired");

    private final String message;

    ErrMsg(String message) {
        this.message = message;
    }
}
