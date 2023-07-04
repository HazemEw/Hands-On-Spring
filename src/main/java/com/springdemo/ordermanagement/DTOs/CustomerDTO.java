package com.springdemo.ordermanagement.DTOs;

import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long customer_id;
    private String first_name;
    private String last_name;
    private Date bornAt;
    private String email;
    private String password;
}
