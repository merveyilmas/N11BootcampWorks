package com.merveyilmaz.firsthomework.entitiy;

import com.merveyilmaz.firsthomework.enums.EnumGender;
import com.merveyilmaz.firsthomework.enums.EnumRate;
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
@Table(name = "user_reviews")
public class UserReview {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserReview")
    @SequenceGenerator(name = "UserReview", sequenceName = "USER_REVİEW_ID_SEQ")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "RATE", length = 30, nullable = false)
    private EnumRate rate;

    @Column(name = "COMMENT", length = 200)
    private String comment;
}
