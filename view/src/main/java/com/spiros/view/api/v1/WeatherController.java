package com.spiros.view.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    @GetMapping(value = "/city/{city}")
    public Map<String, String> readCommonContentBySupplyType(@PathVariable String city) {
        final Map<String, String> result = new LinkedHashMap<>();
        result.put("city", city);
        return result;
    }
}
