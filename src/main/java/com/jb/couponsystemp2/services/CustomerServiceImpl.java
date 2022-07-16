package com.jb.couponsystemp2.services;

import com.jb.couponsystemp2.beans.Category;
import com.jb.couponsystemp2.beans.Coupon;
import com.jb.couponsystemp2.beans.Customer;
import com.jb.couponsystemp2.exceptions.CouponSystemException;
import com.jb.couponsystemp2.exceptions.ErrMsg;;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
public class CustomerServiceImpl extends ClientService implements CustomerService {


    private Customer customer;


    @Override
    public boolean login(String email, String password) {
        return customerRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
        if (couponRepository.existsByCustomerAndCoupon(customer.getId(), coupon.getId()) == 1) {
            throw new CouponSystemException(ErrMsg.REPURCHASE_COUPON);
        }
        if (coupon.getAmount() == 0) {
            throw new CouponSystemException(ErrMsg.RUN_OUT_COUPON_AMOUNT);
        }
        if (coupon.getEndDate().before(Date.valueOf(LocalDate.now()))) {
            throw new CouponSystemException(ErrMsg.EXPIRED_COUPON);
        }
        customer.getCoupons().add(coupon);
        customerRepository.saveAndFlush(customer);
        coupon.setAmount(coupon.getAmount() - 1);
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public List<Coupon> getAllCustomerCoupon() {
        return couponRepository.getAllCustomerCoupons(customer.getId());
    }

    @Override
    public List<Coupon> getCustomerCouponByCategory(Category category) {
        return couponRepository.getAllCustomerCouponsByCategory(customer.getId(), category.name());

    }

    @Override
    public List<Coupon> getCustomerCouponsUnderPrice(double maxPrice) {
        return couponRepository.getAllCustomerCouponsUnderPrice(customer.getId(), maxPrice);
    }

    @Override
    public Customer getCustomerDetails() throws CouponSystemException {
        return customerRepository.findById(customer.getId()).orElseThrow(() -> new CouponSystemException(ErrMsg.CUSTOMER_NOT_EXIST_BY_ID));
    }
}
