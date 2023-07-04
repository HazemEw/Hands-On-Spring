package com.springdemo.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_order")
public class ProductOrder {
    @EmbeddedId
    private ProductOrderId id;
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;



    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
    @Column(name = "vat")
    private Integer vat;
}
