package com.merveyilmaz.secondhomework.entitiy;

import com.merveyilmaz.secondhomework.enums.EnumStatus;
import com.merveyilmaz.secondhomework.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Product")
    @Id
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PRICE", length = 100, nullable = false)
    private double price;

    @Column(name = "EXPIRATION_DATE", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "DESCRIPTION", length = 300)
    private String description;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id", nullable = false)
    private Category categoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 30, nullable = false)
    private EnumStatus status;
}
