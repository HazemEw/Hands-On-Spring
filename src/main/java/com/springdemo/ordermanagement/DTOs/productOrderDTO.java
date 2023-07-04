package com.springdemo.ordermanagement.DTOs;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class productOrderDTO {

    private Long order_id;
    private Long product_id;
    private Integer quantity;
    private Double price;
    private Integer vat;
}
