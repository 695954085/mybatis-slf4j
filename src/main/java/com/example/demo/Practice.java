package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Practice {

    private final CityMapper cityMapper;

    public Practice(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @RequestMapping("/")
    public void getCity(@RequestParam("id") String id) {
        City byState = cityMapper.findByState(id);
        System.out.println(byState.getCityName());
    }

}
