package com.example.demo.hibernate;

import com.example.demo.City;
import com.example.demo.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@RestController(value = "practiceHibernate")
public class Practice {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping(value = "/hibernate")
    @Transactional
    public void map() {
        // create a couple of events...
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        entityManager.persist(new City("foshan", "guangdong"));
        Query from_city = entityManager.createQuery("from City");
        List resultList = from_city.getResultList();
        City byId = cityMapper.findById(6);
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
    }
}
