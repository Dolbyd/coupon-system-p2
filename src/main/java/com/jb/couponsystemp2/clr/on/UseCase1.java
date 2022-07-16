package com.jb.couponsystemp2.clr.on;


import com.jb.couponsystemp2.beans.Category;
import com.jb.couponsystemp2.beans.Company;
import com.jb.couponsystemp2.beans.Coupon;
import com.jb.couponsystemp2.beans.Customer;
import com.jb.couponsystemp2.repos.CouponRepository;
import com.jb.couponsystemp2.security.ClientType;
import com.jb.couponsystemp2.security.LoginManager;
import com.jb.couponsystemp2.services.*;
import com.jb.couponsystemp2.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(1)
@RequiredArgsConstructor
public class UseCase1 implements CommandLineRunner {


    @Autowired
    private LoginManager loginManager;


    private final Art art = new Art();

    @Autowired
    private CouponRepository couponRepository;


    @Override
    public void run(String... args) throws Exception {


        Coupon cou1 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("get a 25% discount on the second product")
                .description("Plasma screen 24\"")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(1559)
                .image("not yet")
                .build();

        Coupon cou2 = Coupon.builder()
                .category(Category.RESTAURANT)
                .title("buy gift card at 350 and get 400")
                .description("gift card")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(100)
                .price(350)
                .image("not yet")
                .build();

        Coupon cou3 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("get a 15% discount on the second product")
                .description("Plasma screen 18\"")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(20)
                .price(1239)
                .image("not yet")
                .build();

        Coupon cou4 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("get a 50% discount on buying a mouse")
                .description("keyboard")
                .startDate(Date.valueOf(LocalDate.of(2000, 01, 01)))
                .endDate(Date.valueOf(LocalDate.of(2000, 01, 02)))
                .amount(100)
                .price(129.99)
                .image("not yet")
                .build();

        Coupon cou5 = Coupon.builder()
                .category(Category.VACATION)
                .title("for 1 week, buy 2 tickets and get 20% discount")
                .description("ticket to Barcelona")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(1)))
                .amount(150)
                .price(780)
                .image("not yet")
                .build();


        Company comp1 = Company.builder()
                .name("Dell")
                .email("Dell@gmail.com")
                .password("123")
                .build();

        Company comp2 = Company.builder()
                .name("HP")
                .email("HP@gmail.com")
                .password("123")
                .build();

        Company comp3 = Company.builder()
                .name("ME")
                .email("ME@gmail.com")
                .password("123")
                .build();

        Company comp4 = Company.builder()
                .name("gift card")
                .email("gift@gmail.com")
                .password("123")
                .build();

        Company comp5 = Company.builder()
                .name("travelor")
                .email("travelor@gmail.com")
                .password("123")
                .build();

        Customer cr1 = Customer.builder()
                .firsName("Moshe")
                .lastName("Cohen")
                .email("moshe@gmail.com")
                .password("123")
                .build();

        Customer cr2 = Customer.builder()
                .firsName("Hila")
                .lastName("Levi")
                .email("Hila@gmail.com")
                .password("123")
                .build();

        Customer cr3 = Customer.builder()
                .firsName("Yatzek")
                .lastName("Menashe")
                .email("Yatzek@gmail.com")
                .password("123")
                .build();

        Customer cr4 = Customer.builder()
                .firsName("Sagi")
                .lastName("dotan")
                .email("Sagi@gmail.com")
                .password("123")
                .build();

        Customer cr5 = Customer.builder()
                .firsName("gefen")
                .lastName("geva")
                .email("gefen@gmail.com")
                .password("123")
                .build();


        art.adminArt();
        AdminService adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Administrator);

        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add companies  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        adminService.addCompany(comp1);
        adminService.addCompany(comp2);
        adminService.addCompany(comp3);
        adminService.addCompany(comp4);
        adminService.addCompany(comp5);
        adminService.getAllCompanies().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  update company  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        comp2.setEmail("HPHPHPHP@gmail.com");
        adminService.updateCompany(2, comp2);
        adminService.getAllCompanies().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  delete company  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        adminService.deleteCompany(3);
        adminService.getAllCompanies().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  get single company  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println(adminService.getSingleCompany(1));
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add customers  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        adminService.addCustomer(cr1);
        adminService.addCustomer(cr2);
        adminService.addCustomer(cr3);
        adminService.addCustomer(cr4);
        adminService.addCustomer(cr5);
        adminService.getAllCustomers().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  update customer  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        cr2.setFirsName("Hilalosh");
        adminService.updateCustomer(2, cr2);
        adminService.getAllCustomers().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  delete customer  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        adminService.deleteCustomer(3);
        adminService.getAllCustomers().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  get single customer  -*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
        System.out.println(adminService.getSingleCustomer(1));


        art.companyArt();


        CompanyService companyService = (CompanyService) loginManager.login("Dell@gmail.com", "123", ClientType.Company);
        companyService.getAllCoupons().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add coupon  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        companyService.addCoupon(cou1);
        companyService.addCoupon(cou3);
        companyService.addCoupon(cou4);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  update coupon  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        cou1.setAmount(49);
        companyService.updateCoupon(1, cou1);
        companyService.getAllCoupons().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  delete coupon  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        companyService.deleteCoupon(3);
        companyService.getAllCoupons().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  getAllCouponByCompanyAndCategory  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        companyService.getAllCouponByCompanyAndCategory(Category.ELECTRICITY).forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  getAllCouponByCompanyAndUnderPrice  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        companyService.getAllCouponByCompanyAndUnderPrice(50).forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  get company details  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println(companyService.getCompanyDetails());
        companyService = (CompanyService) loginManager.login("gift@gmail.com", "123", ClientType.Company);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add coupon  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        companyService.addCoupon(cou2);
        companyService = (CompanyService) loginManager.login("travelor@gmail.com", "123", ClientType.Company);
        companyService.addCoupon(cou5);

        art.customerArt();
        CustomerService customerService = (CustomerService) loginManager.login("moshe@gmail.com", "123", ClientType.Customer);
        customerService.purchaseCoupon(cou1);
        customerService = (CustomerService) loginManager.login("Hila@gmail.com", "123", ClientType.Customer);
        customerService.purchaseCoupon(cou2);
        customerService = (CustomerService) loginManager.login("moshe@gmail.com", "123", ClientType.Customer);
        customerService.purchaseCoupon(cou2);
        customerService.purchaseCoupon(cou5);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  get all customer coupons  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        customerService.getAllCustomerCoupon().forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  get all customer coupons by category -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        customerService.getCustomerCouponByCategory(Category.ELECTRICITY).forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  get all customer coupons under price -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        customerService.getCustomerCouponsUnderPrice(500).forEach(System.out::println);
        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  get customer details  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println(customerService.getCustomerDetails());

        couponRepository.deleteByEndDateBefore(Date.valueOf(LocalDate.now().plusMonths(1)));


    }
}
