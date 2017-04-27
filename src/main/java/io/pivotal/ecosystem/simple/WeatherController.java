package io.pivotal.ecosystem.simple;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/forecast")
class WeatherController {

    private WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @RequestMapping(value = "/{zip}", method = RequestMethod.GET)
    public ResponseEntity<Map<Object, Object>> forcast(@PathVariable String zip) {
        return new ResponseEntity<>(weatherRepository.getForecast(zip), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> noLocation() {
        return new ResponseEntity<>("zipcode required", HttpStatus.BAD_REQUEST);
    }
}