package com.jb.couponsystemp2.clr.off;


import com.jb.couponsystemp2.beans.Category;
import com.jb.couponsystemp2.beans.Company;
import com.jb.couponsystemp2.beans.Coupon;
import com.jb.couponsystemp2.beans.Customer;
import com.jb.couponsystemp2.repos.CompanyRepository;
import com.jb.couponsystemp2.repos.CouponRepository;
import com.jb.couponsystemp2.repos.CustomerRepository;
import com.jb.couponsystemp2.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@Order(2)
@RequiredArgsConstructor
public class UseCase2 implements CommandLineRunner {


    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;

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

        art.companyArt();
        System.out.println("-------------------------  company  -------------------------");
        this.companyRepository.saveAll(Arrays.asList(comp1, comp2, comp3));
        this.companyRepository.findAll().forEach(System.out::println);


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


        art.customerArt();
        System.out.println("-------------------------  customer  -------------------------");
        this.customerRepository.saveAll(Arrays.asList(cr1, cr2, cr3));
        this.customerRepository.findAll().forEach(System.out::println);


        Coupon cou1 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("Plasma screen 24\"")
                .description("computer screens")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(99.99)
                .image("not yet")
                .company(comp1)
                .build();

        Coupon cou2 = Coupon.builder()
                .category(Category.FOOD)
                .title("Gamers keyboard")
                .description("computer keyboard")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(100)
                .price(19.99)
                .company(comp2)
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
                .company(comp1)
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
                .company(comp1)
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
                .company(comp2)
                .image("gfdgdf")
                .build();


        art.couponArt();
        System.out.println("-------------------------  coupon  -------------------------");
        this.couponRepository.saveAll(Arrays.asList(cou1, cou2, cou3, cou4, cou5));
        this.couponRepository.findAll().forEach(System.out::println);


    }
}
