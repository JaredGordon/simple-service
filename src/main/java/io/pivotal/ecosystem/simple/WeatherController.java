package io.pivotal.ecosystem.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    @RequestMapping(value = "/forecast/{zip}", method = RequestMethod.GET)
    public Map<Object, Object> forcast(@PathVariable String zip) {
        if (zip == null) {
            return null;
        }
        return weatherRepository.getForecast(zip);
    }
}