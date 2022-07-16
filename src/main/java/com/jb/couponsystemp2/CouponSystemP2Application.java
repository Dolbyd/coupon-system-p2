package com.jb.couponsystemp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = { "com.jb.couponsystemp2" }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.jb.couponsystemp2.clr.off.*"))
public class CouponSystemP2Application {

	public static void main(String[] args) {
		SpringApplication.run(CouponSystemP2Application.class, args);
	}

}
