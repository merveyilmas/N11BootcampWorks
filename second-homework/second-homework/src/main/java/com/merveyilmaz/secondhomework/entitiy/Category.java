package com.merveyilmaz.secondhomework.entitiy;

import com.merveyilmaz.secondhomework.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CATEGORIES")
public class Category extends BaseEntity {

    @SequenceGenerator(name = "Category", sequenceName = "CATEGORY_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Category")
    @Id
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
}
