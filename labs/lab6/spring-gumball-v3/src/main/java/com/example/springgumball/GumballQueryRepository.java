package com.example.springgumball;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*

	https://www.baeldung.com/spring-data-query-by-example
	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example

*/

@Repository
public interface GumballQueryRepository extends JpaRepository<GumballModel, Integer> {

}