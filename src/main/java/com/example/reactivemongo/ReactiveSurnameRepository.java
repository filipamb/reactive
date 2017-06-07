package com.example.reactivemongo;

import lombok.Data;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ReactiveSurnameRepository extends ReactiveCrudRepository<Surname,String> {

}
