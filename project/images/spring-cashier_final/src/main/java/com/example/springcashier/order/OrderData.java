package com.example.springcashier.order;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "id")
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "orderID",nullable = false)
//    @GeneratedValue(generator="system_uuid")
//    @GenericGenerator(name="system_uuid",strategy="uuid")
    private Integer id;
//    @Column
//    @Type(type="uuid-char")
//    private UUID uuid;

    private String register;
    private String drink;
    private String milk;
    private String size;

    private String status;

    private String total;




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }


    public void setTotal(String total) {
        this.total = total;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }
}
