package org.misha.main;

import org.misha.dao.StuffDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        StuffDao dao = context.getBean(StuffDao.class);

        System.out.println("TEST ADD");
        dao.addStuffToStore("gold", 999);

        System.out.println("\n LETS REMOVE OLD STUFF");
        dao.removeStuffFromStore(1);
        System.out.println(dao.getAllStuff());

        System.out.println("\n\n AND ADD SOME STUFF \n");
        dao.addStuffToStore("iceCream", 3);
        dao.addStuffToStore("BBQ", 2);
        System.out.println(dao.getAllStuff());

        System.out.println("\n\n UPDATE THEIR PRICE BY ID");
        dao.updatePriceById(2, 100);

        System.out.println("\n AND BY NAME");
        dao.updatePriceByName("gold", 1);

        System.out.println("Lets see changes");
        System.out.println(dao.getAllStuff());

    }
}
