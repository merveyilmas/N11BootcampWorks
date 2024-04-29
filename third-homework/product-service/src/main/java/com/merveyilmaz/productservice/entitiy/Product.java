package com.merveyilmaz.productservice.entitiy;

import com.merveyilmaz.productservice.enums.EnumStatus;
import com.merveyilmaz.productservice.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
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

    @Column(name = "CATEGORY_ID", nullable = false)
    private Long categoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 30, nullable = false)
    private EnumStatus status;
}
