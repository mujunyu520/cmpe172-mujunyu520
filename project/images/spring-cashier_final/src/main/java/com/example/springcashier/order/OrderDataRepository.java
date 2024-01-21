package com.example.springcashier.order;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderDataRepository extends CrudRepository<OrderData,Integer> {

    public List<OrderData> findByRegister(String register);

}
