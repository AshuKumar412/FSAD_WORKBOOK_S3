package com.inventory.app;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.iventory.model.Product;
import com.inventory.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Session session;
        Transaction tx;
        int choice;

        do {

            System.out.println("\n1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();   // clear buffer

            switch(choice) {

            case 1:

                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();

                System.out.print("Enter product name: ");
                String name = sc.nextLine();

                System.out.print("Enter product description: ");
                String des = sc.nextLine();

                System.out.print("Enter product price: ");
                double price = sc.nextDouble();

                System.out.print("Enter product quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                Product p = new Product(name, des, price, quantity);

                session.save(p);
                tx.commit();
                session.close();

                System.out.println("Product added successfully");
                break;

            case 2:

                session = HibernateUtil.getSessionFactory().openSession();

                System.out.print("Enter Product id: ");
                int id = sc.nextInt();

                Product pr = session.get(Product.class, id);

                if(pr != null) {
                    System.out.println("Product Name: " + pr.getName());
                    System.out.println("Product Description: " + pr.getDes());
                    System.out.println("Product Price: " + pr.getPrice());
                    System.out.println("Product Quantity: " + pr.getQuantity());
                } else {
                    System.out.println("Product not found");
                }

                session.close();
                break;

            case 3:

                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();

                System.out.print("Enter Product id: ");
                int uid = sc.nextInt();
                sc.nextLine();

                Product pu = session.get(Product.class, uid);

                if(pu != null) {

                    System.out.print("Enter new product name: ");
                    pu.setName(sc.nextLine());

                    System.out.print("Enter new description: ");
                    pu.setDes(sc.nextLine());

                    System.out.print("Enter new price: ");
                    pu.setPrice(sc.nextDouble());

                    System.out.print("Enter new quantity: ");
                    pu.setQuantity(sc.nextInt());

                    session.update(pu);
                    tx.commit();

                    System.out.println("Record updated successfully");

                } else {
                    System.out.println("Product not found");
                }

                session.close();
                break;

            case 4:

                session = HibernateUtil.getSessionFactory().openSession();
                tx = session.beginTransaction();

                System.out.print("Enter Product id: ");
                int did = sc.nextInt();

                Product pd = session.get(Product.class, did);

                if(pd != null) {
                    session.delete(pd);
                    tx.commit();
                    System.out.println("Product deleted successfully");
                } else {
                    System.out.println("Product not found");
                }

                session.close();
                break;

            }

        } while(choice != 5);

        sc.close();
    }
}