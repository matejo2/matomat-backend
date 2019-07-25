package com.wilfer.matomatdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal account;

    public User(String name, BigDecimal account){
        setName(name);
        setAccount(account);
    }
}
