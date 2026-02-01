package com.suhail.learn_spring.Ai.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(


        name="Product_table",
        uniqueConstraints = {
                @UniqueConstraint(name="sku_unique",columnNames = {"sku"}),
                @UniqueConstraint(name = "tittle_price_unique",columnNames = {"tittle_x","price"})
        },
        indexes = {
         @Index(name="sku_index",columnList = "sku")
        }



)
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false,length = 20)
    private String sku;
    @Column(name = "tittle_x")
    private String tittle;

    private BigDecimal price;

    private Integer quantity;
    @CreationTimestamp
    private LocalDateTime createdAt;
  @UpdateTimestamp
    private LocalDateTime  updatedAt;
}
