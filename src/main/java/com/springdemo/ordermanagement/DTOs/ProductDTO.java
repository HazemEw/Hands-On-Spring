package com.springdemo.ordermanagement.DTOs;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long product_id ;
    private String name ;
    private double price ;
    private String slug ;
    private String reference ;
    private Integer vat ;

}
