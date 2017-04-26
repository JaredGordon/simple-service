package io.pivotal.ecosystem.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @RequestMapping("/")
    public String sayHello() {
        return "hello!";
    }
}