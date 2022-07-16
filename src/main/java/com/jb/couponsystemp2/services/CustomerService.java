package com.jb.couponsystemp2.services;

import com.jb.couponsystemp2.beans.Category;
import com.jb.couponsystemp2.beans.Coupon;
import com.jb.couponsystemp2.beans.Customer;
import com.jb.couponsystemp2.exceptions.CouponSystemException;

import java.util.List;

public interface CustomerService {

    boolean login(String email, String password);

    void setCustomer(Customer customer);

    Customer getCustomerByEmail(String email);

    void purchaseCoupon(Coupon coupon) throws CouponSystemException;

    List<Coupon> getAllCustomerCoupon();

    List<Coupon> getCustomerCouponByCategory(Category category);

    List<Coupon> getCustomerCouponsUnderPrice(double maxPrice);

    Customer getCustomerDetails() throws CouponSystemException;

}
