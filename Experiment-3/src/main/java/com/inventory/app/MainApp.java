package com.inventory.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.inventory.model.Product;
import com.inventory.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Insert sample records
        session.save(new Product("Laptop","Electronics",60000,10));
        session.save(new Product("Mouse","Electronics",500,50));
        session.save(new Product("Keyboard","Electronics",1500,30));
        session.save(new Product("Notebook","Stationery",100,100));
        session.save(new Product("Pen","Stationery",20,200));
        session.save(new Product("Printer","Electronics",8000,5));

        tx.commit();

        // Sort by price ASC
        Query<Product> q1 = session.createQuery(
                "FROM Product ORDER BY price ASC", Product.class);

        List<Product> list1 = q1.list();

        System.out.println("Sorted by price ASC");
        for(Product p : list1) {
            System.out.println(p.getName()+" "+p.getPrice());
        }

        // Sort by price DESC
        Query<Product> q2 = session.createQuery(
                "FROM Product ORDER BY price DESC", Product.class);

        System.out.println("\nSorted by price DESC");
        for(Product p : q2.list()) {
            System.out.println(p.getName()+" "+p.getPrice());
        }

        // Pagination first 3
        Query<Product> q3 = session.createQuery("FROM Product", Product.class);
        q3.setFirstResult(0);
        q3.setMaxResults(3);

        System.out.println("\nFirst 3 products");
        for(Product p : q3.list()) {
            System.out.println(p.getName());
        }

        // Count products
        Query<Long> q4 = session.createQuery(
                "SELECT COUNT(*) FROM Product", Long.class);

        System.out.println("\nTotal Products: "+q4.uniqueResult());

        // Min and Max price
        Query<Object[]> q5 = session.createQuery(
                "SELECT MIN(price), MAX(price) FROM Product", Object[].class);

        Object[] result = q5.uniqueResult();

        System.out.println("Min Price: "+result[0]);
        System.out.println("Max Price: "+result[1]);

        // LIKE example
        Query<Product> q6 = session.createQuery(
                "FROM Product WHERE name LIKE 'P%'", Product.class);

        System.out.println("\nNames starting with P");
        for(Product p : q6.list()) {
            System.out.println(p.getName());
        }

        session.close();
    }
}