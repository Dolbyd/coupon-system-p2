package com.jb.couponsystemp2.services;

import com.jb.couponsystemp2.beans.Category;
import com.jb.couponsystemp2.beans.Company;
import com.jb.couponsystemp2.beans.Coupon;
import com.jb.couponsystemp2.exceptions.CouponSystemException;
import com.jb.couponsystemp2.exceptions.ErrMsg;
import com.jb.couponsystemp2.repos.CompanyRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor
public class CompanyServiceImpl extends ClientService implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    private Company company;


    @Override
    public boolean login(String email, String password) {
        return companyRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public Company getCompanyByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        if (this.couponRepository.existsByCompanyAndTitle(company, coupon.getTitle())) {
            throw new CouponSystemException(ErrMsg.ADD_COUPON);
        }
        coupon.setCompany(company);
        this.couponRepository.save(coupon);
    }

    @Override
    public void updateCoupon(int couponID, Coupon coupon) throws CouponSystemException {
        Coupon preCoupon = this.couponRepository.getById(couponID);
        if (preCoupon.getId() != coupon.getId() || preCoupon.getCompany().equals(coupon.getCompany())) {
            throw new CouponSystemException(ErrMsg.UPDATE_COUPON);
        }
        this.couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponID) throws CouponSystemException {
        if (!this.couponRepository.existsById(couponID)) {
            throw new CouponSystemException(ErrMsg.COUPON_NOT_EXIST_BY_ID);
        }
        this.couponRepository.deleteById(couponID);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return this.couponRepository.findAll();
    }

    @Override
    public List<Coupon> getAllCouponByCompanyAndCategory(Category category) {
        return this.couponRepository.findByCompanyIdAndCategory(company.getId(), category);
    }

    @Override
    public List<Coupon> getAllCouponByCompanyAndUnderPrice(double price) {
        return this.couponRepository.findByCompanyIdAndPriceGreaterThan(company.getId(), price);
    }

    @Override
    public Company getCompanyDetails() throws CouponSystemException {
        return this.companyRepository.findById(company.getId()).orElseThrow(() -> new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST_BY_ID));
    }


}
