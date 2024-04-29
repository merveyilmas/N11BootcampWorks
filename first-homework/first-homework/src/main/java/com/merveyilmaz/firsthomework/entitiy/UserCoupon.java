package com.merveyilmaz.firsthomework.entitiy;

import com.merveyilmaz.firsthomework.enums.EnumGender;
import com.merveyilmaz.firsthomework.enums.EnumStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_coupons")
public class UserCoupon {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserCoupon")
    @SequenceGenerator(name = "UserCoupon", sequenceName = "USER_COUPON_ID_SEQ")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;
}
