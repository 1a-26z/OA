//package com.online_shop.repository.impl;
//
//import com.online_shop.entity.Order;
//import com.online_shop.repository.CustomizedOrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;

//@Repository
//public class CustomizedOrderRepositoryImpl implements CustomizedOrderRepository {


//    private final EntityManager entityManager;
//
//    @Autowired
//    public CustomizedOrderRepositoryImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Override
//    public List<Order> getOrdersByCustomer(Long customer_id) {
//        Query query = entityManager.createNativeQuery("", Order.class);
//        query.setParameter(1, "");
//        return null;
//    }


//}
