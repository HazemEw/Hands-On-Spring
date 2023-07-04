package com.springdemo.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "product")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long product_id ;
    @Column(name = "slug",nullable = false)
    private String slug ;

    @Column(name = "reference",nullable = false)
    private String reference ;
    @Column(name = "vat",nullable = false)
    private Integer vat ;

    @Column(name = "name",nullable = false)
    private String name ;

    @Column(name = "price",nullable = false)
    private Double price ;


    @JsonIgnore

    @OneToMany(mappedBy = "product", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrder> productOrders = new ArrayList<>();

}
