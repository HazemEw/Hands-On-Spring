package com.springdemo.ordermanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long order_id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private Date orderAt;

    @PrePersist
    private void onCreate() {
        orderAt = new Date();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "order", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrder> productOrders = new ArrayList<>();



}
