package com.Foodease.FoodeaseApp.POJO;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "Im_Dish")
public class Dish implements Serializable {
    public static final long serialVersionUID=1234L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "categ_Id",nullable = false)
    private Category category;

    @Column(name = "description",length = 1000)
    private String description ;

    @ManyToOne
    @JoinColumn(name = "Rest_Id",nullable = false)
    private User user;

    @Column(name = "availability")
    private String availability;

}
