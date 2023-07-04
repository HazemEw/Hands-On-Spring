package com.springdemo.ordermanagement.DTOs;

import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long order_id;
    private Long customer_id;
    private Date orderAt;
}
