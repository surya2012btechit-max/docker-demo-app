package com.surya.dockerdemoapp;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Counter helloCounter;

    // Inject Micrometer's MeterRegistry to build custom metrics
    public HelloController(MeterRegistry registry) {
        this.helloCounter = Counter.builder("app.hello.requests.total")
                .description("Total number of requests to hello endpoint")
                .register(registry);
    }

    @GetMapping("/")
    public String hello() {
        // Increment our custom metric every time the endpoint is hit
        helloCounter.increment();
        return "Hello Surya from Kubernates! config map";
    }

    @GetMapping("/healthz")
    public String liveness() {
        return "OK";
    }

    @GetMapping("/ready")
    public String readiness() {
        return "READY";
    }
}