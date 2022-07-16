package com.jb.couponsystemp2.services;

import com.jb.couponsystemp2.beans.Company;
import com.jb.couponsystemp2.beans.Customer;
import com.jb.couponsystemp2.exceptions.CouponSystemException;
import com.jb.couponsystemp2.exceptions.ErrMsg;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AdminServiceImpl extends ClientService implements AdminService {


    @Override
    public boolean login(String email, String password) {
        return (email.equals("admin@admin.com") && password.equals("admin"));
    }

    @Override
    public void addCompany(Company company) throws CouponSystemException {
        if (companyRepository.existsByNameOrEmail(company.getName(), company.getEmail())) {
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_OR_EMAIL_EXIST);
        }
        this.companyRepository.save(company);

    }

    @Override
    public void updateCompany(int companyId, Company company) throws CouponSystemException {
        Company preCompany = this.getSingleCompany(companyId);
        if (!preCompany.getName().equals(company.getName()) || (preCompany.getId() != company.getId())) {
            throw new CouponSystemException(ErrMsg.UPDATE_COMPANY);
        }
        this.companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws CouponSystemException {
        if (!companyRepository.existsById(companyId)) {
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST_BY_ID);
        }
        this.companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int companyId) throws CouponSystemException {
        return companyRepository.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST_BY_ID));
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        if (this.customerRepository.existsByEmail(customer.getEmail())) {
            throw new CouponSystemException(ErrMsg.ADD_COUPON);
        }
        this.customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        Customer preCustomer = this.customerRepository.getById(customerId);
        if (preCustomer.getId() != customer.getId()) {
            throw new CouponSystemException(ErrMsg.UPDATE_CUSTOMER);
        }
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException {
        if (!this.customerRepository.existsById(customerId)) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_NOT_EXIST_BY_ID);
        }
        this.customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) throws CouponSystemException {
        return customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException(ErrMsg.CUSTOMER_NOT_EXIST_BY_ID));
    }


}
