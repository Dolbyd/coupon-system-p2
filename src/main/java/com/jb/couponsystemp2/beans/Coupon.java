package com.jb.couponsystemp2.beans;


import com.jb.couponsystemp2.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 40, nullable = false)
    private Category category;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String description;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String image;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", category=" + category +
                ", company=" + company +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + DateUtil.beautifyDate(startDate) +
                ", endDate=" + DateUtil.beautifyDate(endDate) +
                ", amount=" + amount +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
