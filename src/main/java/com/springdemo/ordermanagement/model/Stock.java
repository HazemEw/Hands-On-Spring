package com.springdemo.ordermanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue
    private Long stock_id ;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id ;

    @Column(name = "quantity")
    private int quantity ;

    @Column(name = "updateAt",nullable = false)
    private Date updateAt;

    @PrePersist
    private void onCreate() {
        updateAt = new Date();
    }



}
