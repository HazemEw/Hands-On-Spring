package com.springdemo.ordermanagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductOrderId implements Serializable {

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "product_id")
    private Long product_id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrderId that = (ProductOrderId) o;
        return Objects.equals(order_id, that.order_id) &&
                Objects.equals(product_id, that.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, product_id);
    }

}
