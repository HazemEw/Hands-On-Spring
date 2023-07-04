package com.springdemo.ordermanagement.DTOs;

import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Long stock_id;
    private Long product_id;
    private int quantity;
    private Date updateAt;


}
