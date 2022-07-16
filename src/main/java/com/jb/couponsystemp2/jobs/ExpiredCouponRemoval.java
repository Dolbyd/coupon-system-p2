package com.jb.couponsystemp2.jobs;


import com.jb.couponsystemp2.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;

@Component
public class ExpiredCouponRemoval {

    @Autowired
    private CouponRepository couponRepository;

    private static final int EXPIRED_TIME = 1000 * 60 * 60 * 24;

    @Scheduled(fixedRate = EXPIRED_TIME)
    @Transactional
    public void CouponExpirationDailyJob() {
        System.out.println("T is start");
        couponRepository.deleteByEndDateBefore(Date.valueOf(LocalDate.now()));
        System.out.println("T is end");
    }
}
