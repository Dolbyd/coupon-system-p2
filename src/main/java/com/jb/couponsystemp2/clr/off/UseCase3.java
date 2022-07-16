package com.jb.couponsystemp2.clr.off;


import com.jb.couponsystemp2.beans.Category;
import com.jb.couponsystemp2.beans.Company;
import com.jb.couponsystemp2.beans.Coupon;
import com.jb.couponsystemp2.beans.Customer;
import com.jb.couponsystemp2.services.AdminServiceImpl;
import com.jb.couponsystemp2.services.CompanyServiceImpl;
import com.jb.couponsystemp2.services.CustomerServiceImpl;
import com.jb.couponsystemp2.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(2)
@RequiredArgsConstructor
public class UseCase3 implements CommandLineRunner {

    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    private final Art art = new Art();

    @Override
    public void run(String... args) throws Exception {


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

        Coupon cou1 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("Plasma screen 24\"")
                .description("computer screens")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(99.99)
                .company(comp1)
                .image("not yet")

                .build();

        Coupon cou2 = Coupon.builder()
                .category(Category.FOOD)
                .title("Gamers keyboard")
                .description("computer keyboard")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(100)
                .price(19.99)

                .image("not yet")
                .build();

        Coupon cou3 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("Plasma screen 18\"")
                .description("computer screens")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(20)
                .price(49.99)
                .image("not yet")
                .build();

        Coupon cou4 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("Regular keyboard")
                .description("computer keyboard")
                .startDate(Date.valueOf(LocalDate.of(2000, 01, 01)))
                .endDate(Date.valueOf(LocalDate.of(2000, 01, 02)))
                .amount(100)
                .price(19.99)
                .image("not yet")
                .build();

        Coupon cou5 = Coupon.builder()
                .category(Category.FOOD)
                .title("blabla")
                .description("dfgdfgdf")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(1)
                .price(1)
                .image("gfdgdf")
                .build();

        art.adminArt();
//        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  login admin  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
//        System.out.println(adminService.login("admin@admin.com","admin"));
//        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add companies  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
//        adminService.addCompany(comp1);
//        adminService.addCompany(comp2);
//        adminService.addCompany(comp3);
//        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add customers  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
        adminService.addCustomer(cr1);
        adminService.addCustomer(cr2);
        adminService.addCustomer(cr3);
        adminService.getAllCustomers().forEach(System.out::println);

        art.companyArt();
//        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  login company  -*-*-*-*-*-*-*-*-*-*-*-*-*-");
//        System.out.println(companyService.login("Dell@gmail.com","123"));
//        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-  add coupons  -*-*-*-*-*-*-*-*-*-*-*-*-*-");

        try {
            companyService.addCoupon(cou1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
