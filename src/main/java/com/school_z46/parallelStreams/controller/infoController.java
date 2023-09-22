package com.school_z46.parallelStreams.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;


@RestController
@RequestMapping("/info")
public class infoController {
   Logger logger = LoggerFactory.getLogger(infoController.class);

    @Value("${server.port:-1}")  // заинжектим его
    private int port;

    @GetMapping("port")
    public int getPort() {
        return port;
    }

    @GetMapping("/calculate")
    public void calculate() {
        int maxSize = 1_000_000;
        long startTime = System.currentTimeMillis();
        Stream.iterate(1, a -> a + 1)
                .limit(maxSize)
                .reduce(0, (a, b) -> a + b);
        long timeConsumed = System.currentTimeMillis() - startTime;
        logger.debug("время работы" + timeConsumed);


        startTime = System.currentTimeMillis();
        Integer reduce = Stream.iterate(1, a -> a + 1)
                .limit(maxSize)
                .reduce(0, Integer::sum);
        timeConsumed = System.currentTimeMillis() - startTime;
        logger.debug("время работы после оптимизации" + timeConsumed);



    }

}