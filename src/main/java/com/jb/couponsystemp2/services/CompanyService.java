package com.jb.couponsystemp2.services;

import com.jb.couponsystemp2.beans.Category;
import com.jb.couponsystemp2.beans.Company;
import com.jb.couponsystemp2.beans.Coupon;
import com.jb.couponsystemp2.exceptions.CouponSystemException;

import java.util.List;

public interface CompanyService {

    boolean login(String email, String password);

    void setCompany(Company company);

    Company getCompanyByEmail(String email);

    void addCoupon(Coupon coupon) throws CouponSystemException;

    void updateCoupon(int couponID, Coupon coupon) throws CouponSystemException;

    void deleteCoupon(int couponID) throws CouponSystemException;

    List<Coupon> getAllCoupons();

    List<Coupon> getAllCouponByCompanyAndCategory(Category category);

    List<Coupon> getAllCouponByCompanyAndUnderPrice(double price);

    Company getCompanyDetails() throws CouponSystemException;


}
