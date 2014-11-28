package org.misha.dao;

import org.misha.entity.Stuff;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StuffDaoImpl implements StuffDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Stuff> getAllStuff() {
        return sessionFactory.getCurrentSession().createQuery("FROM Stuff").list();
    }

    @Override
    @Transactional(readOnly = false)
    public Long addStuffToStore(String name, int price) {
        Stuff stuff = new Stuff(name, price);
        return (Long) sessionFactory.getCurrentSession().save(stuff);
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePriceById(long good_id, int newPrice) {
        Query query = sessionFactory.getCurrentSession().createQuery("UPDATE Stuff SET price = :newPrice WHERE good_id = :stuffGood_id");
        query.setParameter("newPrice", newPrice).setParameter("stuffGood_id", good_id).executeUpdate();
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePriceByName(String name, int newPrice) {
        Query query = sessionFactory.getCurrentSession().createQuery("UPDATE Stuff SET price = :newPrice WHERE name = :stuffName");
        query.setParameter("newPrice", newPrice).setParameter("stuffName", name).executeUpdate();
    }

    @Override
    @Transactional(readOnly = false)
    public void removeStuffFromStore(long good_id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Stuff c WHERE  c.good_id = :stuffGood_id");
        query.setParameter("stuffGood_id", good_id).executeUpdate();
    }

}
