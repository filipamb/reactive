package com.example.reactivemongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.awt.*;
import java.time.Duration;

@RestController
public class SurnameController {

    private final ReactiveSurnameRepository reactiveSurnameRepository;

    @Autowired
    public SurnameController(ReactiveSurnameRepository reactiveSurnameRepository) {
        this.reactiveSurnameRepository = reactiveSurnameRepository;
    }

    @GetMapping(value = "/surname", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Surname> getAll() {
        Flux<Surname> result = reactiveSurnameRepository.findAll();
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));


        return Flux.zip(interval,result).map(Tuple2::getT2).log();
    }
}
