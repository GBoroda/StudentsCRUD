package org.misha.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "STUFF")
public class Stuff implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long good_id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private int price;

    public Stuff() {

    }

    public Stuff(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stuff stuff = (Stuff) o;

        return good_id == stuff.good_id;
    }

    @Override
    public int hashCode() {
        int result = (int) (good_id ^ (good_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "\nStuff{" +
                "ID: =" + good_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public long getGood_id() {
        return good_id;
    }

    public void setGood_id(long good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
