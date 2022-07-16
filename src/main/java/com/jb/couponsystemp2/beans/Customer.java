package com.jb.couponsystemp2.beans;


import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40, nullable = false)
    private String firsName;
    @Column(length = 40, nullable = false)
    private String lastName;
    @Column(length = 40, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String password;

    @ManyToMany
    @Singular
    private List<Coupon> coupons = new LinkedList<>();


}
