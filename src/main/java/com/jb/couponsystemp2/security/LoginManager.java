package com.jb.couponsystemp2.security;


import com.jb.couponsystemp2.exceptions.CouponSystemException;
import com.jb.couponsystemp2.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@RequiredArgsConstructor
public class LoginManager {


    @Autowired
    private AdminService adminService;

    private final ApplicationContext ctx;

    public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
        switch (clientType) {
            case Administrator: {
                if (adminService.login(email, password)) {
                    return (ClientService) adminService;
                }
            }
            case Company: {
                CompanyService companyService = ctx.getBean(CompanyService.class);
                if (companyService.login(email, password)) {
                    companyService.setCompany(companyService.getCompanyByEmail(email));
                    return (ClientService) companyService;
                }
            }
            case Customer: {
                CustomerService customerService = ctx.getBean(CustomerService.class);
                if (customerService.login(email, password)) {
                    customerService.setCustomer(customerService.getCustomerByEmail(email));
                    return (ClientService) customerService;
                }
            }
        }
        return null;


    }

}
