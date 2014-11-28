package org.misha.dao;

import org.misha.entity.Stuff;

import java.util.List;

public interface StuffDao {

    List<Stuff> getAllStuff();

    Long addStuffToStore(String name, int price);

    void updatePriceById(long good_id, int newPrice);
    void updatePriceByName(String name, int newPrice);

    void removeStuffFromStore(long good_id);

}
