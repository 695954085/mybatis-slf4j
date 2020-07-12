package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class Practice {

    private final CityMapper cityMapper;

    public Practice(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/")
    @Transactional
    public void getCity(@RequestParam("state") String state, @RequestParam("cityName") String cityName) {
        cityMapper.insertCity(cityName, state);
        insertMethods();
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(new City("ZHANJIANG", "GUANGDONG"));
//        throw new UnsupportedOperationException();
    }

    private void insertMethods() {
        cityMapper.insertCity("SHANTOU", "GUANGDONG");
    }

}
