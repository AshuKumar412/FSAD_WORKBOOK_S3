package com.inventory.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.inventory.model.Product;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}